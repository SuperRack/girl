package com.imooc.girl.modelUtils.原型模式;

import java.util.Hashtable;

/**
 * <p>Description:</p>
 * <p>Copyright: Copyright (c)2019$</p>
 * <p>Company: Tope</p>
 * <P>Created Date :2019$-11$-30$</P>
 * <P>@version 1.0</P>
 */
public class ShareCache {
    private static Hashtable<String,Shape> shareMap
            = new Hashtable<String, Shape>();
    public static Shape getShape(String shapeId){
        Shape cacheShape = shareMap.get(shapeId);
        return (Shape) cacheShape.clone();
    }

    public static void loadCache(){
        Circle circle = new Circle();
        circle.setId("1");
        shareMap.put(circle.getId(),circle);
        Square square = new Square();
        square.setId("2");
        shareMap.put(square.getId(),square);
        Rectangle rectangle = new Rectangle();
        rectangle.setId("3");
        shareMap.put(rectangle.getId(),rectangle);
    }

}
