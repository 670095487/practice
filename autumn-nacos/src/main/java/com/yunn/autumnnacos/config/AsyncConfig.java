package com.yunn.autumnnacos.config;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author yunN
 * @date 2023/01/18.
 * 自定义异步线程池
 */
@EnableAsync
@Configuration
public class AsyncConfig implements AsyncConfigurer {
    @Override
    public Executor getAsyncExecutor() {
        return Executors.newWorkStealingPool();
    }

    // 重写springboot异常处理机制，可自定义
    // 对于无返回值的异步方法可以如此处理
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new AsyncUncaughtExceptionHandler() {
            @Override
            public void handleUncaughtException(Throwable th, Method mth, Object... ob) {
                System.out.println("th=>" + th);
                System.out.println("mth=>" + mth);
                System.out.println("obj=>"+ Arrays.toString(ob));
            }
        };
    }
}
