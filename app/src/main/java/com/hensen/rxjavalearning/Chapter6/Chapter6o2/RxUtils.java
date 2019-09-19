package com.hensen.rxjavalearning.Chapter6.Chapter6o2;

import android.view.View;

import java.net.PortUnreachableException;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by handsomexu on 2018/10/4.
 */

public class RxUtils {

    public static void query(View view) {
        RxUtils.click1(view, 2)
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Object o) {
                        System.out.println("onNext");
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete");
                    }
                });

        RxUtils.click2(view, 2)
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Object o) {
                        System.out.println("onNext");
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

    public static Observable<Object> click1(final View view, long seconds) {
        return new ViewClickObservable(view)
                .throttleFirst(seconds, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnDispose(new Action() {
                                 @Override
                                 public void run() throws Exception {
                                     if (view != null) {
                                         view.setOnClickListener(null);
                                     }
                                 }
                             }
                );
    }

    public static Observable<Object> click2(final View view, long seconds) {
        final ViewClickObservableOnSubscribe viewClickObservableOnSubscribe = new ViewClickObservableOnSubscribe();

        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ObservableEmitter<Object> emitter = viewClickObservableOnSubscribe.getEmitter();
                    if (emitter != null && !emitter.isDisposed()) {
                        emitter.onNext(1);
                    }
                }
            });
        }

        return Observable
                .create(viewClickObservableOnSubscribe)
                .throttleFirst(seconds, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnDispose(new Action() {
                                 @Override
                                 public void run() throws Exception {
                                     if (view != null) {
                                         view.setOnClickListener(null);
                                     }
                                 }
                             }
                );
    }

    //创建一个观察者
    static class ViewClickObservable extends Observable<Object> {

        private View view;

        public ViewClickObservable(View view) {
            this.view = view;
        }

        //当这个观察者被订阅的时候，会执行下面的回调
        @Override
        protected void subscribeActual(final Observer<? super Object> observer) {
            if (view != null) {
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        observer.onNext(v);
                    }
                });
            }
        }
    }

    static class ViewClickObservableOnSubscribe implements ObservableOnSubscribe<Object> {

        private ObservableEmitter<Object> emitter;

        public ObservableEmitter<Object> getEmitter() {
            return emitter;
        }

        @Override
        public void subscribe(ObservableEmitter<Object> e) throws Exception {
            this.emitter = e;
        }
    }
}
