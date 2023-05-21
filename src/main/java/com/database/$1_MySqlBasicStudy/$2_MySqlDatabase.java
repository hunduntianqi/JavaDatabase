package com.database.$1_MySqlBasicStudy;

/*
    MySql数据库:
        修改默认账户密码:
            mysqladmin -u 要修改的用户名 password 密码
        登录数据库:
            mysql -u用户名 -p密码
        退出数据库:
            1. exit
            2. quit
        登陆参数:
            mysql -u用户名 -p密码 -h要连接的mysql服务器的ip地址(默认127.0.0.1) -P端口号(默认3306)
        卸载MySql:
            1. cmd命令行: net stop mysql // 停止MySql服务
            2. cmd命令行: mysqld -remove mysql
            3. 删除MySql目录及相关的环境变量
        显示数据库版本:
            select version();
        显示时间:
            select now();
        查询数据库用户名:
            select * from mysql.user;
        数据类型:
            指在创建表时为表中字段指定的数据类型,只有数据类型符合要求才能存储起来
            常用数据类型：
                1.整数：int,bit
                2.小数:decimal, double
                3.字符串:varchar,char
                4.日期时间:date,time,datetime
                5.枚举类型（enum）
            数据类型说明：
                1.decimal表示浮点数,如decimal(5,2),表示共存5位数,小数占2位
                2.char表示固定长度的字符串,如char(3),如果填充'ab'时会补一个空格为'ab ',3表示字符数
                3.varchar表示可变长度的字符串,如varchar(3),填充'ab'时就会存储'ab',3表示字符数
                4.对于图片、音频、视频等文件,不存储与数据库中,而是上传到某个服务器上,然后再表中存储这个文件的保存路径
                5.字符串text表示存储大文本,当字符大于4000时推荐使用
        数据约束:
            指数据在数据类型限定基础上额外增加的要求
            常见数据约束：
                1.主键-primary key：物理上存储的顺序,MySQL建议所有表的主键字段都叫id,类型为int unsigned
                2.非空-not null:此字段不允许填写空值
                3.唯一-unique:此字段值不允许重复
                4.默认-default:当不填写字段对应的值会使用默认值,如果填写则以填写的值为准
                5.外键-foreign key:对关系字段进行约束,当为关系字段填写值时,会到关联的表中查询此值是否存在,如果存在则填写成功,不存在
                则填写失败并抛出异常！！！
                6.自动增长(数字)-auto_increment
        MySql数据库常用命令:
            1. 连接(登录): mysql -uroot -p+密码
            2. 不显示密码: mysql -uroot -p+回车
                          输入密码
            3. 退出数据库: quit/ctrl+d/exit
            4. 使用数据库: use 数据库名;
            5. 显示数据库版本: select version();
            6. 显示时间: select now();
            7. 查看当前使用的数据库: select database();
            8. 查看所有数据库: show databases;
            9. 创建数据库: create database 数据库名 charset=utf8;(此项为字符集设置, 如果不设置, 插入中文会报错)
            10. 查看创建数据库的语句(查看字符集): show create database 数据库名;
            11. 删除数据库: drop database 数据库名;
            12. 查询数据库用户名:select * from mysql.user;
            13. 远程连接数据库: mysql -h机名 -u用户名 -p密码 库名
            注意：sql语句最后需要有;结尾
        SQL语句中的快捷键:
            \G: 格式化输出
            \s: 查看服务器端信息
            \c: 结束命令输入操作
            \q: 退出当前SQL命令行模式
            \h: 查看帮助
    MySQL远程连接设置:
        1. 登录MySql:
            命令行窗口中 ==> mysql -u用户名 -p密码
        2. 进入mysql库:
            use mysql; ==> 切换数据库到mysql
        3. 执行更新权限语句:
            update user set Host='%' where User='root'; ==> '%'指的是所有地址
        4. 查看权限: select host, user from user; 查看权限
        5. 使用数据库连接工具测试连接
        个人电脑 ipv6 地址 ==> fe80::6504:9c14:bfcd:c535
        个人电脑宿舍WiFi ipv4 地址 ==> 192.168.16.101
        个人电脑 ==> GPT-HunDunTianQi
        idea ipv6 连接 mysql ==> 主机 = ipv6地址
    无管理员权限安装MySQL服务:
        1. 配置环境:
            mysql bin文件夹目录下, 创建.ini文件, 内容如下:
                [client]
                port=3306
                [mysqld]
                character-set-server=utf8
                [mysql]
                default-character-set=utf8
        2. 初始化:
            bin文件夹目录下, cmd命令行窗口输入命令: mysqld --initialize
            或 {MySql}\\bin\\mysqld --initialize
        3. 运行服务:
            bin文件夹目录下, cmd命令行窗口输入命令: mysqld --console
            或 {MySql}\\bin\\mysqld --console
        4. 查看密码:
            在MySQL data文件夹下以.err结尾的文件中[Note]一行的结尾
        5. 登录MySQL服务 ==> mysql -u用户名 -p密码
        6. 修改密码 ==> set password for 用户名@localhost = password('新密码');
 */

public class $2_MySqlDatabase {
}
