package com.yunn.interview.interviewquestion.d;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yunN
 * @date 2023/03/03.
 */
public class LetterCombinations {

    List<String> ans = new ArrayList<>();
    // debug去理解
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return ans;
        }
        // 表示0，1，2，……，9 数字所对应的英文数字
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtrack(digits, numString, 0);
        return ans;
    }

    StringBuilder temp = new StringBuilder();

    /**
     *
     * @param digits 给定字符
     * @param numString 原始映射数组（记录 数字--字母
     * @param num 用来控制回溯到第几个digit, 首次是0，意思是当前回溯的起点是digits中的第一个元素
     *            而后每次回溯+1，直到 num == digits.length()
     */
    void backtrack(String digits, String[] numString, int num) {
        if (num == digits.length()) {
            ans.add(temp.toString());
            return;
        }

        // str表示当前num对应的字符串, num = 2对应的就是"abc"
        String str = numString[digits.charAt(num) - '0'];
        for (int i = 0; i < str.length(); i++) {
            temp.append(str.charAt(i));
            backtrack(digits, numString, num + 1);
            temp.deleteCharAt(temp.length() - 1);
        }
    }

    @Test
    public void test() {
        System.out.println(letterCombinations("23"));
    }
}
