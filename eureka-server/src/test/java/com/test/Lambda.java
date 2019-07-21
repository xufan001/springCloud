package com.test;

public class Lambda {

    /**
     * 普通的Runnable
     */
    public static void runSomeThing(){

        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                System.out.println("I am running");
            }
        };
        new Thread(runnable).start();
    }


    /**
     * 使用lambda后的
     */
    public static void runSomeThingByLambda(){
        new Thread(() -> System.out.println("I am running")).start();
    }

    public static void main(String[] args) {
        runSomeThing();
//      runSomeThingByLambda();
    }
}


