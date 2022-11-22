package com.yunn.autumn;

import org.junit.Test;

import javax.naming.NoInitialContextException;

/**
 * @author yunN
 * @date 2022/11/17
 */
public class BinarySerach {

    public int binarySearch(int[] arr, int target){
        int left = 0, right = arr.length - 1;
        while(left <= right){
            // 等同于(left+right)/2，但是当left和right较大时两者相加容易发生溢出
            int mid = left + (right-left) / 2;

            if(arr[mid] == target){
                // 找到了target就直接返回mid
                return mid;
            }else if(arr[mid] > target){
                // 如果当前值大于target，而数组是升序的，说明target在数组的左半边[left,mid-1]，但是由于区间定义是左闭右开，因此数组左半边写成[left,mid)，所以right=mid
                right = mid - 1;
            }else {
                // 最后，如果当前值小于target，则说明target在数组的右半边[mid+1,right)，因此left直接等于mid+1就好了
                left = mid + 1;
            }
        }
        // 找不到就返回-1
        return -1;
    }

    @Test
    public void test() {
        System.out.println(binarySearch(new int[]{1, 2, 3}, 5));
    }
}
