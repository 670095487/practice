package com.yunn.autumn.thread.threadenhance2.design.threadlocal;

/**
 * ExcuteThread
 *
 * @author yunN
 * @createTime 2021年01月17日 16:37
 * @description 任务调度线程
 */
public class ExecuteThread implements Runnable {

    private QueryFromDb queryFromDb = new QueryFromDb();

    private QueryByHttp queryByHttp = new QueryByHttp();

    @Override
    public void run() {
        /*
         * 使用threadLocal<Thread t,T t>,每个线程都会有一个map，key是线程本身，val可以是任何值，在高并发下，使用threadLocal 不用担心
         * 数据错乱的问题，因为后续在取值的时候，每个线程仅能取到自己之前填入的那个值
         *    * */

        final Context context = ApplicationContext.getApplicationContext().getContext();
        context.setValue(Thread.currentThread().getName());
        queryFromDb.execute();
        // queryByHttp.execute();
    }
}
