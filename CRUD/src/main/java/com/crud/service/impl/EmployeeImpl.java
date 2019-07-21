package com.crud.service.impl;

import com.crud.dao.EmployeeDao;
import com.crud.pojo.Employee;
import com.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.Servlet;
import java.util.List;
@Service
@Transactional
public class EmployeeImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;


    public List<Employee> findAll() {


        List<Employee> all = employeeDao.findAll();

        return all;


    }
}
