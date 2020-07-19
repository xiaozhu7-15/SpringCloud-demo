package com.zhu.dao;


import com.zhu.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptMapper {

    int addDept(Dept dept);

    Dept selectById(Long id);

    List<Dept> selectAll();
}
