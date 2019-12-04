package com.imooc.girl.Utils.练习;

import java.util.concurrent.CountDownLatch;

/**
 * <p>Description:</p>  定义：让一些线程阻塞直到另一些线程完成一些列操作之后才被唤醒。
                        即使门闩的意思，给定一个数，当这个数被减到0时才能开始运行另一个线程。
 * <p>Copyright: Copyright (c)2019$</p>
 * <p>Company: Tope</p>
 * <P>Created Date :2019$-11$-29$</P>
 * <P>@version 1.0</P>
 */
public class CountDownLatchTest {
    public static void main(String[] args) throws Exception {
        closeDoor();
    }

    public static void closeDoor() throws  Exception{
        //初始化时给与一个初始门闩值
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i=1;i<=6;i++){
            new Thread( () ->{
                System.out.println(Thread.currentThread().getName()+"\t 上完自习，离开教室");
                //让门闩减一
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        //被阻塞，只有在门闩值减少到0的时候才运行
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t 班长锁门走人");

    }
}
