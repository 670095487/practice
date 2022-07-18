package com.yunn.autumnnacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
// @NacosPropertySource(dataId = "merchant-service", autoRefreshed = true)
@EnableConfigurationProperties
public class NacosLearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosLearnApplication.class, args);
    }

}
