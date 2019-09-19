package com.hensen.rxjavalearning.Chapter3.Chapter3o4;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by handsomexu on 2018/4/11.
 */

public class Join {

    public static void main(String[] args) {
        Observable<String> just1 = Observable.just("A", "B", "C", "D", "E");
        Observable<Long> just2 = Observable.interval(1, TimeUnit.SECONDS);

        just1.join(just2, new Function<String, ObservableSource<Long>>() {
            @Override
            public ObservableSource<Long> apply(String s) throws Exception {
                return Observable.timer(3, TimeUnit.SECONDS);
            }
        }, new Function<Long, ObservableSource<Long>>() {
            @Override
            public ObservableSource<Long> apply(Long l) throws Exception {
                return Observable.timer(8, TimeUnit.SECONDS);
            }
        }, new BiFunction<String, Long, String>() {
            @Override
            public String apply(String s, Long l) throws Exception {
                return s + l;
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println("onNext=" + s);
            }
        });
    }
}
