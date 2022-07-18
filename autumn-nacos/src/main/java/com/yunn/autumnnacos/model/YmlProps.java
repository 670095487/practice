package com.yunn.autumnnacos.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


/**
 * @author yunN
 * @date 2022/07/18
 */
@ConfigurationProperties(prefix = "test1")
@Component
@Data
public class YmlProps {

    private List<String> vals = new ArrayList<>();

}

