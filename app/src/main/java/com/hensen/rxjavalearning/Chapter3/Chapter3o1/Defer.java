package com.hensen.rxjavalearning.Chapter3.Chapter3o1;

import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;

/**
 * Created by handsomexu on 2018/4/9.
 */

public class Defer {

    static int i = 5;

    public static void main(String[] args) {

        i = 10;

        Observable<Integer> just = Observable.just(i, i);
        Observable<Object> defer = Observable.defer(new Callable<ObservableSource<?>>() {
            @Override
            public ObservableSource<?> call() throws Exception {
                //缓存新的事件流
                return Observable.just(i, i);
            }
        });

        i = 15;

        just.subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                System.out.println("onNext=" + integer);
            }
        });

        defer.subscribe(new Consumer<Object>() {
            @Override
            public void accept(Object o) throws Exception {
                System.out.println("onNext=" + (int) o);
            }
        });

        i = 20;

        defer.subscribe(new Consumer<Object>() {
            @Override
            public void accept(Object o) throws Exception {
                System.out.println("onNext=" + (int) o);
            }
        });
    }
}
