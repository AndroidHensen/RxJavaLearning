package com.hensen.rxjavalearning.Chapter4;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableOnSubscribe;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Maybe;
import io.reactivex.MaybeEmitter;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleObserver;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by handsomexu on 2018/4/8.
 */

public class Main {


    public static void main(String[] args) {
        maybe();
    }

    public static void observable() {
        //创建被观察者
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            //默认在主线程里执行该方法
            public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {
                e.onNext("俊俊俊很帅");
                e.onNext("你值得拥有");
                e.onNext("取消关注");
                e.onNext("但还是要保持微笑");
                e.onComplete();
            }
        })
                //将被观察者切换到子线程
                .subscribeOn(Schedulers.io())
                //将观察者切换到主线程  需要在Android环境下运行
                //.observeOn(AndroidSchedulers.mainThread())
                //创建观察者并订阅
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
                        System.out.println("onError=" + e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete");
                    }
                });
    }

    public static void flowable() {
        //创建被观察者
        Flowable.create(new FlowableOnSubscribe<String>() {
            @Override
            public void subscribe(FlowableEmitter<String> e) throws Exception {
                e.onNext("俊俊俊很帅");
                e.onNext("你值得拥有");
                e.onNext("取消关注");
                e.onNext("但还是要保持微笑");
                e.onComplete();
            }
        }, BackpressureStrategy.DROP)
                //将被观察者切换到子线程
                .subscribeOn(Schedulers.io())
                //将观察者切换到主线程  需要在Android环境下运行
                //.observeOn(AndroidSchedulers.mainThread())
                //创建观察者并订阅
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        s.request(2);
                    }

                    @Override
                    public void onNext(String s) {
                        System.out.println("onNext=" + s);
                    }

                    @Override
                    public void onError(Throwable t) {
                        System.out.println("onError=" + t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete");
                    }
                });
    }

    public static void single() {
        //创建被观察者
        Single.create(new SingleOnSubscribe<String>() {
            @Override
            public void subscribe(SingleEmitter<String> e) throws Exception {
                e.onSuccess("success");
            }
        })
                //将被观察者切换到子线程
                .subscribeOn(Schedulers.io())
                //将观察者切换到主线程  需要在Android环境下运行
                //.observeOn(AndroidSchedulers.mainThread())
                //创建观察者并订阅
                .subscribe(new SingleObserver<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(String s) {
                        System.out.println("onSuccess=" + s);
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("onError=" + e.getMessage());
                    }
                });
    }

    public static void completable() {
        //创建被观察者
        Completable.create(new CompletableOnSubscribe() {
            @Override
            public void subscribe(CompletableEmitter e) throws Exception {
                e.onComplete();
            }
        })
                //将被观察者切换到子线程
                .subscribeOn(Schedulers.io())
                //将观察者切换到主线程  需要在Android环境下运行
                //.observeOn(AndroidSchedulers.mainThread())
                //创建观察者并订阅
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete");

                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("onError=" + e.getMessage());
                    }
                });
    }

    public static void maybe() {
        //创建被观察者
        Maybe.create(new MaybeOnSubscribe<String>() {
            @Override
            public void subscribe(MaybeEmitter<String> e) throws Exception {
                e.onSuccess("success");
                e.onComplete();
            }
        })
                //将被观察者切换到子线程
                .subscribeOn(Schedulers.io())
                //将观察者切换到主线程  需要在Android环境下运行
                //.observeOn(AndroidSchedulers.mainThread())
                //创建观察者并订阅
                .subscribe(new MaybeObserver<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(String s) {
                        System.out.println("onSuccess=" + s);
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("onError=" + e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete");
                    }
                });
    }
}
