package com.assingnment.ordersystem.model;

import java.util.List;
import lombok.Data;

@Data
public class Order {
    private String orderId;
    private List<OrderItem> orderItems;
}
