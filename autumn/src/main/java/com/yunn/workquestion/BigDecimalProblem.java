package com.yunn.workquestion;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.FormatStyle;

/**
 * @author yunN
 * @date 2022/04/27
 */
public class BigDecimalProblem {

    static DecimalFormat decimalFormat = new DecimalFormat("0.00");

    public static void main(String[] args) {
        BigDecimal b1 = new BigDecimal(12.1);
        BigDecimal b2 = new BigDecimal(12.1);
        System.out.println(new BigDecimal(decimalFormat.format(b1.add(b2).setScale(0, RoundingMode.HALF_UP))));
    }
}
