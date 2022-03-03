package com.yunn.autumn.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

//编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。
//
// 示例 1:
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
//
//
// 示例 2:
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
//
//
// 说明:
//
// 所有输入只包含小写字母 a-z 。
// Related Topics 字符串
@SuppressWarnings("all")
public class Solution {

    String str[] = {"flower", "flow", "flight"};

    /**
     * 思路：先遍历每一个单词，逐一取依次取字母，存入某容器中，
     * 直到某个字母存入容器中与上次存入的字母不一致时 返回除本次以外
     * 容器内的所有字母，若第一次就出现不一致，则返回""
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        //判空
        if (strs.length == 0) {
            return "数组不能为空！";
        }
        //取值
        HashMap<String, String> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {

            }
        }
        return "";
    }


    @Test
    public void test() {
        String s = "flower";
        char[] chars = s.toCharArray();
        String.valueOf(chars[0]);
    }

    /**
     * 两数之和
     * map <key存放数，val存放数在数组中的下标></>
     * 思路：1.target - nums[i] = D_val if(map.contains(D_val)) return new int{map.getKey(D_val),nums[i]}
     * 2.else map.put(nums[i],i)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int D_val = target - nums[i];
            if (map.containsKey(D_val)) {
                //返回符合条件的数在原数组中的下标
                return new int[]{map.get(D_val), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

    @Test
    public void reverseTest() {
        System.out.println(reverse(320));
    }

    /**
     * 整数反转
     * 思路
     * rev 记录最终返回出去的数字序列
     * pop 依次记录 每次循环操作的值对10取余的结果
     *
     * @param x /
     * @return
     */
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {//
            int pop = x % 10;//pop = 0
            x /= 10;//x = 3
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;//10
        }
        return rev;
    }
}
