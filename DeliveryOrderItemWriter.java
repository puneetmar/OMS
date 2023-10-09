package com.oms.delivery_microservice.batch;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.lang.NonNull;

import com.oms.delivery_microservice.Entity.DeliveryOrder;

public class DeliveryOrderItemWriter implements ItemWriter<DeliveryOrder> {

    @Override
    public void write(@NonNull Chunk<? extends DeliveryOrder> arg0) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'write'");
    }
    
}
