package com.yunn.interview;

/**
 * Fruit
 *
 * @author yunN
 * @createTime 2021年02月25日 14:53
 * @description
 */
public interface Fruit {
    public abstract void eat();
}

class Apple implements Fruit {
    public void eat() {
        System.out.println("Apple");
    }
}

class Orange implements Fruit {
    public void eat() {
        System.out.println("Orange");
    }
}

class Factory {
    public static Fruit getInstance(String ClassName) {
        Fruit f = null;
        try {
            f = (Fruit) Class.forName(ClassName).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
}

class Client {
    public static void main(String[] a) {
        Fruit f = Factory.getInstance("com.yun.view.Orange");
        if (f != null) {
            f.eat();
        }
    }
}
