package com.imooc.girl.modelUtils.策略模式;

/**
 * <p>Description:</p>
 * <p>Copyright: Copyright (c)2019$</p>
 * <p>Company: Tope</p>
 * <P>Created Date :2019$-11$-30$</P>
 * <P>@version 1.0</P>
 */
public class StrategyPatternDemo {
    public static void main(String[] args) {
        Context context = new Context(new OperationAdd());
        System.out.println("10+5="+context.executeStrategy(10,5));
        context = new Context(new OperationSubstract());
        System.out.println("10-5="+context.executeStrategy(10,5));
        context = new Context(new OperationMultiply());
        System.out.println("10*5="+context.executeStrategy(10,5));
    }
}
