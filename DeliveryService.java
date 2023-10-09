package com.demoo.deliverymicroservice.Service;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.demoo.deliverymicroservice.Entity.Delivery;
import jakarta.transaction.Transactional;


@Service
public class DeliveryService {

     private final JdbcTemplate jdbcTemplate;

  public DeliveryService(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Transactional
  public Delivery createDelivery(Delivery delivery) {

    // Insert delivery into database
    jdbcTemplate.update("INSERT INTO deliveries (order_id, quantity, customer_name, customer_address, delivery_status) VALUES (?, ?, ?, ?, ?)",
      delivery.getOrderId(), delivery.getQuantity(), delivery.getCustomerName(), delivery.getCustomerAddress(), delivery.getDeliveryStatus());

    // Get the delivery id of the inserted delivery
    Integer deliveryId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);

    // Set the delivery id on the delivery object
    delivery.setDeliveryId(deliveryId);

    // Return the delivery object
    return delivery;
  }
    
}