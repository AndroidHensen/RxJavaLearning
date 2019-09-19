package com.hensen.rxjavalearning.Chapter3.Chapter3o9;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.observables.ConnectableObservable;

/**
 * Created by handsomexu on 2018/4/9.
 */

public class Connect {

    public static void main(String[] args) {
        ConnectableObservable<Integer> connectableObservable = Observable.just(1, 2, 3, 4, 5).publish();

        connectableObservable.subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                System.out.println("onNext=" + integer);
            }
        });

        connectableObservable.connect();
    }
}
