package com.oms.delivery_microservice.batch;

import java.util.List;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.lang.NonNull;

import com.oms.delivery_microservice.Entity.DeliveryOrder;

public class DeliveryBatchItemWriter implements ItemWriter<DeliveryOrder> {

    @Override
    public void write(List<? extends DeliveryOrder> items) throws Exception {
        for (DeliveryOrder item : items) {


            //Do something with the database
        }
    }
    @Override
    public void write(@NonNull Chunk<? extends DeliveryOrder> arg0) throws Exception {
        // Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'write'");
    }
}