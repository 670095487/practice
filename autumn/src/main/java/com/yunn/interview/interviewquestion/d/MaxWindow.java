package com.yunn.interview.interviewquestion.d;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;

/**
 * @author yunN
 * @date 2023/02/27.
 */
public class MaxWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }
        // 定义结果集数组的长度
        // nums.length = 4， k = 3, 则前3个元素有一个最大值，然后后移一位，即后三个元素有一个最大值，所以窗口长度为4-3+1=2
        int len = nums.length - k + 1;
        int[] res = new int[len];
        // 记录res的索引
        int num = 0;
        // 将k个元素放入自定义队列
        Queue_My queue_my = new Queue_My();
        for (int i = 0; i < k; i++) {
            queue_my.add(nums[i]);
        }
        // 存入第一个k窗口内的最大值
        res[num++] = queue_my.peek();
        // 窗口从第K位开始移动
        for (int i = k; i < nums.length; i++) {
            // 移除当前窗口最左边的元素
            queue_my.poll(nums[i - k]);
            // 窗口后移（即将当前元素加入窗口中）
            queue_my.add(nums[i]);
            // 记录当前窗口的最大值
            res[num++] = queue_my.peek();
        }
        return res;
    }

}

// 维护一个单调递减队列
@Data
@AllArgsConstructor
@NoArgsConstructor
class Queue_My {

    LinkedList<Integer> queue = new LinkedList<>();

    void poll(int val) {
        // 当前需要移除的元素如果是在队头元素，则移除，否则不移除（因为已经移除过了）
        // 换句话说，就是移除元素的时候检查一下是不是在队列里，
        // 因为队列的第一个元素就是队列的最大值，（
        if (!queue.isEmpty() && val == queue.peek()) {
            queue.removeFirst();
        }
    }

    void add(int val) {
        // 如果当前入队元素大于队列中最后一个元素，则将最后一个元素弹出，将此元素入队
        // 注意：这个判断是循环，所以如果当前添加的元素大于队列中所有的元素，那么队列内之前存在的元素会被全部移除，只保留当前这个最大值
        while (!queue.isEmpty() && val > queue.getLast()) {
            queue.removeLast();
        }
        // 保证队列内的元素的单调递减的
        queue.addLast(val);
    }

    int peek() {
        return queue.peek();
    }

}
