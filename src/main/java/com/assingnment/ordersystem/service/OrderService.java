package com.assingnment.ordersystem.service;

import static com.assingnment.ordersystem.model.MenuItemSize.DEFAULT;
import static com.assingnment.ordersystem.model.MenuItemSize.LARGE;
import static com.assingnment.ordersystem.model.MenuItemSize.SMALL;

import com.assingnment.ordersystem.model.Menu;
import com.assingnment.ordersystem.model.MenuItem;
import com.assingnment.ordersystem.model.Order;
import com.assingnment.ordersystem.model.OrderInvoice;
import com.assingnment.ordersystem.model.OrderItem;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Value("${order.gst}")
    private float appliedGst;

    public OrderInvoice processOrder(Order order) {
        final List<OrderItem> orderItems = order.getOrderItems();
        if (CollectionUtils.isNotEmpty(orderItems)) {
            OrderInvoice orderInvoice = new OrderInvoice();
            orderInvoice.setOrder(order);
            double grossAmt = 0;
            for (OrderItem orderItem : orderItems) {
                grossAmt += orderItem.getMenuItem().getPriceIncGst() * orderItem.getQuantity();
            }
            double gstRate = appliedGst / 100;
            double gst = grossAmt * gstRate / (1 + gstRate);

            orderInvoice.setInvoiceId("INV-" + order.getOrderId());
            orderInvoice.setTotalAfterTax(grossAmt);
            orderInvoice.setGst(gst);
            return orderInvoice;
        }
        return null;
    }

    public Menu fetchMenu() {
        //In real application fetch from db
        Menu menu = new Menu();
        List<MenuItem> menuItems = new ArrayList<>();
        menu.setMenuItems(menuItems);
        MenuItem chickenBurger = new MenuItem();
        chickenBurger.setId(1);
        chickenBurger.setSize(DEFAULT);
        chickenBurger.setDescription("Chicken Burger with ingredients...");
        chickenBurger.setPriceIncGst(20);
        chickenBurger.setItemName("Chicken Burger");
        menuItems.add(chickenBurger);
        MenuItem cheeseBurger = new MenuItem();
        cheeseBurger.setId(2);
        cheeseBurger.setSize(DEFAULT);
        cheeseBurger.setDescription("Cheese Burger with ingredients...");
        cheeseBurger.setPriceIncGst(15);
        cheeseBurger.setItemName("Cheese Burger");
        menuItems.add(cheeseBurger);
        MenuItem smallSoftDrink = new MenuItem();
        smallSoftDrink.setId(3);
        smallSoftDrink.setSize(SMALL);
        smallSoftDrink.setDescription("Small soft drink with calories...");
        smallSoftDrink.setPriceIncGst(4);
        smallSoftDrink.setItemName("Soft drink");
        menuItems.add(smallSoftDrink);
        MenuItem largeSoftDrink = new MenuItem();
        largeSoftDrink.setId(4);
        largeSoftDrink.setSize(LARGE);
        largeSoftDrink.setDescription("Large soft drink with calories...");
        largeSoftDrink.setPriceIncGst(5);
        largeSoftDrink.setItemName("Soft drink");
        menuItems.add(largeSoftDrink);
        MenuItem beefBurger = new MenuItem();
        beefBurger.setId(5);
        beefBurger.setSize(DEFAULT);
        beefBurger.setDescription("Beef Burger with ingredients...");
        beefBurger.setPriceIncGst(22);
        beefBurger.setItemName("Beef Burger");
        menuItems.add(beefBurger);
        return menu;
    }


}
