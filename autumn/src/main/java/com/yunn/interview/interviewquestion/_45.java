package com.yunn.interview.interviewquestion;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @date 2022/12/23
 */
public class _45 {

    public String minNumber(int[] nums) {
        StringBuilder ans = new StringBuilder();
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        List<String> list = Arrays.stream(strs).sorted((x, y) -> (x + y).compareTo(y + x)).collect(Collectors.toList());
        for (String s : list) {
            ans.append(s);
        }
        return ans.toString();
    }
}
