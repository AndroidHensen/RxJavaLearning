package com.hensen.rxjavalearning.Chapter7.Chapter7o3;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.functions.BiFunction;

/**
 * Created by handsomexu on 2018/10/6.
 */

public class CustomObservableSubscribe implements BiFunction<Observable, Observer, Observer> {
    @Override
    public Observer apply(Observable observable, Observer observer) throws Exception {
        System.out.println("CustomObservableSubscribe observable.toString:" + observable.toString() + ",observer.toString:" + observer.toString());
        return observer;
    }
}
