package com.yunn.interview.interviewquestion.hot100;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @date 2023/01/28
 */
public class ReconstructQueue {

    /**
     * @param p p[h_i][k_i], h_i表示身高，k_i表示i所处的位置前有多少个 >= h_i的元素
     * @return
     */
    public int[][] reconstructQueue(int[][] p) {
        // 先根据身高降序排列,身高相等按k做升序排列
        List<int[]> sorted1 = Arrays.stream(p)
                .sorted(new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        return o1[0] - o2[0] == 0 ? o1[1] - o2[1] : o2[0] - o1[0];
                    }
                }).collect(Collectors.toList());
        List<int[]> queue = new ArrayList<>();
        // 根据k值将数组插入到对应的位置
        for (int[] ints : sorted1) {
            queue.add(ints[1], ints);
        }
        return queue.toArray(new int[queue.size()][]);
    }

    @Test
    public void test() {
        int[][] arr = new int[][]{
                {1, 2}, {3, 4}
        };
        for (int[] ints : Arrays.asList(arr)) {
            System.out.println(ints[0] + "-" + ints[1]);
        }
    }
}
