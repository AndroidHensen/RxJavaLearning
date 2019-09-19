package com.hensen.rxjavalearning.Chapter3.Chapter3o7;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;

/**
 * Created by handsomexu on 2018/4/9.
 */

public class All {

    public static void main(String[] args) {
        Observable.just(1, 2, 3, 4, 5)
                .all(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Exception {
                        return integer > 0;
                    }
                })
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        System.out.println("onNext=" + aBoolean);
                    }
                });
    }
}
