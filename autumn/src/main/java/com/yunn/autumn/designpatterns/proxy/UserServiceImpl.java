package com.yunn.autumn.designpatterns.proxy;

/**
 * @author yunN
 * @date 2021/10/25
 */
public class UserServiceImpl implements UserService{

    @Override
    public void sayHello() {
        System.out.println("This is userServiceImpl");
    }
}
