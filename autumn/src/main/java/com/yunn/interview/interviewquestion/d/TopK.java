package com.yunn.interview.interviewquestion.d;

import org.junit.Test;

import java.util.*;

/**
 * @author yunN
 * @date 2023/02/28.
 */
public class TopK {

    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer pre = map.get(num);
            if (pre == null) {
                map.put(num, 1);
            } else {
                map.put(num, pre + 1);
            }
        }
        Map<Integer, Integer> sortByValue = sortByValue(map);
        int idx = 0;
        while (k > 0) {
            for (Map.Entry<Integer, Integer> entry : sortByValue.entrySet()) {
                ans[idx++] = entry.getKey();
                k--;
            }
        }
        return ans;
    }


    /**
     * 1. Map<a,b>.entrySet() to linkedlist<Map<a,b>>
     * 2. collections.sort(自定义比较器)
     * 3. 遍历list,将值依次放入linkedHashMap<>
     */
    // function to sort hashmap by values
    public HashMap<Integer, Integer> sortByValue(Map<Integer, Integer> hm) {
        // Create a list from elements of HashMap
        List<Map.Entry<Integer, Integer>> list =
                new LinkedList<Map.Entry<Integer, Integer>>(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>();
        for (Map.Entry<Integer, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    public int[] topKFrequentUsePriorityQueue(int[] nums, int k) {
        int[] ans = new int[k];
        // 使用优先级队列存储二元组(num, count)
        // 出现次数按从队头到队尾的顺序从小到大排，出现次数最低的在队头（这样队列中的元素个数每次到了k位以后，直接将队头pop出）
        // (p1,p2)->p1[1]-p2[1]: 定义优先级队列的排列顺序，p1[1]-p2[1]意思是，比较元素出现的次数，大的在队列尾，保证队头是较小的数
        PriorityQueue<int[]> queue = new PriorityQueue<>((p1,p2)->p1[1]-p2[1]);
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> en : map.entrySet()) {
            // 队列内元素个数小于k个直接添加
            if (queue.size() < k) {
                queue.add(new int[]{en.getKey(), en.getValue()});
                // 按照规则弹出队头
            }else {
               // 当前元素出现次数大于小顶堆的根结点，说明需要弹出根结点了，这样此时队列中的所保留元素才是topk大数
                // 小于则不用
               if (en.getValue() > queue.peek()[1]){
                   queue.poll();
                   // 将当前结点加入队列
                   queue.add(new int[]{en.getKey(), en.getValue()});
               }
            }
        }
        for (int i = 0; i < k; i++) {
            ans[i] = queue.poll()[0];
        }
        return ans;
    }
    @Test
    public void test() {
        int[] nums = new int[]{1,1,1,2,2,3};
        topKFrequentUsePriorityQueue(nums, 2);
    }


}
