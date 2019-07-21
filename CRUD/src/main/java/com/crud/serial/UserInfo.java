package com.crud.serial;

import java.io.Serializable;

public class UserInfo implements Serializable {

    private String Name;
    private String Number;

    public UserInfo(String name, String number) {
        Name = name;
        Number = number;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "Name='" + Name + '\'' +
                ", Number='" + Number + '\'' +
                '}';
    }
}
