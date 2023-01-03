## spring

### 1.监听器
- 可以通过监听spring内嵌事件来实现 **在容器加载之前 之后 对bean的自定义操作**
```java
@Component
public class MyListener {

    @EventListener(ContextRefreshedEvent.class) //ContextClosedEvent.class
    public void onApplicationEvent(@NonNull ContextRefreshedEvent event) {
        System.out.println("**************************************************");
        System.out.println("容器加载完毕");
        System.out.println("**************************************************");
    }
}
  ```
- 使用注解的方式注入bean的时候，可以通过实现beanFactoryPostProcessor去自定义是byName还是byType的注入
- 注册监听器时，1.注册bean name,2.注册bean **防止懒加载的监听器被漏掉**
- 使用注解方式的监听器处理的地方 和 使用实现ApplicationListener接口监听器处理的地方的不同处
