package com.yunn.interview.interviewquestion.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

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

    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->a[1] - b[1]);
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
