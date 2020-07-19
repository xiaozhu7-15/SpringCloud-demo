package com.zhu.service;


import com.zhu.pojo.Dept;

import java.util.List;


//把熔断机制在接口处理，降低主程序耦合
public interface DeptService {
    int addDept(Dept dept);

    Dept selectById(Long id);

    List<Dept> selectAll();
}
