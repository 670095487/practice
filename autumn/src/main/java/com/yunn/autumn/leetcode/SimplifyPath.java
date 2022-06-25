package com.yunn.autumn.leetcode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author yunN
 * @date 2022/06/20
 */
public class SimplifyPath {


    public String simplifyPath(String path) {
        String[] names = path.split("/");
        Deque<String> stack = new ArrayDeque<String>();
        for (String name : names) {
            if ("..".equalsIgnoreCase(name) && !stack.isEmpty()) {
                stack.pollLast();// 退一级目录
            } else if (name.length() > 0 && !".".equalsIgnoreCase(name) && !"..".equalsIgnoreCase(name)) {
                stack.offerLast(name);// 有效路径，加入队列
            }
        }

        StringBuilder rs = new StringBuilder();
        if (stack.isEmpty()) {
            return "/";
        }

        while (!stack.isEmpty()) {
            rs.append("/");
            rs.append(stack.pollFirst());
        }
        // rs.deleteCharAt(rs.length()-1);
        return rs.toString();
    }


    @Test
    public void test() {
        System.out.println(simplifyPath("/../"));
    }

    @Test
    public void test1() {
        Deque<String> stack = new ArrayDeque<String>();
        stack.offerLast("a");
        stack.offerLast("b");
        System.out.println(stack);
    }
}
