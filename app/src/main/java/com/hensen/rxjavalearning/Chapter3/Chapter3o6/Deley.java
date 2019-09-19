package com.hensen.rxjavalearning.Chapter3.Chapter3o6;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by handsomexu on 2018/4/9.
 */

public class Deley {

    public static void main(String[] args) {
        Disposable subscribe = Observable.just(1, 2, 3, 4, 5).delay(100, TimeUnit.SECONDS)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        System.out.println("onNext=" + integer);
                    }
                });

        subscribe.dispose();
    }
}
