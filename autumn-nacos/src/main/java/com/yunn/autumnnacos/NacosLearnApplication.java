package com.yunn.autumnnacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @NacosPropertySource(dataId = "merchant-service", autoRefreshed = true)
public class NacosLearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosLearnApplication.class, args);
    }

}
