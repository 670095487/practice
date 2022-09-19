package com.yunn.autumn.leetcode;

import org.junit.Test;

import java.util.Stack;

/**
 * @author yunN
 * @date 2022/08/30
 */
public class EvalRPN {

    // if element is an operator, pop out 2 elements from stack, use it to operate them.
    // if element is a digit, then push it in the stack.
    public void evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if ("+-*/".contains(token)) {
                int a = stack.pop(), b = stack.pop();
                switch (token) {
                    case "+": {
                        stack.push(a + b);
                        break;
                    }
                    case "*": {
                        stack.push(a * b);
                        break;
                    }
                    case "-": {
                        stack.push(b - a);
                        break;
                    }
                    case "/":{
                        stack.push(b / a);
                        break;
                    }
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        stack.pop();
    }

    @Test
    public void test() {
        evalRPN(new String[]{"2", "1", "+", "3", "*"});
    }
}
