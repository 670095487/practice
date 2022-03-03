package com.yunn.interview;

import redis.clients.jedis.Jedis;

/**
 * RedisLock
 *
 * @author yunN
 * @createTime 2021年02月14日 11:50
 * @description
 */
public class RedisLock {

    private final Jedis jedis = new Jedis();

    public static void main(String[] args) {
        tryLock("s", "er");
    }

    public static boolean tryLock(String key, String request) {
        // String result = this.jedis.set(LOCK_PREFIX + key, request, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, 10 * TIME);
        String result = "";
        return false;
    }
}
