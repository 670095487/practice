package com.yunn.autumnnacos.controller;

import com.yunn.autumnnacos.mapper.MerchantMapper;
import com.yunn.autumnnacos.model.MerchantDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/merchant")
public class MerchantController {

    @Autowired
    MerchantMapper merchantMapper;

    @GetMapping
    public List<MerchantDo> getMerchants() {
        return merchantMapper.getMerchantDos();
    }

}

