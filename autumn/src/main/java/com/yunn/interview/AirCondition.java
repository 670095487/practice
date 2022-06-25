package com.yunn.interview;

/**
 * Fruit
 *
 * @author yunN
 * @createTime 2021年02月25日 14:53
 * @description
 */
public interface AirCondition {
    void run();
}

class MediaAirCondition implements AirCondition {
    public void run() {
        System.out.println("美的空调正在运行中……");
    }
}

class HairAirCondition implements AirCondition {
    public void run() {
        System.out.println("海尔空调正在运行中……");
    }
}

class Factory {
    public static AirCondition getInstance(String ClassName) {
        if (ClassName == null || ClassName.isEmpty()) {
            return null;
        }
        if (ClassName.equalsIgnoreCase("md")) {
            return new MediaAirCondition();
        } else if (ClassName.equalsIgnoreCase("hr")) {
            return new HairAirCondition();
        }
        return null;
    }
}

class Client {
    public static void main(String[] a) {
        AirCondition media = Factory.getInstance("md");
        if (media != null) {
            media.run();
        }
        AirCondition hair = Factory.getInstance("hr");
        if (hair != null) {
            hair.run();
        }
    }
}
