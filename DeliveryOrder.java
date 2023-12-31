package com.oms.delivery_microservice.Entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class DeliveryOrder {
    

    private Integer orderId;

    private Integer quantity;

    private String customerName;

    private String customerAddress;

}
