### Dubbo
 #### 1.什么是RPC？

- 简单来说，对于Java程序员⽽⾔，RPC就是远程⽅法调⽤
- 和本地方法调用的不同之处在于，RPC需要通过网络传输数据来调用远程服务器上的方法，所以RPC是一套双方约定好的通信协议。
- RPC有多种协议，例如：RPC over Http / RPC over tcp...
- 但是无论何种协议，在进行远程方法调用时，有三个点是必须要考虑的：**1.调哪个类or接口？2.调哪个方法？3.入参是什么**
如果能满足这三个条件，是不是可以开发属于自己的RPC框架？于是**DUBBO**作为阿里的开源RPC框架就做到了。

#### 2.什么是Dubbo？

- https://dubbo.apache.org/zh/
- 简单来说，dubbo就是一个RPC框架，它可以让项目中涉及到的远程方法调用对于调用者来说**就和调用本地方法一样简单**。

#### 3. 为什么要用dubbo？

- 系统复杂度高，服务拆分，功能单一，调用链路长，使用传统的http调用
不能满足需求，dubbo可以做到**管理服务**，**负载均衡**，**服务容错**

#### 4. dubbo的可扩展机制SPI

- @Reference : 生成dubboService的代理对象

```java
    ReferenceAnnotationBeanPostProcessor.class -> AnnotationBeanPostProcessor.class -> doGetInjectedBean()
```

#### 4. dubbo基本模块

- provider
- consumer
- registry 【一般会使用zookeeper做注册中心】
- monitor

#### 5. 调用方式

- 服务容器负责启动，加载，运行服务提供者。
- 服务提供者在启动时，向注册中心注册自己提供的服务。
- 服务消费者在启动时，向注册中心订阅自己所需的服务。
- 注册中心返回服务提供者地址列表给消费者，如果有变更，注册中心将基于长连接推送变更数据给消费者。
- 服务消费者，从提供者地址列表中，基于软负载均衡算法，选一台提供者进行调用，如果调用失败，再选另一台调用。
- 服务消费者和提供者，在内存中累计调用次数和调用时间，定时每分钟发送一次统计数据到监控中心。

#### 6. dubbo的一些优点

- 支持多种协议rpc协议，配置上很灵活
- 使用Netty和Zookeeper保证了性能和稳定性。

#### 7. dubbo的源码

##### 7.1服务导出 
- 在springboot中的入口方法:```onApplicationEvent(ContextRefreshedEvent event)```
- dubbo开始的方法：```ServiceBean.export()```
- 读取配置（取最高优先级的配置） -> 服务注册 -> 启动netty/tomcat -> 服务提供者，监听动态配置
- ServiceBean -> ServiceConfig -> abstract
- systemConfig:jvm级别（idea中以-D配置的环境变量就是jvm级别），environmentConfig:系统级别，


