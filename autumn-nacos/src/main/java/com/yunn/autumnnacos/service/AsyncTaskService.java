package com.yunn.autumnnacos.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author yunN
 * @date 2023/01/18.
 */
@Service
public class AsyncTaskService {

    @Async
    public void runWithAsync(Integer ix) throws Exception {
        System.out.println("async=>" + Thread.currentThread().getName() + ":=> " + ix);
        TimeUnit.SECONDS.sleep(5);
        int a = 100 / 0;
    }

    /**
     * 有结果的异步返回
     */
    @Async
    public CompletableFuture<List<String>> getNamesWithAsync(int idx) throws Exception {
        System.out.println("step2...");
        return CompletableFuture.supplyAsync(() -> {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < idx; i++) {
                System.out.println("name ==> " + i);
                list.add("name ==> " + i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return list;
                }
            }
            return list;
        });
    }
}
