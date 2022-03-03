package com.yunn.autumn.thread.threadenhance3.juc.phaser;

import java.util.Random;
import java.util.concurrent.Phaser;

/**
 * PhaserEx1
 *
 * @author yunN
 * @createTime 2021年02月03日 14:47
 * @description 动态注册增加 动态减少注册
 */
public class PhaserEx1 {

    private final Random RANDOM = new Random(System.currentTimeMillis());

    public static void main(String[] args) {

        final Phaser phaser = new Phaser(2){
            @Override
            protected boolean onAdvance(int phase, int registeredParties) {
                return true;
            }
        };
    }

    static class Task extends Thread{

        public Task(Phaser phaser) {
        }

        @Override
        public void run() {
        }
    }
}
