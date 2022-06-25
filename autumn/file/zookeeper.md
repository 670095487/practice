#zookeeper

 1. TTL结点默认是不开启的，开启以后也不能保证结点会准时删除。
 2. 事务日志和快照（类似redis中的aof 和 rdb）
 3. 分布式锁redis和zk的区别
    1. redis 主从 (master写成功就算成功)
    2. zk leader-follow (半数以上写成功，才算成功，可靠性高)
 4. 非公平锁（羊群效应），公平锁（根据zookeeper的seq节点，每次取最小，后者会watcher前者）
 5. 双写不一致问题（读写锁分开） 写写互斥 写读互斥 读读不影响
 6. 源码部分：多队列优化性能
 7. 避免socket重复连接:只允许sid大的连接小的
 8. 