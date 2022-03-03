package com.yunn.autumn.thread.threadenhance2.design.threadlocal;

import java.util.stream.IntStream;

/**
 * ThreadLocalClient
 *
 * @author yunN
 * @createTime 2021年01月17日 17:03
 * @description
 */
public class ThreadLocalClient {


    public static void main(String[] args) {

        IntStream.rangeClosed(1,5).forEach(i->{
            new Thread(new ExecuteThread()).start();
        });
    }
}
