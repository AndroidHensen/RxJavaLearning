package com.hensen.rxjavalearning.Chapter3.Chapter3o2;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * Created by handsomexu on 2018/4/11.
 */

public class Buffer {
    public static void main(String[] args) {

        Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .buffer(5).subscribe(new Consumer<List<Integer>>() {
            @Override
            public void accept(List<Integer> integers) throws Exception {
                System.out.println("onNext=" + integers.toString());
            }
        });

        Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .buffer(5, 1).subscribe(new Consumer<List<Integer>>() {
            @Override
            public void accept(List<Integer> integers) throws Exception {
                System.out.println("onNext=" + integers.toString());
            }
        });

    }
}
