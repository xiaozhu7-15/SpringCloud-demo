package com.zhu.service;


import com.zhu.pojo.Dept;

import java.util.List;

public interface DeptService {
    int addDept(Dept dept);

    Dept selectById(Long id);

    List<Dept> selectAll();
}
