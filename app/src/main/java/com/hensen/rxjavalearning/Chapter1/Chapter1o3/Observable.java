package com.hensen.rxjavalearning.Chapter1.Chapter1o3;

/**
 * Created by handsomexu on 2018/4/7.
 */

//被观察者
public interface Observable {
    //订阅
    void subscribe(Observer observer);
    //取消订阅
    void cancel(Observer observer);
    //发布
    void onNext();
}