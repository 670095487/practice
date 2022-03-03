package com.yunn.autumnnacos.controller;


import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("demo")
public class UserController {

    @GetMapping
    public String testConnect() {
        return "succ";
    }

    @NacosValue(value = "${spring.datasource.url:NACOSsb}", autoRefreshed = true)
    private String testValue;

    @RequestMapping(value = "/get", method = GET)
    @ResponseBody
    public String get() {
        return testValue;
    }

}
