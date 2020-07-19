package com.zhu;

import com.myselfRule.MyselfRules;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;



@SpringBootApplication
@EnableEurekaClient
//在主启动类上去加载我们自定义的Ribbon配置类，从而使配置生效
@RibbonClient(name = "SPRINGCLOUD-PROVIDER-DEPT",configuration = MyselfRules.class)
public class SpringcloudConsumerDept80Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudConsumerDept80Application.class, args);
    }

}
