package com.yunn.interview.interviewquestion.hot100;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @author yunN
 * @date 2023/01/21.
 */
public class DecodeString {


    /**
     * 输入：s = "3[a]2[bc]"
     * 输出："aaabcbc"
     * <p>
     * 只有[]内的的字符串才会被乘以倍数输出
     * eg: 3[a2[bc]]
     * 定义2个栈，multiStack
     * stringStack
     * if (current character == '[') push multiStack and stringStack
     * if (current character == ']') get last string from stringStack
     * else push ch to their stack
     */
    public String decodeString(String s) {
        LinkedList<Integer> multi = new LinkedList<>();
        LinkedList<String> strings = new LinkedList<>();
        int cur_multi = 0;
        StringBuilder cur_str = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == '[') {
                multi.addLast(cur_multi);
                strings.addLast(cur_str.toString());
                cur_multi = 0;
                cur_str = new StringBuilder();
            } else if (ch == ']') {
                Integer times = multi.removeLast();
                String last_str = strings.removeLast();
                StringBuilder tmp = new StringBuilder();
                // cur_str = last_str + multi * cur_str
                for (int i = 0; i < times; i++) {
                    tmp.append(cur_str);
                }
                cur_str = new StringBuilder(last_str + tmp);
            } else {
                // 判断是不是数字
                if (Character.isDigit(ch)) {
                    cur_multi = cur_multi * 10 + Integer.parseInt(ch + "");
                } else {
                    cur_str.append(ch);
                }
            }
        }
        return cur_str.toString();
    }

    @Test
    public void test() {
        System.out.println(decodeString("15[a]"));
        // System.out.println(decodeString("3[a]2[bc]"));
    }

    @Test
    public void test1() {
        System.out.println('1' > '0');
    }

}
