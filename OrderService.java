package com.oms.ordermicroservice.Service;

import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.oms.ordermicroservice.Entity.Order;
import com.oms.ordermicroservice.dto.DeliveryOrder;

@Service
public class OrderService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public DeliveryOrder createOrder(Order order) {

        // Get restaurant id based on restaurant name

        Integer id = jdbcTemplate
                .query("SELECT restaurant_id FROM restaurants WHERE restaurant_name =" + order.getRestaurantName(),
                        (rs, rowNum) -> {
                            return rs.getInt("restaurant_id");
                        })
                .get(0);

        Map<String, Object> price = jdbcTemplate
                .queryForMap("SELECT product_id,price FROM products WHERE product_name = ?",
                        order.getProductName());

        Set<Entry<String, Object>> entrySet = price.entrySet();
        int product_id = 0;
        int pricee = 0;
        entrySet.forEach(e -> {
            product_id = Integer.parseInt(e.getKey());
            pricee = Integer.parseInt(e.getValue());
        });

        // Update order entity with restaurant id
        order.setRestaurantId(id);

        // Insert order into database
        jdbcTemplate.update(
                "INSERT INTO orders (product_name, quantity, restaurant_id, customer_name, customer_address) VALUES (?, ?, ?, ?, ?)",
                order.getProductName(), order.getQuantity(), order.getRestaurantId(), order.getCustomerName(),
                order.getCustomerAddress());

        // Calculate bill amount
        // Double billAmount = calculateBillAmount(order);

        // Send a request to the delivery microservice to deliver the order
        DeliveryOrder deliveryOrder = new DeliveryOrder();
        deliveryOrder.setOrderId(order.getOrderId());
        deliveryOrder.setQuantity(order.getQuantity());
        deliveryOrder.setCustomerName(order.getCustomerName());
        deliveryOrder.setCustomerAddress(order.getCustomerAddress());
        deliveryOrder.setStatus("IN PROCESSING");

        DeliveryOrder delorder = restTemplate.postForEntity("http://localhost:7000/api/v1/delivery",
                deliveryOrder, DeliveryOrder.class).getBody();

        return delorder;
    }

}

// Helper method to get product price based on product ID (You should implement
// this)
// private double getProductPrice(Integer productId) {
// // You should implement logic to retrieve the product price based on the
// productId
// // For example, you can query the database to get the price of the product.
// // Replace this with your actual implementation.
// return 10.0; // Replace with your logic
// }

// Helper method to calculate bill amount
// private double calculateBillAmount(Integer quantity, double price) {
// return quantity * price;
// }

// public Double calculateBillAmount(Order order) {
// // Get the product price from the database
// Double price = jdbcTemplate.queryForObject("SELECT price FROM products WHERE
// product_id = ?", Double.class,
// order.getProductName());

// // Calculate the bill amount
// Double billAmount = price * order.getQuantity();

// return billAmount;
// }