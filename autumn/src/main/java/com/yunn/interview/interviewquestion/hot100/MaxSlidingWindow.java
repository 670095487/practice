package com.yunn.interview.interviewquestion.hot100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author yunN
 * @date 2023/01/09.
 */
public class MaxSlidingWindow {

    // O(kn) 时间复杂度过不了
    public int[] maxSlidingWindow_useless(int[] nums, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        int low = 0, high = k - 1;
        while (high < nums.length) {
            int max = Integer.MIN_VALUE;
            for (int i = low; i <= high; i++) {
                max = Math.max(nums[i], max);
            }
            list.add(max);
            System.out.println(Arrays.toString(list.toArray()));
            low++;
            high++;
        }

        int[] ints = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ints[i] = list.get(i);
        }
        return ints;
    }

    @Test
    public void test() {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        maxSlidingWindow(nums, 3);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        MyQueue queue = new MyQueue();
        for (int i = 0; i < k; i++) {
            queue.push(nums[i]);
        }

        // 数组初始化长度
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        res[index++] = queue.getMaxValue();
        for (int i = k; i < nums.length; i++) {
            // 移除滑动窗口最左边的元素
            queue.poll(nums[i - k]);
            // 将当前值放入队列
            queue.push(nums[i]);
            // 将当前最大值放入数组
            res[index++] = queue.getMaxValue();
        }

        return res;
    }

    class MyQueue {

        private Deque<Integer> deque = new LinkedList<>();

        public MyQueue() {
        }

        public int getMaxValue() {
            if (!deque.isEmpty()) {
                return deque.peek();
            }
            return 0;
        }

        // push进队列的条件，当前push进去的值
        public void push(int val) {
            while (!deque.isEmpty() && val > deque.getLast()) {
                deque.removeLast();
            }
            deque.add(val);
        }

        public void poll(int val) {
            if (!deque.isEmpty() && val == deque.peek()) {
                deque.poll();
            }
        }
    }


    public static void main(String[] args) {
        ArrayList<String> sites = new ArrayList<>();

        sites.add("Runoob");
        sites.add("Google");
        sites.add("Wiki");
        sites.add("Taobao");
        System.out.println("网站列表: " + sites);

        // 创建一个新的 String 类型的数组
        // 数组长度和 ArrayList 长度一样
        String[] arr = new String[sites.size()];

        // 将ArrayList对象转换成数组
        sites.toArray(arr);

        // 输出所有数组的元素
        System.out.print("Array: ");
        for (String item : arr) {
            System.out.print(item + ", ");
        }
    }
}
