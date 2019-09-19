package com.hensen.rxjavalearning.Chapter2.Chapter2o3;


import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * Created by handsomexu on 2018/4/8.
 */

public class Main {


    public static void main(String[] args) {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {
                e.onNext("俊俊俊很帅");
                e.onNext("你值得拥有");
                e.onNext("取消关注");
                e.onNext("但还是要保持微笑");
                e.onComplete();
            }
        }).subscribe(
                new Consumer<String>() {
                    @Override
                    public void accept(@NonNull String s) throws Exception {
                        //对应onNext()
                        System.out.println("accept=" + s);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        //对应onError()
                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {
                        //对应onComplete()
                    }
                }, new Consumer<Disposable>() {
                    @Override
                    public void accept(@NonNull Disposable disposable) throws Exception {
                        //对应onSubscribe()
                    }
                });
    }
}
