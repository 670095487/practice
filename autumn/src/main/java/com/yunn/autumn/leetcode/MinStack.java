package com.yunn.autumn.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author yunN
 * @date 2022/04/06
 */
public class MinStack {

    public Deque<Integer> oriStack;
    public Deque<Integer> minStack;

    public MinStack() {
        oriStack = new LinkedList<>();
        minStack = new LinkedList<Integer>() {{
            push(Integer.MAX_VALUE);
        }};
    }

    public void push(int val) {
        oriStack.push(val);
        minStack.push(Math.min(val, minStack.peek()));
    }

    public void pop() {
        oriStack.pop();
        minStack.pop();
    }

    public int top() {
        return oriStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
