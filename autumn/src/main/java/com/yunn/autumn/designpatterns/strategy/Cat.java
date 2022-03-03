package com.yunn.autumn.designpatterns.strategy;

/**
 * Cat
 *
 * @Author: Bff
 * @CreateTime: 2020-07-06
 * @Description: 实现自定义比较接口，完成对猫体重的排序
 */
public class Cat implements MyComparable<Cat> {

    /**
     * 猫的体重
     */
    private int weight;

    /**
     * 猫的身高
     */
    private int height;

    public Cat() {
    }

    public Cat(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }


    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * 实现接口
     *
     * @param c
     * @return
     */
    @Override
    public int compareTo(Cat c) {
        if (this.weight < c.weight) {
            return -1;
        } else if (this.weight > c.weight) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Cat{" +
                "weight=" + weight +
                ", height=" + height +
                '}';
    }
}
