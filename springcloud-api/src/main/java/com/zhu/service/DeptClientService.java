package com.zhu.service;

import com.zhu.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

//@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT")
@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT",fallbackFactory = DeptClientServiceFallback.class)
public interface DeptClientService {

    @PostMapping("/dept/add")
    public int addDept(Dept dept);

    @GetMapping("/dept/get/{id}")
    public Dept selectById(@PathVariable("id") Long id);

    @GetMapping("/dept/list")
    public List<Dept> selectAll();


}
