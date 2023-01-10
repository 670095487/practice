package com.yunn.autumn.designpatterns.observe;

import java.io.File;

/**
 * @date 2023/01/07
 */
public class LogOpenListener implements EventListener{

    private File log;

    public LogOpenListener(String fileName) {
        this.log = new File(fileName);
    }

    @Override
    public void update(String eventType, File file) {
        System.out.println("Save to log " + log + ": Someone has performed " + eventType
                + " operation with the following file: " + file.getName());
    }
}
