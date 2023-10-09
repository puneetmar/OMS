package com.oms.delivery_microservice.Service;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.oms.delivery_microservice.Entity.DeliveryOrder;
import com.oms.delivery_microservice.batch.DeliveryOrderRowMapper;

@Service
public class DeliveryService {

    private final JdbcTemplate jdbcTemplate;

    public DeliveryService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

     public List<DeliveryOrder> getAllDeliveryOrders() {
        String sql = "SELECT * FROM delivery_table";
        return jdbcTemplate.query(sql, new DeliveryOrderRowMapper());
    }

    public void putOrderInDelivery(DeliveryOrder deliveryOrder) {
        String sql = "INSERT INTO delivery_table (order_id, quantity, customer_name, customer_address) VALUES (?, ?, ?, ?)";

        jdbcTemplate.update(sql, deliveryOrder.getOrderId(), deliveryOrder.getQuantity(),
                deliveryOrder.getCustomerName(), deliveryOrder.getCustomerAddress());
    }
}