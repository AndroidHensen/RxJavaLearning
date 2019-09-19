package com.hensen.rxjavalearning.Chapter3.Chapter3o3;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * Created by handsomexu on 2018/4/11.
 */

public class Distinct {

    public static void main(String[] args) {
        Observable.just(1, 2, 3, 4, 1, 2, 3).distinct()
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        System.out.println("onNext=" + integer);
                    }
                });
    }
}
