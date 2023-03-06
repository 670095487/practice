package com.yunn.autumn.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author yunN
 * @date 2022/10/02
 */
public class FindRestaurant {

    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> index = new HashMap<>();
        ArrayList<String> ansList = new ArrayList<>();
        for (int i = 0; i < list1.length; i++) {
            index.put(list1[i], i);
        }

        int indexSum = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            if (index.containsKey(list2[i])) {
                int j = index.get(list2[i]);
                if (i + j < indexSum) {
                    indexSum = i + j;
                    ansList.clear();
                    ansList.add(list2[i]);
                } else if (i + j == indexSum) {
                    ansList.add(list2[i]);
                }
            }
        }
        return ansList.toArray(new String[ansList.size()]);
    }

    @Test
    public void test() {
        String[] l1 = {"happy", "sad", "good"};
        String[] l2 = {"sad", "happy", "good"};
        findRestaurant(l1, l2);
    }

}
