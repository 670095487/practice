package com.yunn.autumn.effectiveJava.java8;

import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * RandomTest
 *
 * @author yunnuan
 * @createTime 2020年12月27日 21:23
 * @description https://www.cnblogs.com/zhangboyu/p/7580262.html
 */
@SuppressWarnings("all")
public class RandomTest {
    @Test(expected = NoSuchElementException.class)
    public void whenCreateEmptyOptional_thenNull() {
        Optional<User> emptyOpt = Optional.empty();
        emptyOpt.get();
    }


    /**
     * 测试 orElse() 与 orElseGet()区别
     * 区别：跑一下就知道了
     */
    @Test
    public void whenCreateOfEmptyOptional_thenNullPointerException() {
        User user = new User("wugui", "123");
        User user1 = new User("wugui", "123");
        Optional.ofNullable(user1).orElse(createUser("orElse()"));
        User res = Optional.ofNullable(user1).orElseGet(() -> createUser("orElseGet()"));
        // System.out.println(res.getName());
    }

    /**
     * 传入的对象为空时可以抛自定义异常，不再总抛NullPointerException
     */
    @Test
    public void whenThrowException_thenOk() {
        User user = null;
        User resUser = Optional.ofNullable(user).orElseThrow(() -> new IllegalArgumentException("user对象为空"));
    }

    /**
     * map()的用法
     * <p>
     * 如果传入的user对象为空，又要取pwd时，使用map()取，可以指定默认值
     * 为空时可以取默认值
     */
    @Test
    public void whenMap_thenOk() {
        // User user = new User("anna@gmail.com", "1234");
        User user = null;
        String pwd = Optional.ofNullable(user)
                .map(u -> u.getPwd()).orElse("default@gmail.com");
        System.out.println(pwd);

    }

    /**
     * flatMap()的用法
     * <p>
     * 有值就取新值 无值就取默认值
     */
    @Test
    public void whenFlatMap_thenOk() {
        User user = new User("anna@gmail.com", "1234");
        user.setPosition("Developer");
        String position = Optional.ofNullable(user).flatMap(user1 -> user1.getPosition()).orElse("default");
        System.out.println(position);

    }

    /**
     * filter()的用法
     * <p>
     * 条件满足返回user1本体，未满足返回Null
     */
    @Test
    public void whenFilter_thenOk() {
        User user = new User("annag@mail.com", "1234");
        Optional<User> realUser = Optional.ofNullable(user)
                .filter(user1 -> user1.getPwd() != null && user1.getName().contains("@"));
        System.out.println(realUser.isPresent());
    }

    public User createUser(String advicer) {
        System.out.printf("%s--|||--", advicer);
        return new User("ceshi", "pwd");
    }
}


class User {
    private String name;
    private String pwd;

    private String position;

    public Optional<String> getPosition() {
        return Optional.ofNullable(position);
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public User() {
    }

    public User(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}