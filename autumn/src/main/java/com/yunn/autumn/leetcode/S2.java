package com.yunn.autumn.leetcode;

import org.junit.Test;

/**
 * S2
 *
 * @author yunN
 * @createTime 2021年01月15日 23:07
 * @description 例如， 罗马数字 2 写做II，即为两个并列的 1。12 写做XII，
 * 即为X+II。 27 写做XXVII, 即为XX+V+II。
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，
 * 例如 4 不写做IIII，而是IV。
 * 数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
 * 同样地，数字 9 表示为IX。这个特殊的规则只适用于以下六种情况：
 * I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
 * X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
 * C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/roman-to-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class S2 {

    @Test
    public void testRomanToInt() {
        System.out.println(roman2Int("VIII"));
    }

    /**
     * @param romanVal .
     * @return .
     */
    public int roman2Int(String romanVal) {
        int sum = 0;
        int preNum = getRomanValue2Int(romanVal.charAt(0));
        for(int i = 1;i < romanVal.length(); i ++) {
            int num = getRomanValue2Int(romanVal.charAt(i));
            if(preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    /**
     * 罗马数字和阿拉伯数字的映射关系
     *
     * @param aChar .
     * @return .
     */
    private int getRomanValue2Int(char aChar) {
        switch (aChar) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
