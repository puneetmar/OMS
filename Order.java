package com.oms.ordermicroservice.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Order {

    private Integer orderId;

    private String productName;

    private Integer quantity;

    private Integer restaurantId;

    private String customerName;

    private String customerAddress;

    private String restaurantName;

}
