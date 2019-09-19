package com.hensen.rxjavalearning.Chapter3.Chapter3o7;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * Created by handsomexu on 2018/4/9.
 */

public class SkipUntil {

    public static void main(String[] args) {
        Observable<Long> just1 = Observable.interval(1, TimeUnit.SECONDS);
        Observable<Integer> just2 = Observable.just(8).delay(3, TimeUnit.SECONDS);

        just1.skipUntil(just2)
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        System.out.println("onNext=" + aLong);
                    }
                });
    }
}
