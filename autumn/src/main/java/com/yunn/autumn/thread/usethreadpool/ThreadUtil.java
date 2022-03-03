package com.yunn.autumn.thread.usethreadpool;


import lombok.experimental.UtilityClass;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@UtilityClass
public class ThreadUtil {

    private static final Map<String, ThreadPoolExecutor> pools = new ConcurrentHashMap<>();

    public ThreadPoolExecutor initThreadPool(String poolName, int poolSize) {
        return new ThreadPoolExecutor(
                poolSize,
                poolSize * 2,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>()
        );
    }

    public ThreadPoolExecutor getOrInitThreadPool(String poolName, int poolSize) {
        ThreadPoolExecutor executor = pools.get(poolName);
        if (executor == null) {
            synchronized (ThreadUtil.class) {
                executor = pools.get(poolName);
                if (executor == null) {
                    return initThreadPool(poolName, poolSize);
                } else {
                    // ?
                    pools.put(poolName, executor);
                }
            }
        }
        return executor;
    }

    public void remove(String poolName) {
        pools.remove(poolName);
    }
}
