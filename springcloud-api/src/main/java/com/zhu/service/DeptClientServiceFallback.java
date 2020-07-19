package com.zhu.service;


import com.zhu.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

//把熔断机制在接口处理，降低主程序耦合
//Fallback备选响应
@Component //必须添加
public class DeptClientServiceFallback implements FallbackFactory<DeptClientService> {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public int addDept(Dept dept) {
                return 0;
            }

            @Override
            public Dept selectById(Long id) {
                return new Dept().setDeptno(id).setDname("该id没有相应的信息").setDb_source("数据库没有此信息");
            }

            @Override
            public List<Dept> selectAll() {
                return null;
            }
        };
    }
}
