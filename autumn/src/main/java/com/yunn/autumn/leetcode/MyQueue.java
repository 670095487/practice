package com.yunn.autumn.leetcode;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Stack;

/**
 * @author yunN
 * @date 2022/04/20
 *
 * todo: 没搞明白
 */
public class MyQueue {

    Stack<Integer> s1;
    Stack<Integer> s2;

    private int front;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    // queue : FIFO
    // stack: FILO

    public void push(int x) {
        if (s1.empty()) {
            front = x;
        }
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s2.push(x);
        // 换位
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    public void pop() {
        s1.pop();
        // ？
        if (!s1.empty()) {
            front = s1.peek();
        }
    }

    public int peek() {
        return s1.peek();
    }

    public boolean empty() {
        return s1.isEmpty();
    }

    @Test
    public void test() {
        DecimalFormat format = new DecimalFormat("#.00");
        BigDecimal bigDecimal = new BigDecimal(1699995594949.958);
        System.out.println(bigDecimal.setScale(2, RoundingMode.HALF_UP));
        System.out.println(format.format(bigDecimal.setScale(0, RoundingMode.HALF_UP)));
    }

    @Test
    public void test1() {
        String s = "s";
        System.out.println(s.toUpperCase());
    }
}
