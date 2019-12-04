package com.imooc.girl.modelUtils.观察者模式;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>Description:</p>
 * <p>Copyright: Copyright (c)2019$</p>
 * <p>Company: Tope</p>
 * <P>Created Date :2019$-11$-30$</P>
 * <P>@version 1.0</P>
 */
public class Subject {
    private List<Observer> observers = new ArrayList<Observer>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }
    public void attach(Observer observer){
        observers.add(observer);
    }

    private void notifyAllObservers() {
        for (Observer observer : observers){
            observer.update();
        }
    }
}
