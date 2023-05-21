package com.database.$3_RedisBasicStudy;

/*
    java操作 Redis 数据库 String 数据
 */

import redis.clients.jedis.Jedis;

import java.util.Set;

public class $9_JavaOperatorRedisString {
    public static void main(String[] args) {
        // 连接数据库
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        // 获取当前连接数据库序号
        System.out.println(jedis.getDB());
        // 获取数据库中所有键名
        Set<String> set = jedis.keys("*");
        for (String s : set) {
            // 设置键的过期时间
            jedis.expire(s, 10);
            // 查看键的过期时间
            System.out.println(jedis.ttl(s));
        }
        // 根据键名获取单个值
        String name = jedis.get("Name");
        System.out.println(name);
        // 根据键名获取多个值
        System.out.println(jedis.mget("Name", "Age", "Sex").getClass());
        // 新增一组键值对, 如果键已存在, 会修改对应键的值
        jedis.set("Name", "郭鹏涛");
        // 新增多组键值对, 如果键已存在, 会修改对应键的值
        jedis.mset("age", "25", "name", "郭鹏涛", "sex", "男");
        // 追加对应键的值
        jedis.append("name", "love");
        // 根据键名删除键值对
        jedis.del("age", "name", "sex");
        // 释放资源
        jedis.close();
    }
}
