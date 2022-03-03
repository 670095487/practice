package com.yunn.autumn.thread.th00;

/**
 * TemplateThread
 *
 * @Author: Bff
 * @CreateTime: 2020-04-19
 * @Description: 模版方法
 */
public class TemplateThread {


    /**
     * 这个方法的第一行和最后一行可以表示这个方法的大逻辑已定，
     * 留给子类可选的重写逻辑只有中间的方法，子类若不重写就使用父类中的所有逻辑
     *
     * @param message
     */
    public final void print(String message) {
        System.out.println("###################");
        wrapMessage(message);
        System.out.println("###################");

    }

    /**
     * protected:仅将此方法暴露给子类
     */
    protected void wrapMessage(String message) {
        System.out.println(message);
    }

    public static void main(String[] args) {
        TemplateThread t = new TemplateThread() {
            @Override
            protected void wrapMessage(String message) {
                if ("".equals(message) || null == message || message.length() <= 0) {
                    super.wrapMessage("TemplateThread类自己的wrapMessage方法");
                } else
                    System.out.println("调用类自己实现的wrapMessage方法" + "=>" + message);
            }
        };
        t.print("我是子类");
    }
}
