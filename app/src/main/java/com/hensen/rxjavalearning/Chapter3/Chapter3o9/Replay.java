package com.hensen.rxjavalearning.Chapter3.Chapter3o9;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.observables.ConnectableObservable;

/**
 * Created by handsomexu on 2018/4/9.
 */

public class Replay {

    public static void main(String[] args) {
        ConnectableObservable<Long> connectableObservable = Observable.interval(1, TimeUnit.SECONDS).replay();
        connectableObservable.connect();

        connectableObservable.delaySubscription(3, TimeUnit.SECONDS)
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        System.out.println("onNext=" + aLong);
                    }
                });
    }
}
