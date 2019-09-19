package com.hensen.rxjavalearning.Chapter7.Chapter7o3;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by handsomexu on 2018/10/6.
 */

public class CustomObservableAssembly implements Function<Observable, Observable> {
    @Override
    public Observable apply(Observable observable) throws Exception {
        System.out.println("CustomObservableAssembly observable.toString:" + observable.toString());
        return observable;
    }
}
