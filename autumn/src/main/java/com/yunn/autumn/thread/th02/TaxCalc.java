package com.yunn.autumn.thread.th02;

/**
 * TaxCalc
 *
 * @Author: Bff
 * @CreateTime: 2020-04-19
 * @Description: 税率属性
 */
public class TaxCalc {

    /*薪资*/
    private double salary;
    /*奖金*/
    private double bonus;
    /*提供接口变量*/
    private CalculatorStrategy calc;

    public TaxCalc(double salary, double bonus) {
        this.salary = salary;
        this.bonus = bonus;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    protected double calcTax() {
        return calc.calculate(salary, bonus);
    }

    public double calc() {
        return this.calcTax();
    }

    public void setCalcStrategy(CalculatorStrategy calc) {
        this.calc = calc;
    }

}
