package com.zhu.controller;


import com.zhu.pojo.Dept;
import com.zhu.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
public class DeptConsumer_Controller {

    @Autowired
    private DeptClientService service;

    @PostMapping("/consumer/dept/add")
    public int addDept(Dept dept){
        return this.service.addDept(dept);
    }

    @GetMapping("/consumer/dept/get/{id}")
    public Dept selectById(@PathVariable("id") Long id){
        return this.service.selectById(id);
    }

    @GetMapping("/consumer/dept/list")
    public List<Dept> selectAll(){
        return this.service.selectAll();
    }
}
