package com.hensen.rxjavalearning.Chapter10.Chapter10o1o2;

import com.hensen.rxjavalearning.Chapter10.Chapter10o1o2.I.Disposable;
import com.hensen.rxjavalearning.Chapter10.Chapter10o1o2.I.Emitter;
import com.hensen.rxjavalearning.Chapter10.Chapter10o1o2.I.ObservableOnSubscribe;
import com.hensen.rxjavalearning.Chapter10.Chapter10o1o2.I.Observer;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by handsomexu on 2018/6/30.
 */

public abstract class Observable<T> {

    public static <T> ObservableCreate create(ObservableOnSubscribe<T> observableOnSubscribe) {
        return new ObservableCreate<T>(observableOnSubscribe);
    }

    public void subscribe(Observer<T> observer) {
        subscribeActual(observer);
    }

    public abstract void subscribeActual(Observer<T> observer);
}
