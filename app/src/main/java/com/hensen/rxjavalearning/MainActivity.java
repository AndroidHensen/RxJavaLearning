package com.hensen.rxjavalearning;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hensen.rxjavalearning.Chapter3.Chapter3o1.Interval;
import com.hensen.rxjavalearning.Chapter3.Chapter3o1.Timer;
import com.hensen.rxjavalearning.Chapter3.Chapter3o2.FlatMap;
import com.hensen.rxjavalearning.Chapter3.Chapter3o3.Sample;
import com.hensen.rxjavalearning.Chapter3.Chapter3o4.CombineLatest;
import com.hensen.rxjavalearning.Chapter3.Chapter3o4.Join;
import com.hensen.rxjavalearning.Chapter3.Chapter3o5.RetryWhen;
import com.hensen.rxjavalearning.Chapter3.Chapter3o6.Deley;
import com.hensen.rxjavalearning.Chapter3.Chapter3o6.TimeInterval;
import com.hensen.rxjavalearning.Chapter3.Chapter3o6.TimeOut;
import com.hensen.rxjavalearning.Chapter3.Chapter3o6.TimeStamp;
import com.hensen.rxjavalearning.Chapter3.Chapter3o7.Amb;
import com.hensen.rxjavalearning.Chapter3.Chapter3o7.SkipUntil;
import com.hensen.rxjavalearning.Chapter3.Chapter3o7.TakeUntil;
import com.hensen.rxjavalearning.Chapter3.Chapter3o9.Replay;
import com.hensen.rxjavalearning.Chapter4.Main;
import com.hensen.rxjavalearning.Chapter5.Buffer;
import com.hensen.rxjavalearning.Chapter5.Drop;
import com.hensen.rxjavalearning.Chapter5.Error;
import com.hensen.rxjavalearning.Chapter5.Latest;
import com.hensen.rxjavalearning.Chapter5.Missing;
import com.hensen.rxjavalearning.Chapter6.Chapter6o1.Verify;
import com.hensen.rxjavalearning.Chapter6.Chapter6o2.RxUtils;
import com.hensen.rxjavalearning.Chapter6.Chapter6o3.Vip;
import com.hensen.rxjavalearning.Chapter8.Subject;
import com.hensen.rxjavalearning.Chapter9.Chapter9o1o2o3.Main2Activity;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        map();
    }

    //***************************************
    //*
    //* 3章：操作符
    //*
    //***************************************
    public void interval(View view) {
        Interval.main(null);
    }

    public void timer(View view) {
        Timer.main(null);
    }

    public void flatMap(View view) {
        FlatMap.main(null);
    }

    public void sample(View view) {
        Sample.main(null);
    }

    public void join(View view) {
        Join.main(null);
    }

    public void combineLatest(View view) {
        CombineLatest.main(null);
    }

    public void retryWhen(View view) {
        RetryWhen.main(null);
    }

    public void deley(View view) {
        Deley.main(null);
    }

    public void timeInterval(View view) {
        TimeInterval.main(null);
    }

    public void timeOut(View view) {
        TimeOut.main(null);
    }

    public void timeStamp(View view) {
        TimeStamp.main(null);
    }

    public void amb(View view) {
        Amb.main(null);
    }

    public void skipUntil(View view) {
        SkipUntil.main(null);
    }

    public void takeUntil(View view) {
        TakeUntil.main(null);
    }

    public void replay(View view) {
        Replay.main(null);
    }

    //***************************************
    //*
    //* 4章：背压策略
    //*
    //***************************************
    public void observable(View view) {
        Main.observable();
    }

    public void flowable(View view) {
        Main.flowable();
    }

    public void single(View view) {
        Main.single();
    }

    public void completable(View view) {
        Main.completable();
    }

    public void maybe(View view) {
        Main.maybe();
    }

    //***************************************
    //*
    //* 5章：背压策略
    //*
    //***************************************
    public void missing(View view) {
        Missing.missing(view);
    }

    public void error(View view) {
        Error.error(view);
    }

    public void buffer(View view) {
        Buffer.buffer(view);
    }

    public void drop(View view) {
        Drop.drop(view);
    }

    public void latest(View view) {
        Latest.latest(view);
    }

    //***************************************
    //*
    //* 6章：RxJava基础实战
    //*
    //***************************************
    public void verify(View view) {
        Verify.verify(view);
    }

    public void query(View view) {
        RxUtils.query(view);
    }

    public void vip(View view) {
        Vip.vip(view);
    }

    //***************************************
    //*
    //* 8章：RxJava高级用法（二）
    //*
    //***************************************
    public void publishSubject(View view) {
        Subject.publishSubject();
    }

    public void behaviorSubject(View view) {
        Subject.behaviorSubject(view);
    }

    public void replaySubject(View view) {
        Subject.replaySubject(view);
    }

    public void asyncSubject(View view) {
        Subject.asyncSubject(view);
    }

    public void transpondData(View view) {
        Subject.transpondData(view);
    }

    //***************************************
    //*
    //* 9章：RxJava混合实战
    //*
    //***************************************
    public void main2(View view) {
        startActivity(new Intent(this, Main2Activity.class));
    }

    //***************************************
    //*
    //* 10章：源码分析
    //*
    //***************************************
    public void map() {
        //创建被观察者
        Observable
                .create(new ObservableOnSubscribe<String>() {
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
                .map(new Function<String, String>() {
                    @Override
                    public String apply(String s) throws Exception {
                        return "Hello";
                    }
                })
                //将被观察者切换到子线程
                .subscribeOn(Schedulers.io())
                //将观察者切换到主线程  需要在Android环境下运行
                .observeOn(AndroidSchedulers.mainThread())
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
                        System.out.println("onNext=" + e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
