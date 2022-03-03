package com.yunn.springsecurity.controller;

import com.yunn.springsecurity.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("role")
public class RoleController {

    @Autowired
    SecurityService securityService;

    @GetMapping
    public String getRoles() {
        return securityService.getInitValueFromMap();
    }
}
