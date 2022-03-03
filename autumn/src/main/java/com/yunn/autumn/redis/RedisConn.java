package com.yunn.autumn.redis;

import redis.clients.jedis.Jedis;

/**
 * RedisConn
 *
 * @Author: yunN
 * @CreateTime: 2020/12/18
 * @Description:
 */
public class RedisConn {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("81.69.227.238", 2672);
        System.out.println(jedis.ping());
        // System.out.println(jedis.ping("xxx"));
    }
}
