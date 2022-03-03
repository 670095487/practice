package com.yunn.autumn.sourcecode.hashmap;

/**
 * HashMap
 *
 * @author: yunN
 * @createTime: 2020/09/07
 * @description: 实现hashMap
 */
public class MyHashMyMap<K, V> implements MyMap<K, V> {

    /**
     * 定义一个初始键值对数组【即map中即将存放的键值对】
     */
    private Entry[] table = null;

    /**
     * map初始容量
     */
    private int size = 0;

    /**
     * map初始长度
     */
    public MyHashMyMap() {
        table = new Entry[16];
    }

    /**
     * 1.取hashCode计算索引
     * 2.当前索引下是否有值
     * 3.没有值--直接put
     * 4.有值--将next域置为旧值，将索引处置为当前值
     *
     * @param k .
     * @param v .
     * @return .
     */
    @Override
    public V put(K k, V v) {
        int index = hash(k);
        //拿到当前数组下标索引对应的值
        Entry entry = table[index];
        //没有值
        if (null == entry) {
            table[index] = new Entry<>(k, v, index, null);
            //有值，将next域中的值置为旧值，新值存到value域
        } else {
            table[index] = new Entry<>(k, v, index, entry);
        }
        size++;
        return (V) table[index].getValue();
    }

    /**
     * key hash index下标
     * 判断当前这个下标是否有值
     * 有值:判断key是否相等=>直接返回
     * 不相等:判断next是否为空
     * 不为空:判断key是否相等=>直接返回
     * 不相等:判断next是否为空=>直接返回
     * 没有值:直接返回null
     *
     * @param k
     * @return
     */
    @Override
    public V get(K k) {
        //如果当前map为空，就直接返回
        if (size() == 0) {
            return null;
        }
        int index = hash(k);
        //根据k计算得到的对应下标的键值对如下，现在要做的是遍历entry,看是否能在entry中找到对应的k
        return (V) findValue(k, table[index]);
    }

    private V findValue(K k, Entry<K, V> entry) {
        if (entry == null) {
            return null;
        } else {
            if (k.equals(entry.getKey()) || k == entry.getKey()) {
                return entry.getValue();
            } else if (entry.next != null) {
                //递归调用其本身
                findValue(k, entry.next);
            }
        }
        return null;
    }


    @Override
    public int size() {
        if (size == 0) {
            return 0;
        } else {
            return size;
        }
    }

    /**
     * 成员属性：kv对，hashCode , next域
     *
     * @param <K>
     * @param <V>
     */
    public static class Entry<K, V> implements MyMap.Entry<K, V> {
        K k;
        V v;
        int hashCode;
        /**
         * next域，实际上next域中存放的还是一个kv对，entry类型的
         */
        Entry<K, V> next;

        public Entry(K k, V v, int hashCode, Entry<K, V> next) {
            this.k = k;
            this.v = v;
            this.hashCode = hashCode;
            this.next = next;
        }

        @Override
        public K getKey() {
            return k;
        }

        @Override
        public V getValue() {
            return v;
        }
    }

    private int hash(K k) {
        int index = k.hashCode() % 16;
        return index > 0 ? index : Math.abs(index);
    }
}
