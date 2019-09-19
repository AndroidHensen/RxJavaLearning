package com.hensen.rxjavalearning.Chapter3.Chapter3o4;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * Created by handsomexu on 2018/4/11.
 */

public class StartWith {

    public static void main(String[] args) {
        Observable<String> just1 = Observable.just("A", "B", "C", "D", "E");
        Observable<String> just2 = Observable.just("1", "2", "3", "4", "5");

        just1.startWith(just2).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println("onNext=" + s);
            }
        });
    }
}
