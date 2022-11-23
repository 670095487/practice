package com.yunndubbo.producter.service.impl;

import com.yunndubbo.api.service.DemoService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;

/**
 * @author yunN
 * @date 2022/11/23.
 */
@DubboService
@Component
public class ProductServiceImpl implements DemoService {


    @Override
    public String sayHello(String message) {
        return message + " product handled this...";
    }
}
