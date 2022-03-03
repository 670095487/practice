package com.yunn.springsecurity.service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.HashMap;
import java.util.Map;

@Service
public class SecurityService {

    private static final Map<String, String> MAP = new HashMap<>();

    @PostConstruct
    public void init() {
        MAP.put("init", "@PostConstruct");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("before destroy...");
    }

    public String getInitValueFromMap() {
        return MAP.get("init");
    }
}
