package com.hensen.rxjavalearning.Chapter3.Chapter3o8;

import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.functions.BiConsumer;

/**
 * Created by handsomexu on 2018/4/11.
 */

public class Collect {

    public static void main(String[] args) {
        Observable.just(8, 2, 13, 1, 15).collect(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "A";
            }
        }, new BiConsumer<String, Integer>() {
            @Override
            public void accept(String s, Integer integer) throws Exception {
                System.out.println("onNext=" + s + "  " + integer);
            }
        }).subscribe(new BiConsumer<String, Throwable>() {
            @Override
            public void accept(String s, Throwable throwable) throws Exception {
                System.out.println("onNext2=" + s);
            }
        });
    }
}
