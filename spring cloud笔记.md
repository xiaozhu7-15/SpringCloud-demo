### spring cloud

1. 导入依赖
2. 编写配置文件
3. 开启这个功能 @enablexxxx
4. 配置类

**eureka自我保护机制：某一时刻某一个微服务不可用了，eureka不会立刻清理，依旧会对该微服务的信息进行保存**

Ribbon负载均衡：

Ribbon和eureka整合后，消费者（consumer）可以直接调用服务而不用再关心地址和端口号。

Feign负载均衡：

Feign通过接口方法调用Rest服务（之前是Ribbon+RestTemplate）。

该请求发送eureka服务器，通过feign直接找到服务接口，由于在进行服务调用的时候融合了ribbon技术，所以也支持负载均衡作用。

Hystrix断路器

服务熔断：一旦调用服务方法失败并抛出错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中指定的方法。

**一般是某个服务故障或者异常引起，类似现实中的“保险丝”，当某个异常条件被触发，直接熔断整个服务，而不是一直等到此服务超时。**

服务降级：处理实在客户端实现，与服务端无关。

**所谓降级，一般是从整体负荷考虑。就是当某个服务熔断之后，服务器将不再调用，此时客户端可以自己携带一个fallback回调，返回一个缺省值。**

此时服务端provider已经down了，但是做了服务降级处理，让客户端在服务端不可用时也会获得提示信息而不会挂起耗死服务器。

zuul路由网关

springcloud config分布式配置中心

application.yml是用户级的资源配置项

bootstrap.yml是系统级的，优先级更高