package com.yunn.autumn.redis;

import redis.clients.jedis.Jedis;

/**
 * RedisApplication
 *
 * @author yunnuan
 * @createTime 2020年12月06日 21:47
 * @description
 */
public class RedisApplication {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("81.69.227.238", 2672);
        System.out.println(jedis.ping());

    }
}
