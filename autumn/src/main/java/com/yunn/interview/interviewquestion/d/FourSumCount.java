package com.yunn.interview.interviewquestion.d;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yunN
 * @date 2023/02/21.
 */
public class FourSumCount {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        int tmp;
        int res = 0;
        // 先统计前面2个数组两两相加的和以及和出现对应的次数
        for (int i : nums1) {
            for (int j : nums2) {
                tmp = i + j;
                // 统计和出现的次数
                if (map.containsKey(tmp)) {
                    map.put(tmp, map.get(tmp) + 1);
                } else {
                    map.put(tmp, 1);
                }
            }
        }
        for (int i : nums3) {
            for (int j : nums4) {
                tmp = i + j;
                if (map.containsKey(-tmp)) {
                    // 这题是不需要去重的
                    res += map.get(-tmp);
                }
            }
        }
        return res;
    }
}
