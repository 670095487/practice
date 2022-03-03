package com.yunn.autumn.designpatterns.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author yunN
 * @date 2021/10/25 21点43分
 */
public class UseCglibProxy {

    public static void main(String[] args) {
        UserServiceNoImpl userService = new UserServiceNoImpl();//target class
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(UseCglibProxy.class.getClassLoader());
        enhancer.setSuperclass(userService.getClass());
        MethodInterceptor i = new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("Use cglib proxy to print log ...");
                return method.invoke(userService, objects);
            }
        };
        enhancer.setCallback(i);
        UserServiceNoImpl userServiceProxyByCglib = (UserServiceNoImpl) enhancer.create();
        userServiceProxyByCglib.sayHello();
    }
}
