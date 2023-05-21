package com.database.$1_MySqlBasicStudy;

/*
    事务:
        数据库的事务, 是一种机制, 一种操作序列, 包含了一组数据库操作命令
        事务把所有的命令作为一个整体, 一起向系统提交或撤销操作请求, 即这一组数据库命令要么同时成功, 要么同时失败
        事务是一个不可分割的工作逻辑单元
        开启事务:
            start transaction 或 begin;
        提交事务:
            commit;
        回滚事务:
            rollback;
    事务四大特征:
        A-原子性(Atomicity):
            事务是不可分割的最小操作单元, 要么同时成功, 要么同时失败
        C-一致性(Consistency):
            事务完成时, 必须使所有数据都保持一致状态
        I-隔离性(Isolation):
            多个事务之间, 操作的可见性
        D-持久性(Durability):
            事务一旦提交或回滚, 它对数据库中的数据的改变就是永久的
 */

public class $10_MySqlAffair {
}