package com.yunn.autumn.someproduction.handler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

class ClassA {
    String id;
    String realName;

    public ClassA(String id, String realName) {
        this.id = id;
        this.realName = realName;
    }

    @Override
    public String toString() {
        return "ClassA{" +
                "id='" + id + '\'' +
                ", realName='" + realName + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public String getRealName() {
        return realName;
    }
}

class ClassB {
    String id;
    String nickName;

    public ClassB(String id, String nickName) {
        this.id = id;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "ClassB{" +
                "id='" + id + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public String getNickName() {
        return nickName;
    }
}

class Test {
    public static void main(String[] args) {
        List<ClassA> aList = new ArrayList<>(Arrays.asList(
                new ClassA("1", "张三"),
                new ClassA("2", "李四"),
                new ClassA("3", "王五")
        ));
        List<ClassB> bList = new ArrayList<>(Arrays.asList(
                new ClassB("2", "李某"),
                new ClassB("3", "王某"),
                new ClassB("4", "赵某")
        ));

        //aList与bList的交集
        List<ClassA> intersectA = aList
                .stream() //获取第一个集合的Stream1
                .filter(  //取出Stream1中符合条件的元素组成新的Stream2，lambda表达式1返回值为true时为符合条件
                        a ->  //lambda表达式1，a为lambda表达式1的参数，是Stream1中的每个元素
                                bList.stream() //获取第二个集合的Stream3
                                        .map(ClassB::getId) //将第二个集合每个元素的id属性取出来，映射成新的一个Stream4
                                        .anyMatch( //返回值（boolean）：Stream4中是否至少有一个元素使lambda表达式2返回值为true
                                                id -> //lambda表达式2，id为lambda表达式2的参数，是Stream4中的每个元素
                                                        Objects.equals(a.getId(), id) //判断id的值是否相等
                                        )
                )
                .collect(Collectors.toList()); //将Stream2转换为List
        System.out.println(intersectA);
    }

}
