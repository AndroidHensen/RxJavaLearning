package com.hensen.rxjavalearning.Chapter3.Chapter3o3;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * Created by handsomexu on 2018/4/11.
 */

public class Take {

    public static void main(String[] args) {
        Observable.just(1, 2, 3, 4, 5, 6, 7, 8)
                .take(3)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer i) throws Exception {
                        System.out.println("onNext=" + i);
                    }
                });
    }
}
