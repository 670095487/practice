package com.yunn.autumnnacos;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@NacosPropertySource(dataId = "merchant-service", autoRefreshed = true)
@MapperScan("com.yunn.autumnnacos.mapper")
public class AutumnNacosApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutumnNacosApplication.class, args);
    }

}
