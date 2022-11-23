package com.yunnconsumer.consumer.controller;

import com.yunnconsumer.consumer.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yunN
 * @date 2022/11/23.
 */
@RestController
@RequestMapping
public class ConsumerController {

    @Autowired
    ConsumerService consumerService;

    @GetMapping("/demo")
    public String say(@PathVariable("name") String name) {
        return consumerService.saySomething(name);
    }
}
