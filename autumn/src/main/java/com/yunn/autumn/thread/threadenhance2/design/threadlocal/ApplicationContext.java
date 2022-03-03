package com.yunn.autumn.thread.threadenhance2.design.threadlocal;

/**
 * ApplicationContext
 *
 * @author: yunN
 * @createTime: 2021/01/16
 * @description:
 */
public final class ApplicationContext {


    private static ThreadLocal<Context> threadLocal = new ThreadLocal<Context>(){
        @Override
        protected Context initialValue() {
            return new Context();
        }
    };


    /**
     * 使用静态内部类实现安全的单例模式
     */
    private static class ContextHolder{
        //静态属性由JVM保证仅在被调用时加载且全局仅加载一次至内存
        private static ApplicationContext applicationContext = new ApplicationContext();

    }

    /**
     * 调用此方法返回的始终是一个相同的实例
     *
     * @return /
     */
    public static ApplicationContext getApplicationContext() {
        return ContextHolder.applicationContext;
    }

    /**
     * 调用此方法，返回threadLocal中的val key为调用者线程
     *
     * @return /
     */
    public Context getContext() {
        return threadLocal.get();
    }

    /**
     * 清除threadLocal中的值
     */
    public void remove() {
        threadLocal.remove();
    }

}
