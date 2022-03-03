package com.yunn.autumn.redis;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * LRUApplicaiton
 *
 * @author: yunN
 * @createTime: 2020/09/14
 * @description: redis的lru算法实现
 */
@SuppressWarnings("all")
public class LRUCache implements Serializable {
    private int capacity;
    private int len;

    class Data {
        int key;
        int value;
        Data next;
        Data pre;
    }

    private Map<Integer, Data> dataSet;

    private Data head;

    private Data rail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.len = 0;
        this.head = null;
        this.rail = null;
        this.dataSet = new HashMap<Integer, Data>();
    }

    public int get(int key) {
        if (!dataSet.containsKey(key)) {
            return -1;
        }
        Data temp = dataSet.get(key);
        if (temp == head) {
            return temp.value;
        }
        return 0;
    }


    //LRU：最近最少使用算法，最近最少使用的内存页面将被置换出内存
    public synchronized void main(String[] args) {

    }

}
