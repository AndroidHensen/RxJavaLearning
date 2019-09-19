package com.hensen.rxjavalearning.Chapter3.Chapter3o6;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * Created by handsomexu on 2018/4/9.
 */

public class TimeOut {

    public static void main(String[] args) {
        Observable.interval(2, TimeUnit.SECONDS).timeout(1, TimeUnit.SECONDS)
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        System.out.println("onNext=" + aLong);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        System.out.println("onError");
                    }
                });
    }
}
