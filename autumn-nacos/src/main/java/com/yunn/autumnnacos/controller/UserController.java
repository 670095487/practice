package com.yunn.autumnnacos.controller;


import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.yunn.autumnnacos.service.AsyncTaskService;
import com.yunn.autumnnacos.service.impl.TransactionalLearnService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("demo")
@RequiredArgsConstructor
public class UserController {

    private final TransactionalLearnService transactionalLearnService;

    private final AsyncTaskService asyncTaskService;

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
        transactionalLearnService.readYmlProps();
    }

    @GetMapping("/async")
    public String testAsync() throws Exception {
        System.out.println("main=>" + Thread.currentThread().getName());
        String result = "RS1";
        for (int i = 0; i < 100; i++) {
            asyncTaskService.runWithAsync(i);
        }
        result = "RS2";
        return result;
    }
}
