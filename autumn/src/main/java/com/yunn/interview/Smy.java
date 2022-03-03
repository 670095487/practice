package com.yunn.interview;

/**
 * Smy
 *
 * @author: yunN
 * @createTime: 2021/02/08 14:29:39
 * @description: view summary
 */
@SuppressWarnings("all")
public class Smy {
    /*
     *  限流、熔断、降级 -- 系统高可用 hystrix
     *
     *  资源隔离、限流、熔断、降级、运维监控
     *
     *  hystrix设计原则：
     *   1.延迟、失败、容错
     *
     *
     * 分库分表-主从库-垂直拆分-水平拆分 【原理、优缺点】
     * 分库分表中间件 {
     *   proxy：跨语言 mycat altas shardingproxy
     *   jdbc应用层 ：只是JAVA
     * }
     * 主从复制，原理使用到了mysql的 binlog，主要目的是为了缓解主库的读压力，将读操作放至从库进行，
     * 优点：缓解了主库的压力，
     * 缺点：在网络延迟的情况下，会出现主库修改完数据，从库得不到及时同步的情况【这时候需要·强制路由·】
     *
     * 但是主从复制仅仅缓解了交易对主库的读压力，写压力仍旧存在，所以分库分表应运而生。
     * 分表方式：垂直拆分、水平拆分。
     * 垂直拆分：将一张表的多个字段拆分为多个表，使用唯一ID进行绑定。
     *   优点：业务层面灵活性高，可根据业务再进行拆分，
     *   缺点：代码复杂度更高，查询数据更加麻烦，维护起来比较麻烦。因为一行数据被分散在了多个表中，所以查询一行数据变得很困难。
     * 水平拆分：将表数据均匀分布到多个表中，一般使用唯一记录字段对hash取模来保证分配到每个表中的数据量平均
     *   优点：查询简单，维护简单
     *   缺点：后续业务扩展基本不可能，需要在业务上线之初定好合适的分表数目。
     * */

    private static int a = 0;

    static {
        a = 4;
    }

    public static void main(String[] args) {
        System.out.println(a);
    }
}
