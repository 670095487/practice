package com.yunn.interview.thread.future.completablefuture;

import com.yunn.interview.thread.SmallTool;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;

/**
 * @author yunN
 * @date 2023/01/22.
 */
public class _04_thenApply {

    public static void main(String[] args) {
        SmallTool.printThreadInfo("xiaobai eaten");
        SmallTool.sleepSeconds(5);
        // invoice需要等到服务员线程收完款，再开完发票才能结束
        CompletableFuture<String> invoice = CompletableFuture.supplyAsync(() -> {
            SmallTool.printThreadInfo("服务员收款 500元");
            SmallTool.sleepMillions(10);
            CompletableFuture<String> waiter2 = CompletableFuture.supplyAsync(() -> {
                SmallTool.printThreadInfo("服务员开发票面额500元");
                SmallTool.sleepSeconds(5);
                return "500元发票";
            });
            return waiter2.join();
        });
        SmallTool.printThreadInfo("小白接到朋友的电话，想一起打游戏");
        SmallTool.printThreadInfo(String.format("小白拿到%s, 准备回家", invoice.join()));
    }

    // 演示thenApply,但是此时thenApply()并没有开辟新的线程
    @Test
    public void thenApply() {
        SmallTool.printThreadInfo("xiaobai eaten");
        SmallTool.sleepSeconds(5);
        CompletableFuture<String> invoice = CompletableFuture.supplyAsync(() -> {
            SmallTool.printThreadInfo("服务员收款 500元");
            SmallTool.sleepMillions(1);
            return "500";
        }).thenApply(amount -> {
            SmallTool.printThreadInfo("服务员开发票面额500元");
            SmallTool.sleepSeconds(5);
            return amount + "元发票";
        });
        SmallTool.printThreadInfo("小白接到朋友的电话，想一起打游戏");
        SmallTool.printThreadInfo(String.format("小白拿到%s, 准备回家", invoice.join()));
    }

    // 演示thenApplyAsync,此时thenApplyAsync()开辟了新的线程
    @Test
    public void thenApplyAsync() {
        SmallTool.printThreadInfo("xiaobai eaten");
        SmallTool.sleepSeconds(5);
        CompletableFuture<String> invoice = CompletableFuture.supplyAsync(() -> {
            SmallTool.printThreadInfo("服务员收款 500元");
            SmallTool.sleepMillions(1);
            return "500";
        }).thenApplyAsync(amount -> {
            SmallTool.printThreadInfo("服务员开发票面额500元");
            SmallTool.sleepMillions(1);
            return amount + "元发票";
        });
        SmallTool.printThreadInfo("小白接到朋友的电话，想一起打游戏");
        SmallTool.printThreadInfo(String.format("小白拿到%s, 准备回家", invoice.join()));
    }

}
