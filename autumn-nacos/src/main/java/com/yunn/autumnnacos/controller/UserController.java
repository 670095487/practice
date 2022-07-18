package com.yunn.autumnnacos.controller;


import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.yunn.autumnnacos.service.impl.TranscationLearnService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("demo")
@RequiredArgsConstructor
public class UserController {

    private final TranscationLearnService transcationLearnService;

    @GetMapping
    public String testConnect() {
        return "succ";
    }

    @NacosValue(value = "${spring.datasource.url:NACOSsb}", autoRefreshed = true)
    private String testValue;

    @RequestMapping(value = "/get", method = GET)
    public String get() {
        return testValue;
    }

    @GetMapping("/yml")
    public void readYml() {
        transcationLearnService.readYmlProps();
    }
}
