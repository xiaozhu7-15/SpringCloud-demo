package com.myselfRule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyselfRules {

    @Bean
    public IRule myRule(){
        //return new RandomRule(); //Ribbon默认是轮询，我自定义为随机
        return new RandomRule_ZH(); //我自定义的
    }
}
