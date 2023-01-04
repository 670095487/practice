package com.yunn.interview.interviewquestion;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @date 2022/12/18
 */
public class _58_1 {

        public String reverseWords(String s) {
            int left = 0, right = s.length() - 1;
            // 去掉字符串开头的空白字符
            while (left <= right && s.charAt(left) == ' ') {
                ++left;
            }

            // 去掉字符串末尾的空白字符
            while (left <= right && s.charAt(right) == ' ') {
                --right;
            }

            Deque<String> d = new ArrayDeque<String>();
            StringBuilder word = new StringBuilder();

            while (left <= right) {
                char c = s.charAt(left);
                if ((word.length() != 0) && (c == ' ')) {
                    // 将单词 push 到队列的头部
                    d.offerFirst(word.toString());
                    word.setLength(0);// 重置上一个单词
                } else if (c != ' ') {
                    word.append(c);
                }
                ++left;
            }
            d.offerFirst(word.toString());

            return String.join(" ", d);
    }

    @Test
    public void test() {
         reverseWords( " leetcode is funny") ;
    }

}
