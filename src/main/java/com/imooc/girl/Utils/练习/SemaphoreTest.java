package com.imooc.girl.Utils.练习;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * <p>Description:</p> 信号量主要用于两个目的，一个是用于多个共享资源的互斥使用，另一个用于并发线程数的控制。
 * <p>Copyright: Copyright (c)2019$</p>
 * <p>Company: Tope</p>
 * <P>Created Date :2019$-11$-29$</P>
 * <P>@version 1.0</P>
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        //默认非公平锁
        Semaphore semaphore = new Semaphore(3);
        for (int i =1;i<=6;i++){
            new Thread(() ->{
                try {
                    //消费一个许可证
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"\t 抢到车位");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName()+"\t 停车3秒后离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    //创建一个许可证
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }
    }


}
