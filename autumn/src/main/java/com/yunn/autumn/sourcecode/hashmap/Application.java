package com.yunn.autumn.sourcecode.hashmap;

/**
 * Application
 *
 * @author: yunN
 * @createTime: 2020/09/07
 * @description:
 */
public class Application {
    public static void main(String[] args) {
        MyHashMyMap<String, String> map = new MyHashMyMap<>();
        map.put("hash2", "自己写的hashMap");
        map.put("hash2", "自己写的hashMap2");
        map.put("hash3", "自己写的hashMap");
        System.out.println(map.get("hash2"));
    }
}
