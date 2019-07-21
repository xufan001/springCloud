package com.crud.dao;

import com.crud.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper

public interface EmployeeDao {

     @Select("select * from employee" )
     List<Employee> findAll();
}
