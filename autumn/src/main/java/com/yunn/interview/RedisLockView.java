package com.yunn.interview;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;

import java.util.Collections;
import java.util.UUID;

/**
 * RedisLockView
 *
 * @author yunN
 * @createTime 2021年02月22日 19:21
 * @description
 */
@Slf4j
@SuppressWarnings("all")
public class RedisLockView {

    private static final String LOCK_SUCCESS = "OK";
    private static final Long RELEASE_SUCCESS = 1L;
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "PX";
    // 锁的超时时间
    private static final int EXPIRE_TIME = 5 * 1000;
    // 锁等待时间
    private static final int WAIT_TIME = 1000;

    private final Jedis jedis;
    private final String key;

    public RedisLockView(Jedis jedis, String key) {
        this.jedis = jedis;
        this.key = key;
    }

    // 不断尝试加锁
    public String lock() {
        try {
            // 超过等待时间，加锁失败
            long waitEnd = System.currentTimeMillis() + WAIT_TIME;
            String value = UUID.randomUUID().toString();
            while (System.currentTimeMillis() < waitEnd) {
                //NX:not exists, 只有key 不存在时才把key value set 到redis
                //PX:milliseconds 毫秒 nxxx expx  ex：秒
                String result = jedis.set(key, value, "NX", "PX", EXPIRE_TIME);
                if (LOCK_SUCCESS.equals(result)) {
                    return value;
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        } catch (Exception ex) {
            log.error("lock error", ex);
        }
        return null;
    }

    public boolean release(String value) {
        if (value == null) {
            return false;
        }
        // 使用lua脚本判断key存在并且删除key必须是一个原子操作
        // 且谁拥有锁，谁释放
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] " +
                "then return redis.call('del', KEYS[1]) else return 0 end";
        Object result = new Object();
        try {
            //使用eval()执行lua脚本
            result = jedis.eval(script, Collections.singletonList(key),
                    Collections.singletonList(value));
            if (RELEASE_SUCCESS.equals(result)) {
                log.info("release lock success, value:{}", value);
                return true;
            }
        } catch (Exception e) {
            log.error("release lock error", e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        log.info("release lock failed, value:{}, result:{}", value, result);
        return false;
    }

    public static void main(String[] args) {
        //lua脚本
        String script =
                "if redis.call('get', KEYS[1]) == ARGV[1] " +
                        "then return redis.call('del', KEYS[1]) else return 0 end";
        Jedis jedis = new Jedis();
        jedis.setnx("key", "value");
    }

}
