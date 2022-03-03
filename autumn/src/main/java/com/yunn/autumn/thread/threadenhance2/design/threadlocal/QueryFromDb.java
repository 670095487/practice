package com.yunn.autumn.thread.threadenhance2.design.threadlocal;

/**
 * QueryFromDb
 *
 * @author yunN
 * @createTime 2021年01月17日 16:42
 * @description
 */
public class QueryFromDb {

    public void execute() {
        try {
            Thread.sleep(1000);
            //以 调用线程的名字 作为从threadLocal<> 取值的key
            // String name = "yunN-DB " + Thread.currentThread().getName();
            System.out.println(ApplicationContext.getApplicationContext().getContext().getValue());
            System.out.println("query from db done...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
