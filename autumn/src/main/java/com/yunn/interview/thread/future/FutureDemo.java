package com.yunn.interview.thread.future;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author yunN
 * @date 2023/01/16.
 */
public class FutureDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Object> future = executorService.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                long start = System.currentTimeMillis();
                while (true) {
                    long current = System.currentTimeMillis();
                    if (current - start > 1000) {
                        return 1;
                    }
                }
            }
        });

        try {
            Integer result = (Integer)future.get();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
