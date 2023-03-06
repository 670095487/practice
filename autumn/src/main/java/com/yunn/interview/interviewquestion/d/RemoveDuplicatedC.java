package com.yunn.interview.interviewquestion.d;

import java.util.LinkedList;

/**
 * @author yunN
 * @date 2023/02/26.
 */
public class RemoveDuplicatedC {

    public String removeDuplicates(String s) {
        LinkedList<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!stack.isEmpty() && ch == stack.peek()) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }
        return ans.reverse().toString();
    }
}
