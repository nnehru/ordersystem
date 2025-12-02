package com.assingnment.ordersystem.model;

import lombok.Data;

@Data
public class OrderItem {

    private MenuItem menuItem;
    private int quantity;
    private double subtotal;

    public double getSubtotal() {
        return menuItem.getPriceIncGst() * quantity;
    }

}
