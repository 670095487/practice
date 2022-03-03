package com.yunn.autumn.thread.不可变类;

/**
 * @author yunN
 * @date 2021/11/21.
 *
 * 使用final关键字修饰所有成员变量，避免其被修改，也可以保证多线程环境下被final关键字修饰的变量所引用的对象的初始化安全，即final修饰的字段在其他线程可见时，必定是初始化完成的。
 *
 * 使用private修饰所有成员变量，可以防止子类及其他地方通过引用直接修改变量值。
 *
 * 禁止提供修改内部状态的公开接口(比如我们前面例子中的setXY方法)
 *
 * 禁止不可变类被外部继承，防止子类改变其定义的方法的行为。
 *
 * 如果类中存在数组或集合，在提供给外部访问之前需要做防御性复制
 *
 */
public final class Location {

    private final double x;

    private final double y;

    public Location(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
