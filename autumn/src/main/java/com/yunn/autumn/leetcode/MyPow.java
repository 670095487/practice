package com.yunn.autumn.leetcode;

import lombok.Data;
import org.junit.Test;

/**
 * @author yunN
 * @date 2022/06/07
 */
public class MyPow {

    public double myPow(double x, int n) {
        return n >= 0 ? pow(x, n) : 1.0 / pow(x, -n);
    }

    double pow(double x, int n) {
        if (n == 0) return 1.0;
        double y = pow(x, n / 2);
        y = n % 2 == 0 ? y * y : y * y * x;
        return y;
    }

    @Test
    public void test() {
        // System.out.println(myPow(2.00, 3));
        String md3 = "05646,";
        A a = new A();
        a.setMd3(md3);
        System.out.println(a.toString());
    }

}

@Data
class A{
    String md3;
}
