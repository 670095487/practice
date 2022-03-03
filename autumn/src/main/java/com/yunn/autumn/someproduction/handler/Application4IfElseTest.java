package com.yunn.autumn.someproduction.handler;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yunN
 * @date 2021/07/15.
 */
public class Application4IfElseTest {

    @Test
    public void testFilterResult() {
        List<TestForWorkDo> testForWorkDos = new ArrayList<>();
        TestForWorkDo account1 = new TestForWorkDo.TestForWorkDoBuilder().amount(new BigDecimal("90")).account("").build();
        TestForWorkDo account2 = new TestForWorkDo.TestForWorkDoBuilder().amount(new BigDecimal("10")).account("yes").build();
        TestForWorkDo account3 = new TestForWorkDo.TestForWorkDoBuilder().amount(new BigDecimal("10")).account("no").build();
        TestForWorkDo account4 = new TestForWorkDo.TestForWorkDoBuilder().amount(new BigDecimal("10")).account("other").build();
        testForWorkDos.add(account1);
        testForWorkDos.add(account2);
        testForWorkDos.add(account3);
        testForWorkDos.add(account4);
        new TestForWork(false).filterResult(testForWorkDos).stream()
        .peek(testForWorkDo -> testForWorkDo.setAccount("peek"))
        .forEach(System.out::println);
    }
}
