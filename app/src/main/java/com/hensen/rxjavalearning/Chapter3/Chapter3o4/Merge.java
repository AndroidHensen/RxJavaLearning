package com.hensen.rxjavalearning.Chapter3.Chapter3o4;

import java.io.Serializable;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * Created by handsomexu on 2018/4/11.
 */

public class Merge {

    public static void main(String[] args) {
        Observable<String> just1 = Observable.just("A", "B", "C", "D", "E");
        Observable<String> just2 = Observable.just("1", "2", "3", "4", "5");

        Observable.merge(just1, just2).subscribe(new Consumer<Serializable>() {
            @Override
            public void accept(Serializable serializable) throws Exception {
                System.out.println("onNext=" + serializable.toString());
            }
        });
    }
}
