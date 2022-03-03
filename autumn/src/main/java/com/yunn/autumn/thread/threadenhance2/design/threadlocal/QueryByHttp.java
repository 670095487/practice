package com.yunn.autumn.thread.threadenhance2.design.threadlocal;

/**
 * QueryByHttp
 *
 * @author yunN
 * @createTime 2021年01月17日 16:42
 * @description
 */
public class QueryByHttp {

    public void execute() {
        try {
            Thread.sleep(1000);
            //以 调用线程的名字 作为从threadLocal<> 取值的key
            String name = "yunN-Http " + Thread.currentThread().getName();
            ApplicationContext.getApplicationContext().getContext().setValue(name);
            System.out.println("query by http done... | " + name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
