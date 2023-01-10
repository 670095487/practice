package com.yunn.autumn.designpatterns.observe;

import java.io.File;

/**
 * @date 2023/01/07
 */
public class EmailNotificationListener implements EventListener{

    private String email;

    public EmailNotificationListener(String email) {
        this.email = email;
    }

    @Override
    public void update(String eventType, File file) {
        System.out.println("Email to " + email + ": Someone has performed " + eventType
                + " operation with the following file: " + file.getName());
    }
}
