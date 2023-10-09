package com.oms.delivery_microservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.oms.delivery_microservice.Entity.DeliveryOrder;
import com.oms.delivery_microservice.Service.DeliveryService;

@RestController
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @PostMapping("/api/v1/delivery")
    public ResponseEntity<Void> putOrderInDelivery(@RequestBody DeliveryOrder deliveryOrder) {
        // putt the order into the delivery table
        deliveryService.putOrderInDelivery(deliveryOrder);
        return ResponseEntity.ok().build();
    }

}
