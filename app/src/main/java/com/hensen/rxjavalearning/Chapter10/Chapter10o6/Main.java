package com.hensen.rxjavalearning.Chapter10.Chapter10o6;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by handsomexu on 2018/7/3.
 */

public class Main {
    public static void main(String[] args) {
        //创建被观察者
        Observable.create(new ObservableOnSubscribe<List<String>>() {
            @Override
            //默认在主线程里执行该方法
            public void subscribe(@NonNull ObservableEmitter<List<String>> e) throws Exception {
                ArrayList<String> list = new ArrayList<>();
                list.add("1");
                list.add("2");
                list.add("3");
                list.add("4");
                e.onNext(list);
                e.onComplete();
            }
        })
                .lift(new CustomOperator())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {
                        System.out.println("onNext=" + s);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete");
                    }
                });
    }
}
