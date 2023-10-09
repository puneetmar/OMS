package com.demoo.deliverymicroservice.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demoo.deliverymicroservice.Entity.Delivery;
import com.demoo.deliverymicroservice.Service.DeliveryService;

@RestController
public class DeliveryController {

     private final DeliveryService deliveryService;

  public DeliveryController(DeliveryService deliveryService) {
    this.deliveryService = deliveryService;
  }

  @PostMapping("/api/v1/deliveries")
  public ResponseEntity<Delivery> createDelivery(@RequestBody Delivery delivery) {
    Delivery savedDelivery = deliveryService.createDelivery(delivery);

    // Return the delivery object
    return ResponseEntity.ok(savedDelivery);
  }
    
}
