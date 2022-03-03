package com.yunn.autumn.designpatterns.strategy;

/**
 * SorterStrategy
 *
 * @Author: Bff
 * @CreateTime: 2020-07-06
 * @Description: 排序策略--选择排序
 * <p>
 * 算法逻辑类，可以对所有类型的数组根据预设的逻辑进行排序
 * 比较器接口，提供一个比较大小的方法
 * cat实现类，需要实现比较器接口，自定义比较规则
 * 调用类， 调用算法逻辑类，但是传入的是 要比较的参数，以及这种参数对应的比较规则
 */
class SorterStrategy<T> {

    /**
     * 排序的算法逻辑
     *
     * @param arr
     * @param comparator
     */
    void sort(T[] arr, Comparator comparator) {

        for (int i = 0; i < arr.length; i++) {
            //将当前数组下标值赋为最小值
            int minPos = i;
            //将当前数组下标值和最小值进行比较
            for (int j = i + 1; j < arr.length; j++) {
                minPos = comparator.compare(arr[j], arr[minPos]) == -1 ? j : minPos;
            }
            swap(arr, i, minPos);
        }
    }

    /**
     * 对数组的指定两个下标值进行位置互换
     *
     * @param arr 泛型数组
     * @param i   数组下标1
     * @param j   数组下标2
     */
    private void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
