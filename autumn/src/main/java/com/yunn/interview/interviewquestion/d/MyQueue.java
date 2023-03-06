package com.yunn.interview.interviewquestion.d;

import java.util.LinkedList;

/**
 * @author yunN
 * @date 2023/02/24.
 */
public class MyQueue {

    LinkedList<Integer> linkedList;
    int size;

    public MyQueue() {
        this.linkedList = new LinkedList<>();
        this.size = 0;
    }

    public void push(int x) {
        size++;
        linkedList.addLast(x);
    }

    public int pop() {
        size--;
        return linkedList.pop();
    }

    public int peek() {
        return linkedList.peek();
    }

    public boolean empty() {
        return size <= 0;
    }
}
