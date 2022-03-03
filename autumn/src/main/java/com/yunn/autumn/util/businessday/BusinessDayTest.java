package com.yunn.autumn.util.businessday;

import org.junit.Test;

import java.time.LocalDate;

/**
 * @author yunN
 * @date 2021/08/26.
 */
public class BusinessDayTest {

    private final BusinessDayUtilServiceImpl businessDayUtilService = new BusinessDayUtilServiceImpl();

    @Test
    public void getNextDay_test() {
        System.out.println(businessDayUtilService.getNextBusinessDay(LocalDate.of(2021, 8, 29)));
    }
}
