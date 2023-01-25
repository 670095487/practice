package com.yunn.interview.interviewquestion.hot100;

import org.junit.Test;

/**
 * @author yunN
 * @date 2023/01/21.
 */
public class DecodeString {


    /**
     * 输入：s = "3[a]2[bc]"
     * 输出："aaabcbc"
     * <p>
     * 栈 数字进栈，
     * 字母 遍历进栈
     */
    public String decodeString(String s) {

        char[] chars = s.toCharArray();
        StringBuffer ans = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            String sub = "fx019";
            if (Character.isDigit(s.charAt(i))) {
                for (int j = 0; j < (int) s.charAt(j); j++) {
                    if (!sub.equals("fx019"))
                        ans.append(sub);
                }
            } else {
                int high = i + 1;
                while (s.charAt(high) != s.charAt(high)) {
                    high++;
                }
                sub = s.substring(i, high);
            }
        }
        return ans.toString();
    }

    @Test
    public void test() {
        decodeString("3ac");
    }

}
