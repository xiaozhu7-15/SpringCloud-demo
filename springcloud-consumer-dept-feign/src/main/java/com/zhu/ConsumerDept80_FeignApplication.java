package com.zhu;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.zhu")
public class ConsumerDept80_FeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerDept80_FeignApplication.class, args);
    }

}
