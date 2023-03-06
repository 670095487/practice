package com.yunn.interview.interviewquestion.d;

import org.junit.Test;

/**
 * @author yunN
 * @date 2023/02/09.
 */
public class BackspaceCompare {
    @Test
    public void test() {

    }


    /*
        定义2个指针 分别从2个字符串的末位开始逐个比较
        定义2个变量 分别记录2个字符串中字符'#'的个数
    */
    public boolean backspaceCompare(String s, String t) {
        int s_p = s.length() - 1, t_p = t.length() - 1;
        int s_c = 0, t_c = 0;
        while (s_p >= 0 || t_p >= 0) {
            // s循环
            while (s_p >= 0) {
                if (s.charAt(s_p) == '#') {
                    // count++
                    s_c++;
                    // 同时s_p需要--，因为#字符是无效字符
                    s_p--;
                    // s_p需要根据s_c的个数做相应的减少，因为#字符除了自己是无效字符以外，还会额外删除s中的一个字符
                } else if (s_c > 0) {
                    s_c--;
                    s_p--;
                } else {
                    break;
                }
            }
            // t循环 （和s循环逻辑一摸一样）
            while (t_p >= 0) {
                if (t.charAt(t_p) == '#') {
                    // count++
                    t_c++;
                    t_p--;
                } else if (t_c > 0) {
                    t_c--;
                    t_p--;
                } else {
                    break;
                }
            }

            /*
                2个字符串当前的指针都大于0，比较值不等则返回false
                2个字符串当前的指针只有一个大于0，则说明2个字符串一定不相等了 （一个字符串比另外一个字符串多一位）
             */
            if (s_p >= 0 && t_p >= 0) {
                if (s.charAt(s_p) != t.charAt(t_p)) {
                    return false;
                }
            } else {
                if (s_p >= 0 || t_p >= 0) {
                    return false;
                }
            }
            // 2个字符串都执行完各自的循环逻辑以后，再对当前位置2个字符串的值进行比较
            s_p--;
            t_p--;
        }
        return true;
    }
}
