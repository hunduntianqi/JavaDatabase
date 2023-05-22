package com.database.$3_RedisBasicStudy;

/*
    Java连接redis:
        添加 jedis Maven 依赖:
            <dependency>
                <groupId>redis.clients</groupId>
                <artifactId>jedis</artifactId>
                <version>4.4.1</version>
            </dependency>
        连接Redis数据库:
            无密码连接: Jedis jedis = new Jedis("host", port);
            带密码连接:
                Jedis jedis = new Jedis("host", port);
                jedis.auth("password");
            常用API:
                jedis.select(databaseNum) ==> 更改连接的数据库序号
                jedis.getClient() ==> 获取客户端信息
                jedis.flushAll() ==> 清空Redis数据库
                jedis.info() ==> 查看Redis信息
                jedis.dbSize() ==> 获取数据库中 key 的数量
                jedis.getDB() ==> 获取数据库名字
                jedis.time() ==> 返回当前 Redis 服务器的时间
                jedis.keys("regex") ==> 根据正则表达式匹配获取符合条件的键名集合, 返回一个Set集合
                jedis.type("keyName") ==> 查看对应键的值的数据类型
                jedis.exists("keyName") ==> 判断对应键名是否存在
                jedis.expire("keyName", time) ==> 设置对应键的过期时间, 单位是秒
                jedis.ttl("KeyName") ==> 查看对应键的过期时间
                jedis.del("keyName1", "keyName2", ...) ==> 删除键值对
        操作String数据:
            根据键名获取单个值 ==> jedis.get("keyName")
            根据键名获取多个值 ==> jedis.mget("keyName1", "keyName2", ...) ==> 返回值为List集合
            新增一组键值对 ==> jedis.set("keyName", "value") ==> 如果键名已存在, 会修改对应键的值
            新增多组键值对 ==> jedis.set("keyName1", "value1", "keyName2", "value2", ...) ==> 如果键名已存在, 会修改对应键的值
            追加对应键的值 ==> jedis.append("keyName", "appendValue")
            删除键值对 ==> jedis.del("keyName1", "keyName2", ...)
        操作Hash数据:
            根据指定键获取所有属性名 ==> jedis.hkeys("keyName")
            获取指定键单个属性值 ==> jedis.hget("keyName", "fieldName")
            获取指定键多个属性值, 返回值为List集合 ==> jedis.hmget("keyName", "fieldName1", "fieldName2", ...)
            获取指定键的所有属性值, 返回值为List集合 ==> jedis.hvals("keyName")
            创建Hash对象并添加单个属性值 ==> jedis.hset("keyName", "fieldName", "fieldValue")
            给指定Hash对象添加多个属性值 ==>
                创建HashMap集合 ==> HashMap<String, String> hashMap = new HashMap<>()
                集合添加数据 ==> hashMap.put("fieldName1", "fieldValue1")
                集合添加数据 ==> hashMap.put("fieldName2", "fieldValue2")
                ......
                给Hash对象添加属性值 ==> jedis.hmset("keyName", hashMap)
            删除指定键值对 ==> jedis.del("keyName1", "keyName2", ...)
            删除指定Hash对象的指定属性 ==> jedis.hdel("keyName", "fieldName1", "fieldName2", ...)
        操作List:
            从列表左侧插入数据 ==> jedis.lpush("keyName", "value1", "value2", "value3") ==> value3, value2, value1
            从列表右侧插入数据 ==> jedis.rpush("keyName", "value1", "value2", "value3") ==> value1, value2, value3
            在指定数据前插入数据 ==> jedis.linsert("keyName", ListPosition.BEFORE, "oldValue", "newValue")
            在指定数据后插入数据 ==> jedis.linsert("keyName", ListPosition.AFTER, "oldValue", "newValue")
            获取列表中元素的个数 ==> jedis.llen("keyName")
            获取列表中指定范围的元素, 返回一个List集合 ==> jedis.lrange("keyName", startIndex, endIndex)
            修改指定索引位置的元素 ==> jedis.lset("keyName", index, "value")
            删除指定元素 ==> jedis.lrem("keyName", count, "value"):
                count = 0 ==> 删除所有指定元素
                count > 0 ==> 从左到右删除指定个数的元素
                count < 0 ==> 从右到左删除指定个数的元素
        操作无序集合Set:
            集合添加数据 ==> jedis.sadd("keyName", "value1", "value2", ...)
            获取集合所有数据, 返回一个 Set 集合 ==> jedis.smembers("keyName")
            删除集合指定数据 ==> jedis.srem("keyName", "value1", "value2", ...)
        操作有序集合ZSet:
            集合添加数据 ==> jedis.zadd("keyName", score, "value");
            获取指定索引范围的元素, 返回一个List集合 ==> jedis.zrange("keyName", startIndex, endIndex)
            获取指定权重范围的元素, 返回一个List集合 ==> jedis.zrangeByScore("keyName", minScore, maxScore)
            获取指定元素的权重值, 返回值为 double 类型 ==> jedis.zscore("keyName", "value")
            删除指定元素 ==> jedis.zrem("keyName", "value")
            删除指定权重范围的元素 ==> jedis.zremrangeByScore("keyName", minScore, maxScore)
 */

import redis.clients.jedis.Jedis;

public class $8_JavaOperatorRedis {
    public static void main(String args[]) {
        // 连接 Redis 数据库
        Jedis jedis = new Jedis("localhost", 6379);
        jedis.select(1);
        // 获取客户端信息
        System.out.println("Redis客户端信息:");
        System.out.println(jedis.getClient());
        // 查看Redis信息
        System.out.println("Redis信息:");
        System.out.println(jedis.info());
        // 查看当前数据库中 key 的数量
        System.out.print("当前数据库中 keyNum = ");
        System.out.println(jedis.dbSize());
        // 获取当前数据库的名字
        System.out.print("当前数据库的名字为: ");
        System.out.println(jedis.getDB());
        // 查看当前Redis数据库服务器的时间
        System.out.print("当前Redis数据库的服务器时间为: ");
        System.out.println(jedis.time());
        // 释放资源
        jedis.close();
    }
}
