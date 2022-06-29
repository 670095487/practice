#zookeeper

 1. TTL结点默认是不开启的，开启以后也不能保证结点会准时删除。
 2. 事务日志和快照（类似redis中的aof 和 rdb）
 3. 幽灵结点可以通过使用withProtection模式避免，原理是使用uuid作为唯一标识
 4. zk和redis：zk可靠性高（zk的lead-follower模式决定了zk是比redis更可靠的存在，半数写入成功才会存盘，而redis
    是只要master写成功就算成功，这样在master宕机的时候，就会丢失一部分数据。）redis性能高。
 3. 分布式锁redis和zk的区别
    1. redis 主从 (master写成功就算成功)
    2. zk leader-follow (半数以上写成功，才算成功，可靠性高)
 4. 非公平锁（羊群效应），公平锁（根据zookeeper的seq节点，每次取最小，后者会watcher前者）
 5. 双写不一致问题（读写锁分开） 写写互斥 写读互斥 读读不影响
 6. 源码部分：多队列优化性能
 7. 避免socket重复连接:只允许sid大的连接小的
 8. 