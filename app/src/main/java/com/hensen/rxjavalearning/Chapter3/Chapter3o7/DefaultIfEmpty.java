package com.hensen.rxjavalearning.Chapter3.Chapter3o7;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * Created by handsomexu on 2018/4/9.
 */

public class DefaultIfEmpty {

    public static void main(String[] args) {
        Observable.empty()
                .defaultIfEmpty(-1)
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        System.out.println("onNext=" + o.toString());
                    }
                });
    }
}
