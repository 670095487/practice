package com.yunn.autumn.someproduction.handler;

import com.alibaba.druid.util.StringUtils;
import lombok.experimental.UtilityClass;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yunN on 2021/06/26.
 */
@UtilityClass
public class RealHandlerFactory {

    private final static Map<String, RealHandler> HANDLER_MAP = new HashMap<>(16);

    public static RealHandler getRealHandler(String target) {
        return HANDLER_MAP.get(target);
    }

    public static void registryHandler(String target, RealHandler realHandler) {
        if (!StringUtils.isEmpty(target) && realHandler != null) {
            HANDLER_MAP.put(target, realHandler);
        }
    }
}
