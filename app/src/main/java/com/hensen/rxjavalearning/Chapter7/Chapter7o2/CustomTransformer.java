package com.hensen.rxjavalearning.Chapter7.Chapter7o2;

import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by handsomexu on 2018/7/3.
 */

public class CustomTransformer implements ObservableTransformer<Integer, String> {
    @Override
    public ObservableSource<String> apply(io.reactivex.Observable<Integer> upstream) {
        return upstream.take(2).map(new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) throws Exception {
                return "序号：" + integer + "发射成功";
            }
        }).doOnNext(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println(s + "，准备发射");
            }
        });
    }
}
