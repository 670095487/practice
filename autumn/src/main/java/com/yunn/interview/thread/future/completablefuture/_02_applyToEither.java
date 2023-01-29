package com.yunn.interview.thread.future.completablefuture;

import com.yunn.interview.thread.SmallTool;

import java.util.concurrent.CompletableFuture;

/**
 * @date 2023/01/26
 */
public class _02_applyToEither {

    public static void main(String[] args) {
        SmallTool.printThreadInfo("xiaobai go out the restaurant, arrived at bus station");
        SmallTool.printThreadInfo("wait line 700 or 800");

        CompletableFuture<String> bus = CompletableFuture.supplyAsync(() -> {
            SmallTool.printThreadInfo("line 700 is coming");
            SmallTool.sleepSeconds(2);
            return "line700 arrived";
        }).applyToEither(CompletableFuture.supplyAsync(() -> {
            SmallTool.printThreadInfo("line 800 is coming");
            SmallTool.sleepSeconds(3);
            return "line800 arrived";
        }), f -> {
            if (f.startsWith("line7")) {
                throw new RuntimeException("An exception occurs");
            }
            return f;
        }).exceptionally(e -> {
            SmallTool.printThreadInfo(e.getMessage());
            SmallTool.printThreadInfo("xiaobai called police");
            return "police is coming";
        });
        SmallTool.printThreadInfo(String.format("%s, xiaobai take the bus home", bus.join())); 
    }
}
