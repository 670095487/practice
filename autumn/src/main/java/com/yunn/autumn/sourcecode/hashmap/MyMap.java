package com.yunn.autumn.sourcecode.hashmap;

/**
 * Map
 *
 * @author: yunN
 * @createTime: 2020/09/07
 * @description: 模仿jdk实现hashMap
 */
public interface MyMap<K, V> {

    /**
     * 存值
     *
     * @param k
     * @param v
     * @return
     *
     */
    V put(K k, V v);

    /**
     * 获取值
     *
     * @param k
     * @return
     */
    V get(K k);

    /**
     * 获取当前map的大小
     *
     * @return
     */
    int size();

    /**
     * map中对应结点下存放的键值对
     *
     * @param <K>
     * @param <V>
     */
    interface Entry<K, V> {

        /**
         * 获取key
         *
         * @return
         */
        K getKey();

        /**
         * 获取value
         *
         * @return
         */
        V getValue();
    }
}
