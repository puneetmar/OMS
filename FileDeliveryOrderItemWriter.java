package com.oms.delivery_microservice.file;

import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.batch.item.file.transform.FieldExtractor;
import org.springframework.core.io.FileSystemResource;

public class FileDeliveryOrderItemWriter extends FlatFileItemWriter<FileDeliveryOrder> {

    public FileDeliveryOrderItemWriter() {
        setResource(new FileSystemResource("output.csv")); // Specify your output file path
        setLineAggregator(new DelimitedLineAggregator<FileDeliveryOrder>() {{
            setDelimiter(",");
            setFieldExtractor(new FieldExtractor<FileDeliveryOrder>() {
                @Override
                public Object[] extract(FileDeliveryOrder item) {
                    return new Object[]{
                        item.getOrderId(),
                        item.getQuantity(),
                        item.getCustomerName(),
                        item.getCustomerAddress()
                    };
                }
            });
        }});
    }
    
}
