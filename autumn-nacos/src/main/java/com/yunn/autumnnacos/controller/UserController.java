package com.yunn.autumnnacos.controller;


import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.yunn.autumnnacos.service.AsyncTaskService;
import com.yunn.autumnnacos.service.impl.TransactionalLearnService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

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

    @GetMapping("/async-void")
    public String testAsync() throws Exception {
        System.out.println("main=>" + Thread.currentThread().getName());
        String result = "RS1";
        for (int i = 0; i < 100; i++) {
            asyncTaskService.runWithAsync(i);
        }
        result = "RS2";
        return result;
    }

    @GetMapping("/async")
    public List<String> testAsyncHasReturnValue() {
        List<String> ans = new ArrayList<>();
        CompletableFuture<List<String>> future = null;
        System.out.println("step1...");
        try {
            future = asyncTaskService.getNamesWithAsync(10);
            // ans = future.get();
        } catch (Exception ex) {
            //
            ans.add("exception happened");
        }
        System.out.println("step3...");
        assert future != null;
        // 异步结果不需要给调用者
        if (future.isDone()) {
            List<String> result = new ArrayList<>();
            try {
                result = future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
            System.out.println("Async step is done, going to do another thing....");
            System.out.println("first result is :"+result.get(0));

        }
        // 异步结果需要给调用者
        List<String> result = future.join();
        System.out.println("Async step is done, going to do another thing....");
        System.out.println("first result is :"+result.get(0));
        ans.add("\"name ==> \" + idx");
        return ans;
    }

}
