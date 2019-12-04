package com.imooc.girl.Utils.练习;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * <p>Description:</p> CopyOnWrite叫做写时复制
 * <p>Copyright: Copyright (c)2019$</p>
 * <p>Company: Tope</p>
 * <P>Created Date :2019$-11$-29$</P>
 * <P>@version 1.0</P>
 */
public class ArrayListTest {
    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 1;i<=30;i++){
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }

}

