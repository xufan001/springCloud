package com.crud.controller;

import com.alibaba.fastjson.JSON;
import com.crud.pojo.Employee;
import com.crud.service.EmployeeService;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")

public class EmployeeController {
 private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/all")
    public List<Employee> findAll(){

       // long start = System.currentTimeMillis();
        List<Employee> all = employeeService.findAll();//执行时间，使用AOP的环绕
       // long end = System.currentTimeMillis();
        //logger.info("服务执行时间为："+(end-start));
        //JSONObject json = JSONObject.fromObject(obj);//将java对象转换为json对象
        String o = JSON.toJSONString(all);//使用fastjson将对象转json字符串
        logger.info("查询结果为："+o);
        return all;
    }
}
