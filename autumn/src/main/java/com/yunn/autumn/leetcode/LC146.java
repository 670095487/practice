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


    // head <-> tail, 后面添加进去的node都是在这2个中间插入
    public LC146(int capacity) {
        size = 0;
        head = new DLinkedList();
        tail = new DLinkedList();
        head.next = tail;
        tail.pre = head;
        this.capacity = capacity;
    }

    public int get(int key) {
        DLinkedList node = map.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedList node = map.get(key);
        // 已有元素，替换value
        if (node != null) {
            node.value = value;
            moveToHead(node);
        } else {
            DLinkedList newNode = new DLinkedList(key, value);
            map.put(key, newNode);
            addToHead(newNode);
            size++;
            // 判断容量
            if (size > capacity) {
                DLinkedList oldNode = removeTailNode();
                map.remove(oldNode.key);
                size--;
            }
        }

    }

    private void addToHead(DLinkedList newNode) {
        newNode.pre = head;
        newNode.next = head.next;
        head.next.pre = newNode;
        head.next = newNode;
    }

    private void moveToHead(DLinkedList node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(DLinkedList node) {
        node.pre.next = node.next;
        node.next.pre  = node.pre;
    }

    private DLinkedList removeTailNode() {
        DLinkedList tailNode = tail.pre;
        removeNode(tailNode);
        return tailNode;
    }
}
