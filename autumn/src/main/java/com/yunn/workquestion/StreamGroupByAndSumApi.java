package com.yunn.workquestion;

import lombok.Builder;
import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yunN
 * @date 2022/04/04
 */
public class StreamGroupByAndSumApi {

    public static void main(String[] args) {
        List<StreamGroupByAndSumApiUseObj> testData = getTestData();
        List<StreamGroupByAndSumApiUseObj> result = new ArrayList<>(testData.stream()
                .collect(Collectors.toMap(StreamGroupByAndSumApiUseObj::getName, s -> s, (first, second) -> {
                    double preAmount = first.getAmount();
                    second.setAmount(Double.sum(preAmount, second.getAmount()));
                    return second;
                })).values());
        result.forEach(System.out::println);
    }

    @Test
    public void test1() {
        List<StreamGroupByAndSumApiUseObj> testData = getTestData();
        new ArrayList<>(testData.stream()
                .collect(Collectors.groupingBy(StreamGroupByAndSumApiUseObj::getName,
                        Collectors.summarizingDouble(StreamGroupByAndSumApiUseObj::getAmount)))
                .values());
    }

    private static List<StreamGroupByAndSumApiUseObj> getTestData() {
        StreamGroupByAndSumApiUseObj zsh0 = StreamGroupByAndSumApiUseObj.builder()
                .name("zsh")
                .amount(5.0)
                .build();

        StreamGroupByAndSumApiUseObj zsh1 = StreamGroupByAndSumApiUseObj.builder()
                .name("zsh")
                .amount(3)
                .build();

        StreamGroupByAndSumApiUseObj zzc1 = StreamGroupByAndSumApiUseObj.builder()
                .name("zzc")
                .amount(1)
                .build();

        StreamGroupByAndSumApiUseObj zzc2 = StreamGroupByAndSumApiUseObj.builder()
                .name("zzc")
                .amount(9)
                .build();

        StreamGroupByAndSumApiUseObj wbx = StreamGroupByAndSumApiUseObj.builder()
                .name("wbx")
                .amount(11)
                .build();

        return Arrays.asList(zsh0, zsh1, zzc1, zzc2, wbx);
    }

}

@Data
@Builder
class StreamGroupByAndSumApiUseObj {
    private String name;
    private double amount;
}
