package com.oms.delivery_microservice.batch;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.lang.Nullable;

import com.oms.delivery_microservice.Entity.DeliveryOrder;

public class DeliveryOrderItemReader implements ItemReader<DeliveryOrder> {

    @Override
    @Nullable
    public DeliveryOrder read()
            throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read'");
    }

    
}
