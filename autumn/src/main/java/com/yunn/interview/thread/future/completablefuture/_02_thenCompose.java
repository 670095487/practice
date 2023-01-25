package com.yunn.interview.thread.future.completablefuture;

import com.yunn.interview.thread.SmallTool;

import java.util.concurrent.CompletableFuture;

/**
 * @author yunN
 * @date 2023/01/22.
 */
public class _02_thenCompose {

    public static void main(String[] args) {
        SmallTool.printThreadInfo("xiaobai arrived at restaurant");
        SmallTool.printThreadInfo("xiaobai ordered 2 dishes");
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(()->{
            SmallTool.printThreadInfo("cook is cooking...");
            SmallTool.sleepSeconds(5);
            return "dish 1";
        }).thenCompose(dish->CompletableFuture.supplyAsync(()->{
            SmallTool.printThreadInfo("water takes a meal");
            SmallTool.sleepSeconds(5);
            return dish + " rice";
        }));
        SmallTool.printThreadInfo("xiaobai is playing games");
        SmallTool.printThreadInfo(String.format("%s, xiaobai is eating", cf1.join()));
    }
}
