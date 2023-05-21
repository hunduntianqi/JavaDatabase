package com.database.$2_MongoDBBasicStudy;

/*
    java操作mongodb:
        添加 mongodb java 驱动 Maven依赖:
            <dependency>
                <groupId>org.mongodb</groupId>
                <artifactId>mongo-java-driver</artifactId>
                <version>3.12.12</version>
            </dependency>
        连接数据库:
            无用户名无密码连接:
                1. 创建MongoClient对象 ==> MongoClient mongoClient = new MongoClient("host" , port);
                2. 连接指定数据库 ==>  MongoDatabase mongoDatabase = mongoClient.getDatabase("databaseName");
            需验证用户名密码连接:
                1. 创建ServerAddress对象, 并加入List集合:
                    ServerAddress serverAddress = new ServerAddress("host" , port);
                    List<ServerAddress> addrs = new ArrayList<>();
                    addrs.add(serverAddress);
                2. 创建MongoCredential对象, 并加入List集合:
                    MongoCredential credential = MongoCredential.createScramSha1Credential(
                                            "userName", "databaseName", "password".toCharArray());
                    List<MongoCredential> credentials = new ArrayList<MongoCredential>();
                    credentials.add(credential);
                3. 创建MongoClient对象 ==> MongoClient mongoClient = new MongoClient(addrs , credentials);
                4. 连接指定数据库 ==>  MongoDatabase mongoDatabase = mongoClient.getDatabase("databaseName");
        创建集合 ==> mongoDatabase.createCollection("collectionName");
        获取集合对象 ==> MongoCollection<Document> collection = mongoDatabase.getCollection("collectionName");
        文档操作:
            1. 增 ==> 插入文档:
                创建文档对象 ==> Document document = new Document("keyName1", value1);
                添加文档字段数据 ==> document.append("keyName", value);
                插入单条文档 ==> collection.insertOne(document)
                插入多条文档:
                    创建List集合 ==> List<Document> documents = new ArrayList<>();
                    添加Document对象 ==> Collections.addAll(documents, document1, document2, ...);
                    插入文档数据 ==> collection.insertMany(documents);
            2. 删 ==> 删除文档:
                删除符合条件的第一个文档 ==> collection.deleteOne(Filters.eq("keyName", value));
                删除所有符合条件的文档 ==> collection.deleteMany(Filters.eq("keyName", value));
            3. 改 ==> 更新文档:
                修改第一个符合条件的文档
                    ==> collection.updateOne(Filters.eq("keyName", value),
                            new Document("$set",new Document("keyName1",value1).append("keyname2", value2)...));
                修改符合条件的所有文档
                    ==> collection.updateOne(Filters.eq("keyName", value),
                            new Document("$set",new Document("keyName1",value1).append("keyname2", value2)...));
            4. 查 ==> 查看文档数据:
                获取 FindIterable<Document> 迭代器对象:
                    FindIterable<Document> findIterable = collection.find();
                获取 MongoCursor<Document> 游标对象:
                    MongoCursor<Document> mongoCursor = findIterable.iterator();
                遍历数据:
                    while(mongoCursor.hasNext()){
                        System.out.println(mongoCursor.next());
                     }
 */

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class $6_JavaOperatorMongoDB {
    // 定义方法, 向数据库中添加数据
    @Test
    public void insertData() {
        // 创建MongoClient对象
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        // 获取数据库对象
        MongoDatabase mongoDatabase = mongoClient.getDatabase("javastudy");
        // 创建集合
        try {
            mongoDatabase.createCollection("MyCollection");
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 获取集合对象
        MongoCollection<Document> collection = mongoDatabase.getCollection("MyCollection");
//        // 创建文档对象, 向集合中插入文档
//        Document document = new Document("name", "郭鹏涛").append("age", 25).append("sex", "男").append("email",
//                "1729992141@qq.com");
//        collection.insertOne(document);
        // 插入多条文档数据
        List<Document> list = new ArrayList<>();
        list.add(new Document("name", "陈欣妮").append("age", 25).append("sex", "女").append("email",
                "1729992141@qq.com"));
        list.add(new Document("name", "康佳怡").append("age", 22).append("sex", "女").append("email",
                "1729992141@qq.com"));
        list.add(new Document("name", "郭鹏强").append("age", 22).append("sex", "男").append("email",
                "1729992141@qq.com"));
        collection.insertMany(list);
        // 关闭连接, 释放资源
        mongoClient.close();
    }

    // 定义方法, 删除集合数据
    @Test
    public void deleteData() {
        // 创建MongoClient对象
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        // 获取数据库对象
        MongoDatabase mongoDatabase = mongoClient.getDatabase("javastudy");
        // 创建集合
        try {
            mongoDatabase.createCollection("MyCollection");
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 获取集合对象
        MongoCollection<Document> collection = mongoDatabase.getCollection("MyCollection");
        // 删除一条指定数据
        // collection.deleteOne(Filters.eq("name", "康佳怡"));
        // 删除多条数据
        collection.deleteMany(Filters.eq("name", "陈欣妮"));
        // 释放资源
        mongoClient.close();
    }

    // 定义方法, 修改集合数据
    @Test
    public void updateData() {
        // 创建MongoClient对象
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        // 获取数据库对象
        MongoDatabase mongoDatabase = mongoClient.getDatabase("javastudy");
        // 创建集合
        try {
            mongoDatabase.createCollection("MyCollection");
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 获取集合对象
        MongoCollection<Document> collection = mongoDatabase.getCollection("MyCollection");
        // 修改第一个符合条件的集合数据
        // collection.updateOne(Filters.eq("name", "康佳怡"), new Document("$set", new Document("age", 23)));
        // 修改所有符合条件的集合数据
        collection.updateMany(Filters.eq("name", "康佳怡"), new Document("$set", new Document("age", 21)));
        // 释放资源
        mongoClient.close();
    }

    // 定义方法, 查看集合数据
    @Test
    public void findData() {
        // 创建 MongoClient 对象
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        // 获取 MongoDatabase 对象
        MongoDatabase mongoDatabase = mongoClient.getDatabase("javastudy");
        // 获取集合对象
        MongoCollection<Document> collection = mongoDatabase.getCollection("MyCollection");
        // 获取 FindIterable<Document> 迭代器对象
        FindIterable<Document> findIterable = collection.find().sort(new BasicDBObject("_id", 1));
        // 获取 MongoCursor<Document> 游标对象
        MongoCursor<Document> cursor = findIterable.iterator();
        // 循环遍历数据
        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }
        // 释放资源
        mongoClient.close();
    }
}
