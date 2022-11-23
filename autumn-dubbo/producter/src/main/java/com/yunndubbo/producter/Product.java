package com.yunndubbo.producter;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class Product {

    public static void main(String[] args) {
        SpringApplication.run(Product.class, args);
    }

}
