package com.hensen.rxjavalearning.Chapter3.Chapter3o6;

import io.reactivex.Notification;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * Created by handsomexu on 2018/4/9.
 */

public class Materialize {

    public static void main(String[] args) {
        Observable.just(1, 2, 3, 4, 5).materialize()
                .subscribe(new Consumer<Notification<Integer>>() {
                    @Override
                    public void accept(Notification<Integer> integerNotification) throws Exception {
                        System.out.println("onNext=" + integerNotification.getValue());
                    }
                });

        Observable.just(1, 2, 3, 4, 5).materialize().dematerialize()
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object object) throws Exception {
                        System.out.println("onNext=" + object.toString());
                    }
                });
    }
}
