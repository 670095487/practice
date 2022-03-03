package com.yunn.autumn.util.businessday;

import java.time.LocalDate;

/**
 * @author yunN
 * @date 2021/08/26.
 */
interface BusinessDayUtilService {

    LocalDate getNextBusinessDay(LocalDate localDate);
}

class BusinessDayUtilServiceImpl implements BusinessDayUtilService {

    //simple example for oracle
    @Override
    public LocalDate getNextBusinessDay(LocalDate localDate) {
        int dayOfWeek = localDate.getDayOfWeek().getValue();
        switch (dayOfWeek) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 7:
                return localDate.plusDays(1);
            case 5:
                return localDate.plusDays(3);
            case 6:
                return localDate.plusDays(2);
            default:
                return null;
        }
    }
}


