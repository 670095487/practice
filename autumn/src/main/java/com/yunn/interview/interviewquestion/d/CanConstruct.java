package com.yunn.interview.interviewquestion.d;

/**
 * @author yunN
 * @date 2023/02/22.
 */
public class CanConstruct {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[128];
        for (char c : magazine.toCharArray()) {
            arr[c-'A']++;
        }
        for (char c : ransomNote.toCharArray()) {
            arr[c-'A']--;
            if (arr[c - 'A'] < 0) {
                return false;
            }
        }
        return true;
    }
}
