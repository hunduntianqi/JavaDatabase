package com.database.$3_RedisBasicStudy;

/*
    java操作 Redis Set
 */

import redis.clients.jedis.Jedis;

import java.util.Set;

public class $12_JavaOperatorRedisSet {
    public static void main(String[] args) {
        // 连接数据库
        Jedis jedis = new Jedis("localhost", 6379);
        // 修改连接的数据库
        jedis.select(3);
        // 添加集合元素
        // jedis.sadd("set", "郭鹏涛", "张佳琪", "付乔央", "秦明欣", "陈欣妮", "张雪", "张莉莉", "徐冬梅", "李灵", "刘思思",
        //         "陶静", "索月雅", "康佳怡");
        // 获取集合所有元素
        Set<String> set = jedis.smembers("set");
        for (String s : set) {
            System.out.println(s);
        }
        // 删除集合元素
        jedis.srem("set", "康佳怡");
        // 释放资源
        jedis.close();
    }
}
