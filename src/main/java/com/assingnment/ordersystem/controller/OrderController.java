package com.assingnment.ordersystem.controller;

import com.assingnment.ordersystem.model.Menu;
import com.assingnment.ordersystem.model.Order;
import com.assingnment.ordersystem.model.OrderInvoice;
import com.assingnment.ordersystem.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    /**
     * http://localhost:8080/order/menu
     * @return Menu
     */
    @GetMapping("/menu")
    public ResponseEntity<Menu> getOrderInvoices() {
        final Menu menu = orderService.fetchMenu();
        return new ResponseEntity<>(menu, HttpStatus.OK);
    }

    /**
     * http://localhost:8080/order/place
     * @param order -> customer order
     * @return order invoice
     */
    @PostMapping("/place")
    public ResponseEntity<OrderInvoice> placeOrder(@RequestBody final Order order) {
        OrderInvoice orderInvoice = orderService.processOrder(order);
        return new ResponseEntity<>(orderInvoice, HttpStatus.OK);
    }

}
