package com.hensen.rxjavalearning.Chapter3.Chapter3o2;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by handsomexu on 2018/4/11.
 */

public class Map {

    public static void main(String[] args) {
        Observable.just(1).map(new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) throws Exception {
                return "发送过来的数据会被变成字符串" + integer;
            }
        })
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        System.out.println("onNext=" + s);
                    }
                });
    }
}
