package com.yunn.autumn.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

/**
 * RedisConfig
 *
 * @author: yunN
 * @createTime: 2020年10月21日 09:02
 * @description:
 */
@ConfigurationProperties(prefix = "redis")//读取配置文件中以redis开头的所有属性
@Configuration
public class RedisConfig {


}
