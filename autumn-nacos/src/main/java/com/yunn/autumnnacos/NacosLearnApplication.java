package com.yunn.autumnnacos;

import com.yunn.autumnnacos.config.AsyncConfig;
import com.yunn.autumnnacos.service.AsyncTaskService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Executor;

@SpringBootApplication
// @NacosPropertySource(dataId = "merchant-service", autoRefreshed = true)
@EnableConfigurationProperties
@EnableAsync
public class NacosLearnApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(NacosLearnApplication.class, args);
        AsyncConfig asyncConfig = context.getBean(AsyncConfig.class);
        Executor executor = asyncConfig.getAsyncExecutor();
        System.out.println("boost successfully");
    }

}
