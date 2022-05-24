package com.yunn.autumn.leetcode;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yunN
 * @date 2022/04/19
 */
@SuppressWarnings("all")
public class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    // queue:fifo
    // stack:filo
    public void push(int x) {
        queue2.offer(x);
        // 将q1中的元素全都放到q2中（fifo,这次加到队列中的x元素 应该是在q2的队首）,
        // 注意：对于栈来说，x元素是属于后进的元素，所以应该先出，而对于队列来说，x元素是属于先进的元素，所以应该先出【用队列实现了栈】
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        // q1清空以后 将q1和q2做了调换
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

    }

    // 弹出队列的首元素
    public int pop() {
        return queue1.poll();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }


    @Test
    public void test() {
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        queue1.offer(1);
        queue1.offer(2);
        queue1.offer(3);
        queue2.offer(4);
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        System.out.println(queue1.poll());

    }
}
