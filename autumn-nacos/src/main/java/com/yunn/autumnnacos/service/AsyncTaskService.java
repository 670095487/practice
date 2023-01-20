package com.yunn.autumnnacos.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author yunN
 * @date 2023/01/18.
 */
@Service
public class AsyncTaskService {

    @Async
    public void runWithAsync(Integer ix) throws Exception {
        System.out.println("async=>" + Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(5);
        System.out.println(Thread.currentThread() + ":=>" + ix);
    }
}
