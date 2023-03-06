package com.yunn.autumnnacos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;


/**
 * @author yunN
 * @date 2022/07/18
 */
@ConfigurationProperties(prefix = "test1")
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class YmlProps {

    public Set<String> valsTry = new HashSet<>();

}

