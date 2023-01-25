package com.yunn.interview.thread;

import lombok.SneakyThrows;

import java.time.LocalDateTime;
import java.util.StringJoiner;
import java.util.concurrent.TimeUnit;

/**
 * @author yunN
 * @date 2023/01/22.
 */
public class SmallTool {

    public static void printThreadInfo(String extraInfo) {
        String  result = new StringJoiner("\t|\t")
                .add(String.valueOf(LocalDateTime.now()))
                .add(String.valueOf(Thread.currentThread().getId()))
                .add(Thread.currentThread().getName())
                .add(extraInfo)
                .toString();
        System.out.println(result);
    }

    @SneakyThrows
    public static void sleepSeconds(int time) {
        TimeUnit.SECONDS.sleep(time);
    }

    @SneakyThrows
    public static void sleepMillions(int time) {
        TimeUnit.MILLISECONDS.sleep(time);
    }
}
