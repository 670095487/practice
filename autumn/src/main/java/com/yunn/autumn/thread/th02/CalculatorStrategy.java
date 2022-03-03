package com.yunn.autumn.thread.th02;

/**
 * CalculatorStrategy
 *
 * @Author: Bff
 * @CreateTime: 2020-04-19
 * @Description: 计算工资的税率接口
 */
public interface CalculatorStrategy {

    /**
     * 具体计算税率的方法，需要子类自定义实现
     *
     * @param salary
     * @param bonus
     * @return
     */
    double calculate(double salary, double bonus);
}
