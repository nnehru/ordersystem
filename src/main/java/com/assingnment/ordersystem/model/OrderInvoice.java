package com.assingnment.ordersystem.model;

import java.util.List;
import lombok.Data;

@Data
public class OrderInvoice {

    private String invoiceId;
    private Order order;
    private double gst;
    private double totalAfterTax;

}
