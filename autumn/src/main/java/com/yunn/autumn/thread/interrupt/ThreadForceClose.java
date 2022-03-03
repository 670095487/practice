package com.yunn.autumn.thread.interrupt;

/**
 * ThreadForceClose
 *
 * @author: yunN
 * @createTime: 2020/12/28
 * @description: 强制中断线程
 */
public class ThreadForceClose {
    //如果逻辑块部分没有办法监听到中断信号，该如何中断线程

    public static void main(String[] args) {
        ThreadService service = new ThreadService();
        long start = System.currentTimeMillis();
        service.execute(() -> {
            try {
                //假设主线程执行任务需要10s
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        //执行完成后执行销毁方法
        service.shutdown(3000);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}

class ThreadService {
    /**
     * 执行线程
     */
    private Thread executeThread;

    /**
     * 任务是否完成
     */
    private boolean finished = false;

    public void execute(Runnable task) {
        //初始化执行线程--主线程
        executeThread = new Thread() {
            @Override
            public void run() {
                //子线程
                Thread runner = new Thread(task);
                //设置子线程为守护线程
                runner.setDaemon(true);
                //启动子线程
                runner.start();
                try {
                    //子线程join(),实际上就是等待主线程结束
                    runner.join();
                    finished = true;
                } catch (InterruptedException e) {
                    // e.printStackTrace();
                }
            }
        };
        //主线程启动
        executeThread.start();
    }

    public void shutdown(long mills) {
        long currentTime = System.currentTimeMillis();
        while (!finished) {
            if ((System.currentTimeMillis() - currentTime) >= mills) {
                System.out.println("任务超时，需及时终止");
                //中断主线程，但是主线程此时并未有捕获中断的判断行为
                //主线程被中断，守护线程也需要结束
                executeThread.interrupt();
                break;
            }
        }
        try {
            executeThread.sleep(100);
            System.out.println("执行线程被打断！");
        } catch (InterruptedException e) {
        }

        finished = false;
    }
}
