package com.yunn.autumn.leetcode;

import ch.qos.logback.core.joran.spi.XMLUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yunN
 * @date 2022/05/29
 */
public class Permute {

    // 记录总结果
    List<List<Integer>> rs  = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        // 记录单次结果使用
        LinkedList<Integer> track = new LinkedList<>();
        backTracking(nums, track);
        return rs;
    }

    void backTracking(int[] nums, LinkedList<Integer> track) {

        // 退出条件, 如果记录的路径长度已经等于所给数组的长度，说明这一次的遍历已结束
        if (track.size() == nums.length) {
            // 将结果记录到总结果中去
            rs.add(new LinkedList(track));
            return;
        }

        for (int num : nums) {
            // 如果此节点已经在路径中，则跳过本次循环
            if (track.contains(num)) {
                continue;
            }
            // 做选择
            track.add(num);
            // 递归回溯
            backTracking(nums, track);
            // 撤销选择
            track.removeLast();
        }
    }


    @Test
    public void test() {
        System.out.println(permute(new int[]{1, 1, 2}));
    }
}
