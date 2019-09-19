package com.hensen.rxjavalearning.Chapter3.Chapter3o6;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * Created by handsomexu on 2018/4/9.
 */

public class To {

    public static void main(String[] args) {
        Observable.just(1, 2, 3, 4, 5).toList()
                .subscribe(new Consumer<List<Integer>>() {
                    @Override
                    public void accept(List<Integer> integers) throws Exception {
                        System.out.println("onNext=" + integers.toString());
                    }
                });
    }
}
