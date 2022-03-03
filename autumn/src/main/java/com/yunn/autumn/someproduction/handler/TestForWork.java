package com.yunn.autumn.someproduction.handler;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author yunN
 * @date 2021/06/28
 */
@RequiredArgsConstructor
public class TestForWork {

    private final Boolean cepBilling;

    private static Map<String, TestForWorkDo> getStringTestForWorkDoMap(List<TestForWorkDo> list) {
        return list.stream()
                .sorted(Comparator.comparing(TestForWorkDo::getTime).reversed())
                .collect(Collectors.groupingBy(TestForWorkDo::getAccount,
                        Collectors.collectingAndThen(Collectors.toList(), value -> value.get(0))));
    }

    public List<TestForWorkDo> filterResult(List<TestForWorkDo> workDos) {
        return workDos.stream()
                .filter(workDo -> !filterCepBilling(workDo) == cepBilling)
                .collect(Collectors.toList());
    }

    private Boolean filterCepBilling(TestForWorkDo testForWorkDo) {
        return StringUtils.isEmpty(testForWorkDo.getAccount()) || !"yes".equalsIgnoreCase(testForWorkDo.getAccount());
    }

    @Test
    public void testUUIDLength() {
        System.out.println(UUID.randomUUID().toString().length());
    }
}

@Data
@Builder
class TestForWorkDo {
    private String account;
    private String name;
    private BigDecimal amount;
    private LocalDateTime time;


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TestForWorkDo that = (TestForWorkDo) o;
        return account.equals(that.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(account);
    }
}
