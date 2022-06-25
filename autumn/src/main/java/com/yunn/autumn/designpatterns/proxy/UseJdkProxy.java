package com.yunn.autumn.designpatterns.proxy;

import java.lang.reflect.Proxy;

/**
 * @author yunN
 * @date 2021/10/25
 */
public class UseJdkProxy {

    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        UserService useServiceProxyByJdk = (UserService) Proxy.newProxyInstance(
                UseJdkProxy.class.getClassLoader(),
                userService.getClass().getInterfaces(),
                (proxy, method, args1) -> {
                    System.out.println("Use Jdk proxy to print log ...");
                    return method.invoke(userService, args1);
                });
        useServiceProxyByJdk.sayHello();
    }
}
