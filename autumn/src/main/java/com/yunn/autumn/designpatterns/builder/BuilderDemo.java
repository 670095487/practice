package com.yunn.autumn.designpatterns.builder;

/**
 * BuilderDemo
 *
 * @Author: yunN
 * @CreateTime: 2020/12/21
 * @Description: 建造者模式demo
 */
@SuppressWarnings("all")
public class BuilderDemo {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    private BuilderDemo(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }

    public static class Builder {
        private int servingSize = 0;
        private int servings = 0;

        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;

        /**
         * 必选
         * @param servingSize
         * @param servings
         */
        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        /**
         * 可选
         * @param val
         * @return
         */
        public Builder calories(int val) {
            calories = val;
            return this;
        }

        public BuilderDemo build() {
            return new BuilderDemo(this);
        }
    }

    public static void main(String[] args) {
        BuilderDemo build = new Builder(1, 2).calories(40).build();
    }
}


