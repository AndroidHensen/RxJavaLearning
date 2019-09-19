package com.hensen.rxjavalearning.Chapter3.Chapter3o7;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;

/**
 * Created by handsomexu on 2018/4/9.
 */

public class TakeWhile {

    public static void main(String[] args) {
        Observable.just(1, 2, 3, 4, 0)
                .takeWhile(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Exception {
                        return integer < 3;
                    }
                })
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        System.out.println("onNext=" + integer);
                    }
                });
    }
}
