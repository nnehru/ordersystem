package com.assingnment.ordersystem.model;

import java.util.List;
import lombok.Data;

@Data
public class OrderInvoice {

    private String invoiceId;
    private List<OrderItem> orderItems;
    private double gst;
    private double totalAfterTax;

}
