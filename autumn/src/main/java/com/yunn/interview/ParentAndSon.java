package com.yunn.interview;

/**
 * ParentAndSon
 *
 * @author yunN
 * @createTime 2021年03月05日 10:09
 * @description
 */
public class ParentAndSon {

    public static void main(String[] args) {
        //初始化子类时，会先调用父类的无参构造方法
        Son son = new Son();
    }
}

class Son extends Parent{

    public Son() {
        System.out.println("Son constructor had been done...");
    }
}

class Parent{
    protected String sonName;

    public Parent(String sonName) {
        this.sonName = sonName;
        System.out.println("sonName = " + sonName);
    }

    public Parent() {
        System.out.println("Parent constructor had been done...");
    }
}
