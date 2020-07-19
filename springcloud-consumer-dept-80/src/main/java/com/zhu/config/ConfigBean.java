package com.zhu.config;


import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {

    @Bean
    @LoadBalanced //Spring Cloud Ribbon是基于Netflix Ribbon实现的一套客户端  负载均衡的工具。
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    public IRule myRule(){
        //RoundRobinRule()：轮询算法
        return new RandomRule(); //用我们重新选择的随机算法替代默认的轮询算法。
        //RetryRule()：先按照RoundRobinRule()获取服务，如果获取服务失败则在指定时间内会重新重试，获取可用的服务
    }
}
