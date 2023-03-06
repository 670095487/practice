package com.yunn.interview.interviewquestion.d;

import java.util.LinkedList;

/**
 * @author yunN
 * @date 2023/02/26.
 */
public class IsValid {

    public boolean isValid(String s) {
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // 每次遍历如果遇到一个左括号，就相应的push一个右括号到栈里去
            // 当遍历时遇到了右括号时，就从栈中弹出一个右括号，直到字符串全部遍历完成以后，
            // 检查栈此时是否为空，为空则说明全部匹配成功
            if (ch == '(') {
                list.push(')'); // push == addFirst
            } else if (ch == '[') {
                list.push(']');
            } else if (ch == '{') {
                list.push('}');
                // 当前遍历元素不是左括号
                // 当前栈已经为空，或者当前栈顶元素也不等于当前遍历元素（当前遍历元素一定是某个右括号）
                // 说明此时已经出现了不匹配的情况，直接返回false即可
            } else if (list.isEmpty() || list.peek() != ch) {
                return false;
            } else {
                list.pop();
            }
        }
        return list.isEmpty();
    }
}
