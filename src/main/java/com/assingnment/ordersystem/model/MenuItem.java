package com.assingnment.ordersystem.model;

import lombok.Data;

@Data
public class MenuItem {

    private int id;
    private MenuItemSize size;
    private String itemName;
    private double priceIncGst;
    private String description;
}
