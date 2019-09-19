package com.hensen.rxjavalearning.Chapter3.Chapter3o7;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * Created by handsomexu on 2018/4/9.
 */

public class Amb {

    public static void main(String[] args) {

        List<Observable<Integer>> list = new ArrayList<>();
        list.add(Observable.just(1, 2, 3).delay(1, TimeUnit.SECONDS));
        list.add(Observable.just(4, 5, 6).delay(2, TimeUnit.SECONDS));
        list.add(Observable.just(7, 8, 9).delay(3, TimeUnit.SECONDS));

        Observable.amb(list)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        System.out.println("onNext=" + integer);
                    }
                });
    }
}
