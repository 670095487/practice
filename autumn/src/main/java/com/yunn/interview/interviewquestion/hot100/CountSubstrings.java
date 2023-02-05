package com.yunn.interview.interviewquestion.hot100;

/**
 * @date 2023/02/05
 */
public class CountSubstrings {


    /*
        单个字符本身也算是一个回文子串
     */
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += isPalindrome(i, i, s);
            count += isPalindrome(i, i + 1, s);
        }
        return count;
    }

    int isPalindrome(int start, int end, String s) {
        int count = 0;
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            count++;
            start--;
            end++;
        }
        return count;
    }
}
