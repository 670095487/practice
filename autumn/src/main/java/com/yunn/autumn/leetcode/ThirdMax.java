package com.yunn.autumn.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yunN
 * @date 2022/05/16.
 */
public class ThirdMax {

    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = Arrays.stream(nums).distinct().boxed().collect(Collectors.toList());
        if (list.size() < 3) {
            return list.get(list.size() - 1);
        } else {
            return list.get(list.size()-3);
        }
    }
}
