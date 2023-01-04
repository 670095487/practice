package com.yunn.interview.interviewquestion;

import org.junit.Test;

/**
 * @author yunN
 * @date 2022/12/07.
 */
public class _05 {

    public String replaceSpace(String s) {
        String replace = s.replace("s+\\", ")");
        return replace;
    }

    @Test
    public void test() {
        System.out.println(replaceSpace("we are happy"));
    }
}
