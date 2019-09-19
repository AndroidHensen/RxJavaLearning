package com.hensen.rxjavalearning.Chapter8;

import android.util.Log;
import android.view.View;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.AsyncSubject;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;

/**
 * Created by handsomexu on 2018/10/6.
 */

public class Subject {

    static class SubjectObserver<T extends String> implements Observer<String> {

        String name;

        public SubjectObserver(String name) {
            this.name = name;
        }

        @Override
        public void onError(Throwable e) {
            System.out.println("onError " + e.getStackTrace());
        }

        @Override
        public void onComplete() {
            System.out.println(name + " onComplete");
        }

        @Override
        public void onSubscribe(Disposable d) {

        }

        @Override
        public void onNext(java.lang.String s) {
            System.out.println(name + " onNext=" + s);
        }
    }


    public static void publishSubject() {
        PublishSubject publishSubject = PublishSubject.create();
        publishSubject.subscribe(new SubjectObserver<>("first"));
        publishSubject.onNext("1");
        publishSubject.onNext("2");
        publishSubject.subscribe(new SubjectObserver<>("seconde"));
        publishSubject.onNext("3");
        publishSubject.onComplete();
    }


    public static void behaviorSubject(View view) {
        BehaviorSubject<String> behaviorSubject = BehaviorSubject.createDefault("默认值");
        behaviorSubject.subscribe(new SubjectObserver<String>("first"));
        behaviorSubject.onNext("1");
        behaviorSubject.onNext("2");
        behaviorSubject.subscribe(new SubjectObserver<String>("seconde"));
        behaviorSubject.onNext("3");
        behaviorSubject.onComplete();
    }

    public static void replaySubject(View view) {
        ReplaySubject<String> replaySubject = ReplaySubject.create();
        replaySubject.subscribe(new SubjectObserver<>("first"));
        replaySubject.onNext("1");
        replaySubject.onNext("2");
        replaySubject.subscribe(new SubjectObserver<>("seconde"));
        replaySubject.onNext("3");
        replaySubject.onComplete();
    }

    public static void asyncSubject(View view) {
        AsyncSubject asyncSubject = AsyncSubject.create();
        asyncSubject.subscribe(new SubjectObserver<String>("first"));
        asyncSubject.onNext("1");
        asyncSubject.onNext("2");
        asyncSubject.onNext("3");
        asyncSubject.onComplete();
        asyncSubject.subscribe(new SubjectObserver<String>("seconde"));
        asyncSubject.onComplete();
    }

    public static void transpondData(View view){
        //组件A
        Observable<String> observable = Observable.fromArray("123","456","789");
        ReplaySubject<String> replaySubject = ReplaySubject.create();

        observable.subscribe(replaySubject);
        replaySubject.subscribe(new SubjectObserver<>("B"));//组件B
    }

}
