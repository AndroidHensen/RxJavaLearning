package com.hensen.rxjavalearning.Chapter3.Chapter3o3;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * Created by handsomexu on 2018/4/11.
 */

public class Sample {

    public static void main(String[] args) {
        Observable.interval(1, TimeUnit.SECONDS)
                .sample(2, TimeUnit.SECONDS)
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        System.out.println("onNext=" + aLong);
                    }
                });
    }
}
