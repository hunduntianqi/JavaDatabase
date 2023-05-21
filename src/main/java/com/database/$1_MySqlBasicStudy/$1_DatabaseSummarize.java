package com.database.$1_MySqlBasicStudy;

/*
    数据库:
        本质就是文件-存储和管理数据的仓库, 数据按照一定的格式存储, 用户可以对数据库中的数据进行
        增加,修改,删除,查询等操作
    数据库的分类:
        1.关系型数据库
            数据表和数据表之间有一定关联的数据库
            指采用了关系模型来组织数据的数据库,关系模型指的是二维表格模型,好比Excel中的表格,
            优点:
                1. 使用表结构, 格式一致, 易于维护
                2. 使用通用的SQL语言操作, 使用方便, 可用于复杂查询
                3. 数据存储在磁盘中, 安全
            关系型数据库核心要素: 数据行,数据列,数据表
            常用关系型数据库: Oracle, Microsoft SQL Server, MySQL, SQLite
        2. 非关系型数据库:
            数据表和数据表之间没有关联的数据库
            又被称为NoSQL,强调Key-Value的方式存储数据
            常用非关系型数据库：MongoDB, Redis
    数据库的作用: 存储和管理数据
        特点:
            1. 数据持久化存储
            2. 数据读写速度快
            3. 保证数据的有效性

    关系型数据库管理系统 ==> RDBMS:
        关系型数据库客户端软件: 负责和关系型数据库服务端软件进行通信, 向服务端传输数据或从服务端获取数据
        1. 用户操作关系型数据库客户端, 实现数据库相关操作
        2. 关系型数据库客户端借助网络使用SQL语言和关系型数据库服务端进行数据通信
        3. 关系型数据库服务端管理着不同的数据库, 每个数据库会有一系列的数据文件, 数据保存在数据文件中,
           每个数据库可以理解成一个文件夹
        常见的关系型数据库管理系统:
            4.1 Oracle: 收费的大型数据库, Oracle公司的产品
            4.2 MySql: 开源免费的中小型数据库
            4.3 SQL Server: MicroSoft收费的中型数据库, C#, .net等语言经常使用
            4.4 PostgreSql: 开源免费中小型的数据库
            4.5 DB2: IBM公司的大型收费数据库产品
            4.6 SQLite: 嵌入式的微型数据库, 如: 作为Android内置数据库
            4.7 MariaDB: 开源免费中小型数据库

    SQL-结构化查询语言:
        用来操作RDBMS的语言, 通过SQL可以操作Oracle, Microsoft SQL Server, MySQL, SQLite等关系型数据库
        实现数据库客户端和服务端之间的通信, 是通信的桥梁
        SQL语言分类:
            1.DQL：数据查询语言-用于对数据进行查询, 如select
            2.DML：数据操作语言-对数据进行增加、修改、删除, 如insert, update, delete
            3.TPL: 事务处理语言-对事物进行处理, 包括begin transaction, commit, rollback
            4.DCL：数据控制语言-进行授权与权限回收, 如grant, revoke
            5.DDL：数据定义语言-进行数据库, 表的管理等, 如create, drop
        说明：
            1. 对于程序员来讲, 重点是数据的增、删、改、查, 必须熟练编写DQL, DML, 能够编写DDL完成数据库、表的操作,
               其他操作了解即可
            2. SQL语言不区分大小写
    数据库数据类型和数据约束:
        数据类型:
            指在创建表时为表中字段指定的数据类型, 只有数据类型符合要求才能存储起来
            常用数据类型:
                1.整数：int,bit
                2.小数:decimal
                3.字符串:varchar,char
                4.日期时间:date,time,datetime
                5.枚举类型（enum
            数据类型说明:
                1.decimal表示浮点数, 如decimal(5,2),表 示共存5位数, 小数占2位
                2.char表示固定长度的字符串, 如char(3), 如果填充'ab'时会补一个空格为'ab ', 3表示字符数
                3.varchar表示可变长度的字符串, 如varchar(3), 填充'ab'时就会存储'ab', 3表示字符数
                4.对于图片、音频、视频等文件, 不存储与数据库中, 而是上传到某个服务器上,然后在表中存储这个文件的保存路径
                5.字符串text表示存储大文本, 当字符大于4000时推荐使用
        数据约束:
            指数据在数据类型限定基础上额外增加的要求
            常见数据约束:
                1. 主键-primary key: 物理上存储的顺序, MySQL建议所有表的主键字段都叫id, 类型为int unsigned
                2. 非空-not null: 此字段不允许填写空值
                3. 唯一-unique: 此字段值不允许重复
                4. 默认-default: 当不填写字段对应的值会使用默认值, 如果填写则以填写的值为准
                5. 外键-foreign key:对关系字段进行约束, 当为关系字段填写值时, 会到关联的表中查询此值是否存在,
                   如果存在则填写成功, 不存在则填写失败并抛出异常！！！
                6. 自动增长(数字)-auto_increment
 */

public class $1_DatabaseSummarize {
}
