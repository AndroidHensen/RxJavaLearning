package com.hensen.rxjavalearning.Chapter3.Chapter3o8;

import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;

/**
 * Created by handsomexu on 2018/4/11.
 */

public class Reduce {

    public static void main(String[] args) {
        Observable.just(8, 2, 13, 1, 15).reduce(new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) throws Exception {
                return integer < integer2 ? integer : integer2;
            }
        })
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer item) throws Exception {
                        System.out.println("onNext=" + item);
                    }
                });
    }
}
