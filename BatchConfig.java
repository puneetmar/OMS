package com.oms.delivery_microservice.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;

import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.oms.delivery_microservice.Entity.DeliveryOrder;
import com.oms.delivery_microservice.Service.DeliveryService;
import com.oms.delivery_microservice.file.FileDeliveryOrder;
import com.oms.delivery_microservice.file.FileDeliveryOrderItemReader;
import com.oms.delivery_microservice.file.FileDeliveryOrderItemWriter;

@Configuration
@EnableBatchProcessing
public class BatchConfig {



    @Autowired
    private FileDeliveryOrderItemReader fileDeliveryOrderItemReader;

    @Autowired
    private FileDeliveryOrderItemWriter fileDeliveryOrderItemWriter;


    @Autowired
    private DeliveryService deliveryService;

    @Bean
    public Step readDataStep() {
        return stepBuilderFactory.get("readDataStep")
            .<DeliveryOrder, DeliveryOrder>chunk(10)
            .reader(deliveryOrderItemReader())
            .processor(deliveryOrderItemProcessor())
            .writer(deliveryOrderItemWriter())
            .build();
    }

    @Bean
    public Job readDataJob() {
        return jobBuilderFactory.get("readDataJob")
            .incrementer(new RunIdIncrementer())
            .flow(readDataStep())
            .end()
            .build();
    }

    @Bean
    public DeliveryOrderItemReader deliveryOrderItemReader() {
        return new DeliveryOrderItemReader();
    }

    @Bean
    public DeliveryOrderItemProcessor deliveryOrderItemProcessor() {
        return new DeliveryOrderItemProcessor();
    }

    @Bean
    public DeliveryOrderItemWriter deliveryOrderItemWriter() {
        return new DeliveryOrderItemWriter();
    }
    @Bean
    public Step readDataFromFileStep() {
        return stepBuilderFactory.get("readDataFromFileStep")
            .<FileDeliveryOrder, FileDeliveryOrder>chunk(10)
            .reader(fileDeliveryOrderItemReader)
            .processor(deliveryOrderItemProcessor())
            .writer(deliveryOrderItemWriter())
            .build();
    }

    @Bean
    public Job readDataFromFileJob() {
        return jobBuilderFactory.get("readDataFromFileJob")
            .incrementer(new RunIdIncrementer())
            .flow(readDataFromFileStep())
            .end()
            .build();
    }

    @Bean
    public Step writeDataToFileStep() {
        return stepBuilderFactory.get("writeDataToFileStep")
            .<FileDeliveryOrder, FileDeliveryOrder>chunk(10)
            .reader(deliveryOrderItemReader())
            .processor(deliveryOrderItemProcessor())
            .writer(fileDeliveryOrderItemWriter)
            .build();
    }

    @Bean
    public Job writeDataToFileJob() {
        return jobBuilderFactory.get("writeDataToFileJob")
            .incrementer(new RunIdIncrementer())
            .flow(writeDataToFileStep())
            .end()
            .build();
    }




}