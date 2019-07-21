package com.crud.serial;

import org.hibernate.validator.constraints.EAN;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestSerial {
    public static void main(String[] args) throws FileNotFoundException {
//        //创建一个User对象
//        UserInfo user = new UserInfo("Mark", "123456");
//        //创建一个List对象
//        ArrayList<String> list = new ArrayList<>();
//        list.add("my name");
//        list.add("is");
//        list.add("hr");

//        try {
//            ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("E:/scourses/FileStream/test.txt"));
//            stream.writeObject(user);
//            stream.writeObject(list);//将user对象和list列表写进文件
//            stream.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }catch (IOException e){
//            e.printStackTrace();
//        }

    try {
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("E:/scourses/FileStream/test.txt"));
        UserInfo o = (UserInfo)inputStream.readObject();//从流中读取User数据
        System.out.println(o.getName());
        System.out.println(o.getNumber());
        List o1 =(List) inputStream.readObject();//从流中取出list数组
        for (Iterator iterator =o1.iterator(); iterator.hasNext();){
            System.out.println(iterator.next());
        }
        inputStream.close();
    }catch (IOException e){
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }

    }

}
