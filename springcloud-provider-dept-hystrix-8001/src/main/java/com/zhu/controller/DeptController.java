package com.zhu.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zhu.pojo.Dept;
import com.zhu.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//提供restful服务
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping("/dept/get/{id}")
    //一旦调用服务方法失败并抛出错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中指定的方法
    @HystrixCommand(fallbackMethod = "Hystrix_get")
    public Dept get(@PathVariable("id") Long id){
        Dept dept = this.deptService.selectById(id);
        if(dept == null){
            throw new RuntimeException("没有该id相应的信息");
        }
        return dept;
    }

    //@GetMapping("/dept/get/{id}")
    public Dept Hystrix_get(@PathVariable("id") Long id){
        Dept dept = new Dept();
        dept.setDeptno(id);
        dept.setDname("该id"+id+"没有相应的信息");
        dept.setDb_source("没有此数据在数据库中");
        return dept;
    }
}
