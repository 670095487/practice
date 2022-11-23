package com.yunnconsumer.consumer.service.impl;

import com.yunnconsumer.consumer.service.ConsumerService;
import com.yunndubbo.api.service.DemoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;

/**
 * @author yunN
 * @date 2022/11/23.
 */
@DubboService
@Component
public class ConsumerServiceImpl implements ConsumerService {

    @DubboReference
    DemoService demoService;

    @Override
    public String saySomething(String message) {
        return demoService.sayHello(message);
    }
}
