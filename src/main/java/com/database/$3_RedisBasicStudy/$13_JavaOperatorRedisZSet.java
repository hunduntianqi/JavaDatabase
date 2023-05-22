package com.database.$3_RedisBasicStudy;

/*
    java 操作 Redis ZSet 数据
 */

import redis.clients.jedis.Jedis;

import java.util.List;

public class $13_JavaOperatorRedisZSet {
    public static void main(String[] args) {
        // 连接数据库
        Jedis jedis = new Jedis("localhost", 6379);
        // 修改连接数据库
        jedis.select(4);
        // 添加ZSet数据
        jedis.zadd("zset", 1, "郭鹏涛");
        jedis.zadd("zset", 2, "陈欣妮");
        jedis.zadd("zset", 3, "索月雅");
        // 获取指定索引范围的元素, 返回一个List集合
        List<String> zset = jedis.zrange("zset", 0, 2);
        for (String s : zset) {
            System.out.println(s);
        }
        System.out.println("=================================");
        // 获取指定权重范围的元素, 返回一个List集合
        List<String> zset1 = jedis.zrangeByScore("zset", 2, 3);
        for (String s : zset1) {
            System.out.println(s);
        }
        // 获取指定元素的权重值, 返回值为 double 类型
        System.out.println(jedis.zscore("zset", "索月雅"));
        // 删除指定元素
        jedis.zrem("zset", "郭鹏涛");
        // 删除指定权重范围的元素
        jedis.zremrangeByScore("zset", 2, 3);
        // 释放资源
        jedis.close();
    }
}
