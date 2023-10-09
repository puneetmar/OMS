package com.oms.ordermicroservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryOrder {

    private Integer orderId;
    private Integer quantity;
    private String customerName;
    private String customerAddress;
    private String status;
    private String restaurant_id;
    private Integer productId;

}
