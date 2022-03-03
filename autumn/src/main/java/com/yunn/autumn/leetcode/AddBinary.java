package com.yunn.autumn.leetcode;

import org.junit.Test;

/**
 * @author yunN
 * @date 2021/12/27
 * <p>
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * <p>
 * 输入为 非空 字符串且只包含数字1和0。
 * <p>
 * <p>
 * <p>
 * 示例1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddBinary {


    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int n = Math.max(a.length(), b.length()), carry = 0;

        for (int i = 0; i < n; i++) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            sb.append(carry % 2);
            carry = carry / 2;
        }
        //
        // for (int i = 0; i < n; i++) {
        //     carry += i + 1 < a.length() ? (a.charAt(i) - '0') : 0;
        //     carry += i + 1 < b.length() ? (a.charAt(i) - '0') : 0;
        //     sb.append(carry % 2);
        //     carry = carry / 2;
        // }
        if (carry == 1) {
            sb.append(1);
        }

        return sb.reverse().toString();
    }

    @Test
    public void testAddBinary() {
        System.out.println(addBinary("11", "1"));
    }


    @Test
    public void charAdd() {
        char c = '1' - '0';
        char a = '1' + '1' - '0';
        System.out.println(a);
    }

    @Test
    public void iAndi() {
        int i = 0;
        System.out.println(i + "---" + (i++));
        System.out.println("---------------");
        i = 0;
        System.out.println(i + "---" + (++i));
    }

    @Test
    public void test1() {
        String s = "123456789";
        for (int i = 0; i < s.length(); i++) {
            System.out.println(s.charAt(s.length() - 1 - i));
        }
    }
}
