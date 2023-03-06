package com.yunn.interview.interviewquestion.d;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @author yunN
 * @date 2023/02/26.
 * 逆波兰表达式求值
 */
public class EvalRPN {

    public int evalRPN(String[] tokens) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                int second = linkedList.removeLast();
                int first = linkedList.removeLast();
                linkedList.addLast(first + second);
            } else if (token.equals("-")) {
                int second = linkedList.removeLast();
                int first = linkedList.removeLast();
                linkedList.addLast(first - second);
            } else if (token.equals("*")) {
                int second = linkedList.removeLast();
                int first = linkedList.removeLast();
                linkedList.addLast(first * second);
            } else if (token.equals("/")){
                int second = linkedList.removeLast();
                int first = linkedList.removeLast();
                linkedList.addLast(first / second);
            } else {
                linkedList.addLast(Integer.valueOf(token));
            }
        }
        return linkedList.pop();
    }

    @Test
    public void test() {
        String[] tokens = new String[]{"4","13","5","/","+"};
        System.out.println(evalRPN(tokens));
        int a = 13/5;
        System.out.println(a);
    }

}
