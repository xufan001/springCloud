package com.crud.pojo;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.io.Serializable;
import java.util.Date;
@EntityScan
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
    private Integer age;
    private Date birthday;
    private String address;
    private Double wage;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getAddress() {
        return address;
    }

    public Double getWage() {
        return wage;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setWage(Double wage) {
        this.wage = wage;
    }

}
