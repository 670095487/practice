package com.yunn.autumn.leetcode;

/**
 * @author yunN
 * @date 2022/05/10
 */
public class ReverseVowels {

    public String reverseVowels(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] chars = s.toCharArray();
        while (left < right) {
            if (isVowel(chars[left])) {
                while (right > 0) {
                    if (isVowel(chars[right])) {
                        swap(chars, left, right);
                        right--;
                        break;
                    }
                    right--;
                }
            }
            left++;
        }
        return new String(chars);
    }

    public boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) >= 0;
    }

    public void swap(char[] s, int l, int r) {
        char tmp = s[l];
        s[l] = s[r];
        s[r] = tmp;
    }
}
