package com.database.$3_RedisBasicStudy;

/*
    java操作 Redis 数据库 Hash 数据
 */

import redis.clients.jedis.Jedis;

import java.util.HashMap;

public class $10_JavaOperatorRedisHash {
    public static void main(String[] args) {
        // 连接数据库
        Jedis jedis = new Jedis("localhost", 6379);
        // 切换数据库
        jedis.select(1);
        // 添加单个hash对象属性数据
        jedis.hset("user", "name", "郭鹏涛");
        // 添加多个hash对象属性数据
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("age", "25");
        hashMap.put("sex", "男");
        jedis.hmset("user", hashMap);
        // 获取指定键的所有属性名
        System.out.println(jedis.hkeys("user"));
        // 获取指定键单个指定属性值
        System.out.println(jedis.hget("user", "name"));
        // 获取指定键多个属性值, 返回值为List集合
        System.out.println(jedis.hmget("user", "age", "sex"));
        // 获取指定键所有属性的值, 返回值为List集合
        System.out.println(jedis.hvals("user"));
        // 删除指定键
        jedis.del("name");
        // 删除指定键的某些属性
        jedis.hdel("user", "sex", "age");
        // 释放资源
        jedis.close();
    }
}
