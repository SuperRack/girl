package com.imooc.girl.Utils.练习;

/**
 * <p>Description:</p>
 * <p>Copyright: Copyright (c)2019$</p>
 * <p>Company: Tope</p>
 * <P>Created Date :2019$-11$-29$</P>
 * <P>@version 1.0</P>
 */
public class SingletonTest {
    private static volatile SingletonTest instance;
    private SingletonTest(){

    }

    //单线程
    private static SingletonTest getInstance(){
        if (instance ==null){
            instance = new SingletonTest();
        }

        return instance;
    }
    //多线程
    public static SingletonTest getInstance2(){
        if (instance == null){
            synchronized (SingletonTest.class){
                if (instance ==null){
                    instance = new SingletonTest();
                }
                return instance;
            }
        }
        return instance;
    }

    //静态内部类
    public static class Inner{
        private static final SingletonTest instance = new SingletonTest();
    }

    public static SingletonTest getInstance3(){
        return Inner.instance;
    }
}
