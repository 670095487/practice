package com.yunn.autumn.thread.th02;

/**
 * TaxCalcMain
 *
 * @Author: Bff
 * @CreateTime: 2020-04-19
 * @Description: 税率计算方法入口
 */
public class TaxCalcMain {

    public static void main(String[] args) {
        TaxCalc taxCalc = new TaxCalc(10000d, 2000d);
        taxCalc.setCalcStrategy(new SimpleCalcImpl());
        System.out.println(taxCalc.calc());
    }
}
