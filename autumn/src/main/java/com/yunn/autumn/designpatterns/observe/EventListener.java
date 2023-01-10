package com.yunn.autumn.designpatterns.observe;

import java.io.File;

/**
 * @date 2022/12/21
 */
public interface EventListener {

    void update(String eventType, File file);
}
