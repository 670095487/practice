package com.yunn.autumn.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yunN
 * @date 2022/11/16.
 */
public class LC146 {

    class DLinkedList {
        int key;
        int value;
        DLinkedList pre;
        DLinkedList next;

        public DLinkedList() {
        }

        public DLinkedList(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, DLinkedList> map = new HashMap<>();
    private DLinkedList head;
    private DLinkedList tail;
    private int size;
    private final int capacity;



    public LC146(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {

        return 0;
    }

    public void put(int key, int value) {

    }
}
