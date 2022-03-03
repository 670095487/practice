package com.yunn.interview;

/**
 * Created by yunN on 2021/04/22.
 */
public class IOStudy {

    private static final ThreadLocal threadLocal = new ThreadLocal() {
        @Override
        protected Object initialValue() {
            System.out.println("initial thread is " + Thread.currentThread().getId());
            return Thread.currentThread().getId();
        }
    };

    public static void main(String[] args) throws Exception {
        /*new Thread() {
            @Override
            public void run() {
                //new thread do it , late
                System.out.println("new thread do threadLocal.get() => " + threadLocal.get());
            }
        }.start();*/
        // threadLocal.set(99L);
        //main thread do it , first
        System.out.println("main thread do threadLocal.get() => " + threadLocal.get());
        threadLocal.set((Long) threadLocal.get() + 1L);
        System.out.println("main thread 2rd use thread local"+threadLocal.get());
    }

}
