package com.yunn.interview.剑指Offer;

import java.util.LinkedList;

/**
 * @author yunN
 * @date 2022/12/05.
 * <p>
 * 用2个栈实现队列
 * <p>
 * Java中，栈是list, 队列是queue
 */
public class _09 {

    LinkedList<Integer> in;
    LinkedList<Integer> out;

    // 栈：FILO，队列：FIFO
    public _09() {
        in = new LinkedList<>();
        out = new LinkedList<>();
    }

    public void appendTail(int value) {
        in.add(value);
    }


    // 队列中的head就是last in的元素 pop() = removeFirst() add() == addFirst()
    public int deleteHead() {
        if (out.isEmpty())
            if (in.isEmpty()) {
                return -1;
            } else {
                in2Out();
            }
        return out.pop();
    }

    private void in2Out() {
        while (!in.isEmpty()) {
            out.add(in.pop());
        }
    }
}

/*class CQueue {
    Deque<Integer> inStack;
    Deque<Integer> outStack;

    public CQueue() {
        inStack = new ArrayDeque<Integer>();
        outStack = new ArrayDeque<Integer>();
    }

    public void appendTail(int value) {
        inStack.push(value);
    }

    public int deleteHead() {
        out是空的
        if (outStack.isEmpty()) {
            in也是空说明此时队列（模拟的）是空队列
            if (inStack.isEmpty()) {
                return -1;
            }
            in不空，将in中数据同步至out
            in2out();
        }
        返回的是out中最后一个进去的元素，符合队列 LIFO
        return outStack.pop();
    }

    private void in2out() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }
}

作者：LeetCode-Solution
链接：https://leetcode.cn/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/solution/mian-shi-ti-09-yong-liang-ge-zhan-shi-xian-dui-l-3/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
