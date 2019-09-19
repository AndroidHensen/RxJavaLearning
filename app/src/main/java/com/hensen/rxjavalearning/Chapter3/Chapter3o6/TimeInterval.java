package com.hensen.rxjavalearning.Chapter3.Chapter3o6;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Timed;

/**
 * Created by handsomexu on 2018/4/9.
 */

public class TimeInterval {

    public static void main(String[] args) {
        Observable.interval(2, TimeUnit.SECONDS).timeInterval(TimeUnit.SECONDS)
                .subscribe(new Consumer<Timed<Long>>() {
                    @Override
                    public void accept(Timed<Long> longTimed) throws Exception {
                        System.out.println("onNext=" + longTimed.value() + " timeInterval=" + longTimed.time());
                    }
                });
    }
}
