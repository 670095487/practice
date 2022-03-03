package com.yunn.test;

import com.yunn.autumn.designpatterns.proxy.UserServiceNoImpl;
import org.junit.Test;

/**
 * @author yunN
 * @date 2021/12/01
 */
public class TestUnit {
    @Test
    public void testEquals() {
        String s1 = new String("s1");
        String s2 = "s1";
        UserServiceNoImpl userServiceNo = new UserServiceNoImpl();
        UserServiceNoImpl userServiceNo1 = new UserServiceNoImpl();
        System.out.println(userServiceNo.equals(userServiceNo1));
        System.out.println(userServiceNo == userServiceNo1);
        System.out.println(s1.equals(s2));
        System.out.println(s1 == s2);// == 比较的是引用，equals比较的是值吗
    }
}
