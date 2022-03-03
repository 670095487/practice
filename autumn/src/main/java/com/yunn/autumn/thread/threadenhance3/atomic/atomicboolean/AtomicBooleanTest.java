package com.yunn.autumn.thread.threadenhance3.atomic.atomicboolean;

import org.junit.*;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * AtomicBooleanTest
 *
 * @author: yunN
 * @createTime: 2021/01/28 11:39:14
 * @description:
 */
public class AtomicBooleanTest {


    @Test
    public void testCreateWithOutArgs() {
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        System.out.println(atomicBoolean.get());
    }

    @Test
    public void testGetAndSet() {
        AtomicBoolean bool = new AtomicBoolean(true);
        boolean result = bool.getAndSet(false);
        Assert.assertTrue(result);
        Assert.assertTrue(bool.get());
    }
}
