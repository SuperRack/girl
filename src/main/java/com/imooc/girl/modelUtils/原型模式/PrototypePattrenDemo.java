package com.imooc.girl.modelUtils.原型模式;

/**
 * <p>Description:</p>
 * <p>Copyright: Copyright (c)2019$</p>
 * <p>Company: Tope</p>
 * <P>Created Date :2019$-11$-30$</P>
 * <P>@version 1.0</P>
 */
public class PrototypePattrenDemo {
    public static void main(String[] args) {
        ShareCache.loadCache();
        Shape cloneShape = (Shape) ShareCache.getShape("1");
        System.out.println("Shape:"+cloneShape.getType());
        Shape cloneShape2 = (Shape) ShareCache.getShape("2");
        System.out.println("Shape:"+cloneShape2.getType());
        Shape cloneShape3 = (Shape) ShareCache.getShape("3");
        System.out.println("Shape:"+cloneShape3.getType());
    }
}
