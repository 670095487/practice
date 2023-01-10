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
- 读取配置（取最高优先级的配置） -> 启动netty/tomcat -> 服务注册 -> 服务提供者，监听动态配置
- ServiceBean -> ServiceConfig -> abstract -> registyProtocal -> dubboProtocal(spi相关)
- systemConfig:jvm级别（idea中以-D配置的环境变量就是jvm级别），environmentConfig:系统级别，

#### 8.服务调用

- 负责序列化/反序列化dubbo协议的类：***DubboCodec***
- handler需要处理异步和同步调用的返回值
- 服务端异常报错并不会在服务端抛出，而是类似本地调用一样返回给消费端
- invoker的生成流程 
- dubbo的心跳任务默认使用的netty自带的，除非使用了其他的server，不支持心跳才会使用dubbo自己实现的心跳

#### 9. 配置文件

```yml
dubbo:
  application:
    id: dubbo-provider
    name: dubbo-provider
  protocol:
    id: dubbo
    name: dubbo
    port: 20881
  registry:
    id: dubbo-provider-registry
    address: zookeeper://139.196.59.54:2181
    timeout: 60000
  provider:
    timeout: 5000
```

```xml
<dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>com.20221124</groupId>
            <artifactId>dubbo-api</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/org.apache.dubbo/dubbo-spring-boot-starter -->
        <dependency>
            <groupId>org.apache.dubbo</groupId>
            <artifactId>dubbo-spring-boot-starter</artifactId>
            <version>2.7.8</version>
        </dependency>

        <dependency>
            <groupId>org.apache.curator</groupId>
            <artifactId>curator-framework</artifactId>
            <version>5.1.0</version>
        </dependency>
        <dependency>
            <groupId>org.apache.curator</groupId>
            <artifactId>curator-recipes</artifactId>
            <version>5.1.0</version>
        </dependency>
    </dependencies> 
```


​    
​    
​    
​    
​    
#### 10.关于dubbo是如何读取配置以及获取配置的几种方式

 - dubbo项目有几种配置
   - SystemConfiguration [jvm级别的环境变量，idea中使用-D配置的变量就是jvm级别]
   - EnvironmentConfiguration [操作系统级别的环境变量]
   - InmemoryConfiguration [来源于appExternalConfigurationMap]
   - InmemoryConfigurationexternalConfigurationMap ?
   - serviceConfig [可以根据配置调整优先级至第3或者第5]
   - propertiesConfiguration [一般都是yml里属于dubbo的配置信息]
 - 关于配置的优先级
   - **动态配置 > VM OPTION > reference > 其他**

#### 11. URL && INVOKER

- URL: URL是指服务的所有资源信息
- INVOKER: 实际调用者（会从根据ref从map里取到真正的service provider）
  - 包含所有服务信息的对象，可以用来执行服务的导出和注销
- 通过zkClient.create()和zk进行通信，将服务的具体信息处理成对应规则的数据传输至zk
- 服务注册：构造服务的url，剔除冗余的key,注册至zk（就是zkClient.create()）
- 在进行了动态配置以后，会将更改后的url和origin url先进行比对，如果有改变才会reExport, reExport不需要重启netty
- 服务注册：构造服务信息的url，然后将url注册到zookeeper上

#### 服务引入

- 代理对象调用方法的前置处理：
  - 获取服务提供者列表
  - mock
  - 路由
  - 负载均衡
  - 集群容错
  - 构造nettyClient
  - 发送数据（通过 invocation）
  
- 如何生成一个代理对象
  - 1.构造Invoker (有多少个url就会生成多少个Invoker)
  - 2.服务目录(就是本地缓存) RegistryDirectory.class
    - 2.1 根据serviceName去注册中心上查
    - 2.2 根据拿到的list<provider> 有多少个URL(**代表的就是服务信息**)就生成多少个list<dubboInvoker>
    - 2.3 监听（监听这个服务的变化）
    - 2.4 路由 RegistryDirectory.list()[返回值是list<invoker>]
    - 2.5 路由链 tagRouter--->appRouter--->ServiceRouter-->（监听路由conditions）
  - 如何构造一个invoker和服务目录
    - 服务目录： 
    - invoker:
- cluster.join()[**没懂**]
- 路由种类
  - tagRouter[灰度发布的时候可以用]
  - appStateRouter
  - conditionRouter


#### dubbo源码阅读 版本：2.6.x
- 启动入口：ServiceBean.class 主要链路如下：

  - ServiceBean.class[onApplicationEvent()] --> ServiceConfig.class[doExport() --> doExportUrls()[1. 初始化map存放服务信息，--> 初始化url对象 --> 调用proxyFactory.getInvoker()为每一个url生成对应的invoker]

    --> 将生成的Invoker再包装一层变成Exporter类型的对象(一个invoker属性一个boolean unexport)-->然后加入到**exporters**(本质是个list) --> openServer(url)] 

    -->  RegistryProtocal.class (到这里已经开启了服务，生成了对应的代理服务)

    --> 发布ServiceBeanExportedEvent

    **看样子是dubbo完成所有了服务导出步骤以后，通知spring可以刷新容器了，然后spring从被dubbo打断的地方（onApplicationEvent()）这个方法结束以后spring容器开始正常启动成功

  - ```java
    public void onApplicationEvent(ContextRefreshedEvent event) {
            if (isDelay() && !isExported() && !isUnexported()) {
                if (logger.isInfoEnabled()) {
                    logger.info("The service ready on spring started. service: " + getInterface());
                }
                export();
            }
        }
    ```

  - ```java
    // 方法内容有删除
    protected synchronized void doExport() { 
            if (ref instanceof GenericService) {
                interfaceClass = GenericService.class;
                if (StringUtils.isEmpty(generic)) {
                    generic = Boolean.TRUE.toString();
                }
            } else {
                try {
                    // 反射生成需要代理的service,就是provider的接口全限定名
                    interfaceClass = Class.forName(interfaceName, true, Thread.currentThread()
                            .getContextClassLoader());
                } catch (ClassNotFoundException e) {
                    throw new IllegalStateException(e.getMessage(), e);
                }
            // 中间都是一些合法性校验
            // ……
            // ……
            
            // 导出服务的url    
            doExportUrls();
            CodecSupport.addProviderSupportedSerialization(getUniqueServiceName(), getExportedUrls());
            ProviderModel providerModel = new ProviderModel(getUniqueServiceName(), this, ref);
            ApplicationModel.initProviderModel(getUniqueServiceName(), providerModel);
        }
    ```

    

  - ```java
     Invoker<?> invoker = proxyFactory.getInvoker(ref, (Class) interfaceClass, registryURL.addParameterAndEncoded(Constants.EXPORT_KEY, url.toFullString()));
    ```

  - 