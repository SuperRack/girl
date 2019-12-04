package com.imooc.girl.modelUtils.原型模式;

/**
 * <p>Description:</p>
 * <p>Copyright: Copyright (c)2019$</p>
 * <p>Company: Tope</p>
 * <P>Created Date :2019$-11$-30$</P>
 * <P>@version 1.0</P>
 */
public class Circle extends Shape{
    public Circle(){
        type ="Circle";
    }
    @Override
    void draw() {
        System.out.println("Inside Circle");
    }
}
