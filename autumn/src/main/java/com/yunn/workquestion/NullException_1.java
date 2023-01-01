package com.yunn.workquestion;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author yunN
 * @date 2022/12/13
 */
public class NullException_1 {

    public static void main(String[] args) {
        System.out.println(Stream.of("a", "a", "b", "", " ", null)
                .filter(Objects::nonNull)
                .collect(Collectors.toList()));
    }
}
