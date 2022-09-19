package com.yunn.autumn.leetcode.backtrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yunN
 * @date 2022/08/02
 */
public class MinimumTotal {

    public int minimumTotal(List<List<Integer>> triangle) {
        int sum = Integer.MIN_VALUE;
        for (List<Integer> sub : triangle) {
            List<Integer> t = sub.stream()
                    .map(s -> Math.abs(s)).collect(Collectors.toList());
            int min = t.stream().min(Integer::compare).get();
            sum += min;
        }
        return sum;
    }


    @Test
    public void test() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("aaa");
        strings.add("aaa");
        strings.add("bbb");
        strings.add("bbb");
        strings.add("ccc");
        for (int i = 0; i < strings.size(); i++) {
            if (strings.get(i).equalsIgnoreCase("bbb")) {
                strings.remove(i);
                --i;
            }
        }
        strings.forEach(System.out::println);
    }

}
