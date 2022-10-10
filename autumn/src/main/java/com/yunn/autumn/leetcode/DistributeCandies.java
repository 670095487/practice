package com.yunn.autumn.leetcode;

import java.util.HashSet;

/**
 * @author yunN
 * @date 2022/07/19.
 */
public class DistributeCandies {

    public int distributeCandies(int[] candyType) {
        HashSet<Integer> set = new HashSet<>();
        for (int j : candyType) {
            set.add(j);
        }
        int n = candyType.length;// 糖果总数
        int typeCount = set.size();// 糖果种类
        int canEat = n / 2;// 能吃多少糖果
        if (canEat > typeCount) return typeCount;
        if (canEat < typeCount) return canEat;
        if (canEat == typeCount) return canEat;
        return 0;
    }
}
