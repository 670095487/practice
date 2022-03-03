package com.yunn.autumn.practice;

import com.yunn.autumn.designpatterns.strategy.Dog;
import com.yunn.autumn.practice.model.Animal;
import org.springframework.beans.BeanUtils;

/**
 * @author yunN
 * @date 2021/11/28
 */
public class BeanUtilsStudy {

    public static void main(String[] args) {
        Animal animal = Animal.builder()
                .name("name")
                .age("18")
                .build();

        BeanUtils.copyProperties(animal, Dog.class);
    }
}
