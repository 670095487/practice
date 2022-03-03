package com.yunn.autumn.effectiveJava.java8;

import java.util.function.IntFunction;

/**
 * StreamOfApplication
 *
 * @author yunnuan
 * @createTime 2021年01月02日 20:32
 * @description java8流式语法学习
 */
public class LamadaStudy {

    @FunctionalInterface
    public interface Adder {
        int add(int a, int b);
    }

    public static void main(String[] args) {
        IntFunction<Double> f = i->i*100.0d;
        Double apply = f.apply(10);
        System.out.println(apply);

    }







}
