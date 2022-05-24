package com.yunn.autumn.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yunN
 * @date 2022/05/10
 */
public class Intersection {

    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> rs = new ArrayList<>();
        List<Integer> num1List = new ArrayList<>();
        for (int j : nums1) {
            num1List.add(j);
        }
        for (int i : nums2) {
            if (num1List.contains(i) && !rs.contains(i)) {
                rs.add(i);
            }
        }

        int[] rsArray = new int[rs.size()];
        for (int i = 0; i < rs.size(); i++) {
            rsArray[i] = rs.get(i);
        }

        return rsArray;

        //Set<Integer> set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        //return Arrays.stream(nums2).distinct().filter(set::contains).toArray();
    }

        //[4,9,5]
        // [9,4,9,8,4]
    @Test
    public void test() {
        intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4});
    }
}
