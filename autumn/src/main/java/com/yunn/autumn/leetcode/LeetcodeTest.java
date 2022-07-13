package com.yunn.autumn.leetcode;

import org.junit.Test;

import java.time.LocalDate;
import java.time.ZoneId;

/**
 * @author yunN
 * @date 2022/06/28
 */
public class LeetcodeTest {

    @Test
    public void test() {
        System.out.println(createTimestamp());
    }

    public long createTimestamp() {
        return  LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toEpochSecond();
    }
}
