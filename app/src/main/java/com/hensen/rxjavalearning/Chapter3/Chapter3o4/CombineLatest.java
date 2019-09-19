package com.hensen.rxjavalearning.Chapter3.Chapter3o4;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by handsomexu on 2018/4/11.
 */

public class CombineLatest {

    public static String[] str = {"A", "B", "C", "D", "E"};

    public static void main(String[] args) {
        Observable<String> just1 = Observable.interval(1, TimeUnit.SECONDS).map(new Function<Long, String>() {
            @Override
            public String apply(Long aLong) throws Exception {
                return str[(int) (aLong % 5)];
            }
        });
        Observable<Long> just2 = Observable.interval(1, TimeUnit.SECONDS);

        Observable.combineLatest(just1, just2, new BiFunction<String, Long, String>() {
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
