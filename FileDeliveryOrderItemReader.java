package com.oms.delivery_microservice.file;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.ClassPathResource;

public class FileDeliveryOrderItemReader extends FlatFileItemReader<FileDeliveryOrder>{

    public FileDeliveryOrderItemReader() {
        setResource(new ClassPathResource("input.csv")); // file path
        setLineMapper(new DefaultLineMapper<FileDeliveryOrder>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames(new String[]{"orderId", "quantity", "customerName", "customerAddress"});
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<FileDeliveryOrder>() {{
                setTargetType(FileDeliveryOrder.class);
            }});
        }});
    }
}
