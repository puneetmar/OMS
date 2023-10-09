package com.oms.delivery_microservice.batch;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.tree.RowMapper;

public class DeliveryOrderRowMapper<DeliveryOrder> implements RowMapper<DeliveryOrder>{

      @Override
    public DeliveryOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
        DeliveryOrder deliveryOrder = new DeliveryOrder();
        deliveryOrder.setOrderId(rs.getInt("order_id"));
        deliveryOrder.setQuantity(rs.getInt("quantity"));
        deliveryOrder.setCustomerName(rs.getString("customer_name"));
        deliveryOrder.setCustomerAddress(rs.getString("customer_address"));
        return deliveryOrder;
    }
}