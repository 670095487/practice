package com.yunn.autumn.leetcode;


import org.junit.Test;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * IsValid
 *
 * @author yunN
 * @createTime 2021年02月05日 15:40
 * @description 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 */
public class IsValid {

    public boolean isValid(String s) {
        int length = s.length();
        if (length % 2 != 0 || length == 0 || s.trim().length() == 0) return false;

        Map<Character, Character> pairs = new HashMap<Character, Character>() {

            private static final long serialVersionUID = 9034448004407350077L;

            {
                put(')', '(');
                put(']', '[');
                put('}', '{');
            }
        };
        Deque<Character> stack = new LinkedList<Character>();

        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            //如果是右括号，判断一下，当前处于栈顶的元素是否是与之匹配的左括号
            if (pairs.containsKey(ch)) {
                //peek()取栈顶元素 与 val进行比较，若值不相等，则返回false
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                //相等弹栈，清空栈内左右括号
                stack.pop();
            } else {
                //不是右括号，则压栈
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    @Test
    public void testStrIsBlank() {
        System.out.println(isValid("()"));
    }
}
