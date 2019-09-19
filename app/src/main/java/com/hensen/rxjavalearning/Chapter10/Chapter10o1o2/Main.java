package com.hensen.rxjavalearning.Chapter10.Chapter10o1o2;

import com.hensen.rxjavalearning.Chapter10.Chapter10o1o2.I.Emitter;
import com.hensen.rxjavalearning.Chapter10.Chapter10o1o2.I.ObservableOnSubscribe;
import com.hensen.rxjavalearning.Chapter10.Chapter10o1o2.I.Observer;

/**
 * Created by handsomexu on 2018/6/30.
 */

public class Main {

    public static void main(String[] args) {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(Emitter<String> emitter) {
                emitter.onNext("Hello RxJava");
                emitter.onError();
                emitter.onNext("Hello RxJava");
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe() {

            }

            @Override
            public void onNext(String string) {
                System.out.println("onNext=" + string);
            }

            @Override
            public void onError() {
                System.out.println("onError");
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
