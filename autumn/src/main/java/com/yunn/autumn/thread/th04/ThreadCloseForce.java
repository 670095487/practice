package com.yunn.autumn.thread.th04;

/**
 * ThreadCloseForce
 *
 * @Author: Bff
 * @CreateTime: 2020-05-02
 * @Description:
 */
public class ThreadCloseForce {


    public static void main(String[] args) {
        ThreadService threadService = new ThreadService();
        long start = System.currentTimeMillis();
        threadService.execute(() -> {
            //假设这个线程处理的任务要花费很长时间
            while (true) {

            }
        });
        threadService.shutdown(10000);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
