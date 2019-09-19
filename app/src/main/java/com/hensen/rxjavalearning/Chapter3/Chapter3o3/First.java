package com.hensen.rxjavalearning.Chapter3.Chapter3o3;

import io.reactivex.Observable;
import io.reactivex.functions.Action;

/**
 * Created by handsomexu on 2018/4/11.
 */

public class First {

    public static void main(String[] args) {
        Observable.just(1, 2, 3, 4, 1, 2, 3)
                .ignoreElements()
                .subscribe(new Action() {
                    @Override
                    public void run() throws Exception {
                        System.out.println("onComplete");
                    }
                });
    }
}
