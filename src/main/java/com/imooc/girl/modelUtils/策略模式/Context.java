package com.imooc.girl.modelUtils.策略模式;

/**
 * <p>Description:</p>
 * <p>Copyright: Copyright (c)2019$</p>
 * <p>Company: Tope</p>
 * <P>Created Date :2019$-11$-30$</P>
 * <P>@version 1.0</P>
 */
public class Context {
    private Strategy strategy;
    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public int executeStrategy(int num1,int num2){
        return strategy.doOperation(num1,num2);
    }
}
