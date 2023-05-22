package com.database.$3_RedisBasicStudy;

/*
    java操作 Redis 数据库 List 数据
 */

import redis.clients.jedis.Jedis;
import redis.clients.jedis.args.ListPosition;

import java.util.List;

public class $11_JavaOperatorRedisList {
    public static void main(String[] args) {
        // 连接数据库
        Jedis jedis = new Jedis("localhost", 6379);
        // 修改数据库
        jedis.select(2);
        // 创建一个列表并从左侧插入数据
        jedis.lpush("list", "1", "2", "3");
        // 从列表右侧插入数据
        jedis.rpush("list", "4", "5", "6");
        // 在指定元素前插入元素
        jedis.linsert("list", ListPosition.BEFORE, "1", "7");
        // 在指定元素后插入元素
        jedis.linsert("list", ListPosition.AFTER, "7", "8");
        // 获取列表中指定范围的元素
        System.out.println(jedis.llen("list"));
        List<String> list = jedis.lrange("list", 0, jedis.llen("list") - 1);
        for (String s : list) {
            System.out.println(s);
        }
        // 修改指定索引位置的元素值
        jedis.lset("list", jedis.llen("list") - 1, "10");
        // 删除指定元素
        jedis.lrem("list", 0, "2");
        jedis.lrem("list", 0, "3");
        // 释放资源
        jedis.close();
    }
}
