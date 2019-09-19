package com.hensen.rxjavalearning.Chapter7.Chapter7o3;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.plugins.RxJavaPlugins;

/**
 * Created by handsomexu on 2018/7/4.
 */

public class Main {

    public static void main(String[] args) {

        RxJavaPlugins.setOnObservableAssembly(new CustomObservableAssembly());
        RxJavaPlugins.setOnObservableSubscribe(new CustomObservableSubscribe());

        Observable observable = getObservable();
        Observer<Integer> observer = getObserver();

        System.out.println("main observable.toString:" + observable.toString());
        System.out.println("main observer.toString:" + observer.toString());

        observable.subscribe(observer);
    }

    public static Observable getObservable() {
        return Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(5);
                emitter.onNext(2);
                emitter.onNext(3);
            }
        });
    }

    public static Observer<Integer> getObserver() {
        return new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("onNext=" + integer);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println(e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        };
    }
}
