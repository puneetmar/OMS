package com.oms.delivery_microservice.file;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class FileDeliveryOrder {
    private Integer orderId;
    private Integer quantity;
    private String customerName;
    private String customerAddress;
    
}
