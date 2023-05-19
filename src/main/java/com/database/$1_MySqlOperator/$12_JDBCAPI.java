package com.database.$1_MySqlOperator;

/*
    JDBC(( Java DataBase Connectivity ):
        就是使用Java语言操作关系型数据库的一套API
        MySQL驱动Maven依赖导入:
            <dependency>
                <groupId>mysql</groupId>
                <artifactId>mysql-connector-java</artifactId>
                <version>8.0.33</version>
            </dependency>
        DriverManager ==> 驱动管理类
            作用:
                1. 注册驱动 ==> Class.forName("com.mysql.cj.jdbc.Driver");
                    提示: MySQL 5之后的驱动包, 可以省略注册驱动的步骤
                2. 获取数据库连接:
                    Connection connection = DriverManager.getConnection(url, userName, passWord);
                        url ==> 格式为: jdbc:mysql://ip地址(域名):端口号/数据库名称?参数键值对1&参数键值对2…
                            例: jdbc:mysql://localhost:3306/db1
                        userName ==> 用户名
                        passWord ==> 登录密码
        Connection ==> 数据库连接对象
            作用:
                1. 获取执行Sql的对象
                    普通执行Sql对象 ==> Statement statement = connection.createStatement();
                    预编译Sql的执行对象, 防止Sql注入 ==> PreparedStatement statement = connection.prepareStatement(sql);
                    执行存储过程的对象 ==> CallableStatement statement = connection.prepareCall(sql);
                2. 事务管理
                    JDBC 事务管理：Connection接口中定义了3个对应的方法:
                        开启事务 ==> setAutoCommit(boolean autoCommit):
                            autoCommit == true:自动提交事务
                            autoCommit == false:手动提交事务, 即为开启事务
                        提交事务 ==> commit()
                        回滚事务 ==> rollback()
        Statement ==> 执行Sql语句
            执行DML, DDL语句 ==> executeUpdate(sql):
                返回值:
                    1. DML语句返回影响的行数
                    2. DDL语句执行成功后, 也可能会返回0
            执行DQL语句 ==> executeQuery(sql):
                返回值: ResultSet结果集对象
        PreparedStatement ==> 执行预编译Sql语句, 防止Sql注入问题
            使用步骤:
                1. 定义Sql语句, 关键参数使用 ? 作占位符
                    String sql = "select * from user where username = ? and password = ?";
                2. 获取PreparedStatement对象
                    PreparedStatement statement = connection.prepareStatement(sql);
                3. 设置参数值, 给占位符对应参数赋值
                    statement.setXxx(参数1, 参数2):
                        Xxx ==> 指数据类型, 例setInt()
                        参数1 ==> 占位符 ? 的位置编号, 从 1 开始
                        参数2 ==> 占位符 ? 要赋的值
                4. 执行Sql语句, 不需要再传递Sql语句 ==> executeUpdate(); / executeQuery();
        ResultSet ==> 结果集对象:
            作用: 封装了 DQL 查询语句返回的结果
            获取结果集对象
                ResultSet resultSet = statement.executeQuery(sql);
            获取查询结果:
                resultSet.next() ==> 返回一个 boolean 对象, 判断当前行是否为有效行, 并将光标向前移动一行
                    boolean = true ==> 有效行, 当前行有数据
                    boolean = false ==> 无效行, 当前行没有数据
                    可以结合 while 循环遍历获取数据
                resultSet.getXxx(参数) ==> 获取数据
                    参数 ==> 可以为字段编号(从1开始, int类型), 也可以为字段名(String类型)
                    getInt ==> 获取数据为 Integer 类型
                    getString ==> 获取数据为 String 类型
                    getDouble ==> 获取数据为 Double 类型
                    getFloat ==> 获取数据为 Float 类型
                    ...


 */


import org.junit.jupiter.api.Test;

import java.sql.*;

public class $12_JDBCAPI {
    // 定义方法, 执行Sql语句插入数据
    @Test
    public void insertData() throws Exception {
        // 创建数据库连接对象
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javastudy",
                "root", "2251789949gpt");
        // 获取Statement对象
        Statement statement = connection.createStatement();
        // 定义SQL语句
        //String sql1 = "insert into person(userId, userName, Sex, Email) values (1, '郭鹏涛', '男', '1729992141@qq.com')";
        // String sql2 = "insert into person(userId, userName, Sex, Email) values (2, '陈欣妮', '女', '1729992141@qq.com')";
        String sql3 = "insert into person(userId, userName, Sex, Email) values (3, '郭鹏强', '男', '1729992141@qq.com')";
        // 执行SQL语句
        // statement.executeUpdate(sql1);
        // statement.executeUpdate(sql2);
        statement.executeUpdate(sql3);
        // 释放资源
        statement.close();
        connection.close();
    }

    // 定义方法, 执行SQL语句删除数据
    @Test
    public void deleteData() throws Exception {
        // 创建数据库连接对象
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javastudy",
                "root", "2251789949gpt");
        // 获取Statement对象
        Statement statement = connection.createStatement();
        // 定义SQL语句
        String sql = "delete from person where userId = 3";
        // 执行SQL语句
        statement.executeUpdate(sql);
        // 释放资源
        statement.close();
        connection.close();
    }

    // 定义方法, 执行SQL语句修改数据
    @Test
    public void updateData() throws Exception {
        // 创建数据库连接对象
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javastudy",
                "root", "2251789949gpt");
        // 获取Statement对象
        Statement statement = connection.createStatement();
        // 定义SQL语句
        String sql = "update person set userId=1, userName='郭鹏涛' where userId=3";
        // 执行SQL语句
        statement.executeUpdate(sql);
        // 释放资源
        statement.close();
        connection.close();
    }

    // 定义方法, 执行SQL语句查询数据
    @Test
    public void queryData() throws Exception{
        // 创建数据库连接对象
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javastudy",
                "root", "2251789949gpt");
        // 获取Statement对象
        Statement statement = connection.createStatement();
        // 定义SQL语句
        String sql = "select * from person";
        // 执行SQL语句
        ResultSet resultSet = statement.executeQuery(sql);
        // while循环获取数据
        while (resultSet.next()) {
            System.out.printf("userId=%d, userName=%s, Sex=%s, Email=%s\n", resultSet.getInt("userId"),
                    resultSet.getString(2), resultSet.getString(3), resultSet.getString("Email"));
        }
        // 释放资源
        statement.close();
        connection.close();
    }

    // 定义方法, 使用预编译对象执行SQL语句
    @Test
    public void preparedStatement() throws Exception{
        // 创建数据库连接对象
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javastudy",
                "root", "2251789949gpt");
        // 定义SQL语句
        String sql = "select * from person where userId<=?";
        // 获取预编译SQL执行对象
        PreparedStatement statement = connection.prepareStatement(sql);
        // 为占位符参数赋值
        statement.setInt(1, 2);
        // 执行SQL语句
        ResultSet resultSet = statement.executeQuery();
        // 遍历打印执行结果
        while (resultSet.next()) {
            System.out.printf("userId=%d, userName=%s, Sex=%s, Email=%s\n", resultSet.getInt("userId"),
                    resultSet.getString(2), resultSet.getString(3), resultSet.getString("Email"));
        }
        // 释放资源
        statement.close();
        connection.close();
    }
}
