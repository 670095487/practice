package com.yunn.autumn.practice;

import java.util.HashSet;

/**
 * @author yunN
 * @date 2021/09/11.
 */
public class ThreadLocalLearn {

    static HashSet<Val<Integer>> set = new HashSet<>();

    // 线程安全
    synchronized static void addSet(Val<Integer> val) {
        set.add(val);
    }

    // ThreadLocal保证每个线程之间的数据隔离
    static ThreadLocal<Val<Integer>> c = new ThreadLocal<Val<Integer>>() {

        @Override
        protected Val<Integer> initialValue() {
            Val<Integer> v = new Val<>();
            v.setV(0);
            addSet(v);
            return v;
        }

    };

    public Integer stat() {
        // set.stream().map(x->x.getV()).reduce((a, x)->a+x).get();
        boolean present = set.stream().map(Val::getV).reduce(Integer::sum).isPresent();

        if (present) {
            return set.stream().map(Val::getV).reduce(Integer::sum).get();
        }
        return null;
    }

    static class Val<T> {

        private T v;

        public T getV() {
            return v;
        }

        public void setV(T v) {
            this.v = v;
        }
    }
}


