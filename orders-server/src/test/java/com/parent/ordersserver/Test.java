package com.parent.ordersserver;

/**
 * 欣能信息科技 面试题
 */
public class Test {

    public static void main(String[] args) {
        String str = "ABCDE";
        str.substring(3);
        str.concat("XYZ");

        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");
        operate(a,b);

        System.out.println(str);
        System.out.println(a+","+b);

    }
    private static void operate(StringBuffer x,StringBuffer y){
        x.append(y);
        x=y;
    }
}
