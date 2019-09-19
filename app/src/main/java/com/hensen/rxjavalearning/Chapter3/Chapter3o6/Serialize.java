package com.hensen.rxjavalearning.Chapter3.Chapter3o6;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * Created by handsomexu on 2018/4/9.
 */

public class Serialize {

    public static void main(String[] args) {
        Observable.just(1, 2, 3, 4, 5).serialize()
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        System.out.println("onNext=" + integer);
                    }
                });
    }
}
