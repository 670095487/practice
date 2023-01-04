package com.yunn.interview.interviewquestion;

import java.util.LinkedList;

/**
 * @author yunN
 * @date 2022/12/05.
 * 实现栈，pop top min 时间复杂度要求O(1)
 */
public class _30 {

    LinkedList<Integer> stack;
    LinkedList<Integer> minStack;

    public _30() {
        this.stack = new LinkedList<>();
        this.minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        stack.push(x);
        minStack.push(Math.min(minStack.peek(), x));
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }


}
