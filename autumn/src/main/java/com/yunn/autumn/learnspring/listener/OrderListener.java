package com.yunn.autumn.learnspring.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author yunN
 * @date 2022/03/07.
 */
@Component
public class OrderListener implements ApplicationListener<OrderEvent> {

    @Override
    public void onApplicationEvent(OrderEvent event) {
        if (event.getName().equalsIgnoreCase("elden ring")) {
            System.out.println("elden ring - 1");
        }
    }
}
