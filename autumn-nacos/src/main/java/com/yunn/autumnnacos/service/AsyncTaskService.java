package com.yunn.autumnnacos.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author yunN
 * @date 2023/01/18.
 */
@Service
public class AsyncTaskService {

    @Async
    public void runWithAsync(Integer ix) {
        System.out.println(Thread.currentThread() + ":=>" + ix);
    }
}
