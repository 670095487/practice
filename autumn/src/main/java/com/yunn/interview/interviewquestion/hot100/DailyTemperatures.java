package com.yunn.interview.interviewquestion.hot100;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author yunN
 * @date 2023/02/08.
 */
public class DailyTemperatures {

    /*
        answer[i] 是指对于第 i 天，下一个更高温度出现在几天后

        暴力：
            for(for()) // 时间复杂度过不了
     */
    public int[] dailyTemperaturesWithBF(int[] tem) {
        int n = tem.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int days = 0;
            for (int j = i + 1; j < n; j++) {
                days++;
                if (tem[j] > tem[i]) {
                    ans[i] = days;
                    break;
                }
            }
        }
        return ans;
    }

    /*
       使用栈存储天数
         day - temperature
         1 - 73
         2 - 74 -> 74 > 73 , 所以ans[0] = 2 - 1 = 1 , 且将1出栈 ，此时栈内存储 2 - 74
     */
    public int[] dailyTemperatures(int[] tem) {
        int n = tem.length;
        int[] ans = new int[n];
        Stack<Integer> dayStack = new Stack<>();
        for (int i = 0; i < tem.length; i++) {
            while (!dayStack.isEmpty() && tem[i] > tem[dayStack.peek()]) {
                Integer preIndex = dayStack.pop();
                ans[preIndex] = i - preIndex;
            }
            dayStack.push(i);
        }
        return ans;
    }
}
