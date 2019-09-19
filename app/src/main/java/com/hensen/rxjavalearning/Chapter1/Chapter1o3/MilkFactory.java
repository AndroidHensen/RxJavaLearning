package com.hensen.rxjavalearning.Chapter1.Chapter1o3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by handsomexu on 2018/4/7.
 */

//牛奶店
public class MilkFactory implements Observable{

    private List<Observer> observers;

    public MilkFactory() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void cancel(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void onNext() {
        for (Observer observer : observers) {
            observer.onNotify();
        }
    }
}
