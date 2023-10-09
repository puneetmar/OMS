package com.oms.delivery_microservice.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import com.oms.delivery_microservice.Entity.DeliveryOrder;

public class DeliveryOrderItemProcessor implements ItemProcessor<DeliveryOrder, DeliveryOrder> {

    @Override
    @Nullable
    public DeliveryOrder process(@NonNull DeliveryOrder arg0) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'process'");
    }
    
}
