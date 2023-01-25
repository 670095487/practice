package com.yunn.interview.thread.future.completablefuture;

import com.yunn.interview.thread.SmallTool;

import java.util.concurrent.CompletableFuture;

/**
 * @author yunN
 * @date 2023/01/22.
 */
public class _03_thenCombine {

    public static void main(String[] args) {
        SmallTool.printThreadInfo("xiaobai arrived at restaurant");
        SmallTool.printThreadInfo("xiaobai ordered 2 dishes");
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            SmallTool.printThreadInfo("cook is cooking...");
            SmallTool.sleepSeconds(5);
            return "dish 1";
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            SmallTool.printThreadInfo("water cook rice");
            SmallTool.sleepSeconds(5);
            return " rice";
        }), (dish, rice) -> {
            SmallTool.printThreadInfo("water serve the completed meal...");
            return String.format("meal completed....");
        });
        SmallTool.printThreadInfo("xiaobai is playing games");
        SmallTool.printThreadInfo(String.format("%s, xiaobai is eating", cf1.join()));
    }
}
