package com.yunn.autumn.thread.异常堆栈;

/**
 * ExitCapture
 *
 * @author yunnuan
 * @createTime 2021年01月04日 23:22
 * @description 如何给程序注入一个钩子函数，目的是使其在服务器发生意料之外的异常时也能及时告警
 * kill pid : 进程可以在完成本身的工作后再结束。
 * kill -9 pid : 进程直接被强制结束。
 */
public class ExitCapture {

    public static void main(String[] args) {
        //添加钩子函数，在main线程抛出异常时会及时告警，并可以在执行完想要做的操作以后再退出
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("程序即将退出...");
            notifyAndRelease(Thread.currentThread().getName());
        }));
        int i = 0;
        //模拟业务逻辑运行段
        while (true) {
            try {
                Thread.sleep(1_000L);
                System.out.println("i am working at " + i + " time");
            } catch (Throwable e) {
                // e.printStackTrace();
            }
            i++;
            if (i > 10) throw new RuntimeException("error");
        }
    }

    /**
     * 通知其他线程并退出程序
     */
    private static void notifyAndRelease(String threadName) {
        try {
            System.out.println("notifyAndRelease 睡眠1s");
            Thread.sleep(1_000L);
        } catch (InterruptedException e) {
            //
        }
        System.out.println("通知了宿主主机，告知 [" + threadName + "] 线程出现问题即将退出");
    }
}
