package com.yunn.autumn.thread.不可变类;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author yunN
 * @date 2021/11/21.
 * <p>
 * 如果类中存在数组或集合，在提供给外部访问之前需要做防御性复制
 */
public class DefensiveReplicaDemo {

    private final List<Integer> data = new ArrayList<>();

    public DefensiveReplicaDemo() {
        data.add(1);
        data.add(2);
        data.add(3);
    }

    public List<Integer> getData() {
        return Collections.unmodifiableList(new ArrayList<>(data));
    }

}


class TestDefensive {

    public static void main(String[] args) {
        DefensiveReplicaDemo defensiveReplicaDemo = new DefensiveReplicaDemo();
        List<Integer> data = defensiveReplicaDemo.getData();
        data.add(4);
        System.out.println(data);
    }
}
