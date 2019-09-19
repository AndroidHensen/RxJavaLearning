package com.hensen.rxjavalearning.Chapter3.Chapter3o7;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * Created by handsomexu on 2018/4/9.
 */

public class Contains {

    public static void main(String[] args) {
        Observable.just(1, 2, 3, 4, 5)
                .contains(2)
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        System.out.println("onNext=" + aBoolean);
                    }
                });
    }
}
