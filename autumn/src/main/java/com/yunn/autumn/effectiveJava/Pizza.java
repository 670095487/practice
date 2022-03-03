package com.yunn.autumn.effectiveJava;

import java.util.Set;

/**
 * Pizza
 *
 * @Author: yunN
 * @CreateTime: 2020/12/21
 * @Description:
 */
public abstract class Pizza {
    protected Pizza(Set<Topping> toppings) {
        this.toppings = toppings;
    }

    public enum Topping {HAM, MUSHROOM, ONION, PEPPER, SAUSAGE}

    final Set<Topping> toppings;
}
