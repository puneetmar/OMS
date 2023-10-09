package com.oms.ordermicroservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.oms.ordermicroservice.Entity.Order;
import com.oms.ordermicroservice.Service.OrderService;
import com.oms.ordermicroservice.dto.DeliveryOrder;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    @Autowired
    private final OrderService orderService;

    // RestTemplate to make HTTP requests to delivery microservice
    // @Autowired
    // private RestTemplate restTemplate;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping()
    public ResponseEntity<?> createOrder(@RequestBody Order order) {
        DeliveryOrder savedOrder = orderService.createOrder(order);
        return ResponseEntity.ok(savedOrder);
    }

}