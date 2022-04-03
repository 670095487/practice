package com.yunn.autumn.learnspring.listener;

import lombok.Data;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.Clock;

/**
 * @author yunN
 * @date 2022/03/07.
 */
public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext apc = new AnnotationConfigApplicationContext(AppConfig.class);

        Order order = new Order();
        order.setName("elden ring");
        System.out.println("got order");
        apc.publishEvent(new OrderEvent("elden ring"));
        System.out.println("print logs");

    }
}

@Data
class Order{
    String name;
    String orderId;
}

class OrderEvent extends ApplicationEvent {

    String name;


    public OrderEvent(Object source) {
        super(source);
    }

    public OrderEvent(Object source, Clock clock) {
        super(source, clock);
    }

    String getName() {
        return name;
    }
}
