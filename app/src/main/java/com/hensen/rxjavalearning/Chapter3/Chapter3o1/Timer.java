package com.hensen.rxjavalearning.Chapter3.Chapter3o1;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by handsomexu on 2018/4/11.
 */

public class Timer {

    public static void main(String[] args) {
        Disposable subscribe = Observable.timer(1, TimeUnit.SECONDS)
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        System.out.println("onNext=" + aLong);
                    }
                });
    }
}
