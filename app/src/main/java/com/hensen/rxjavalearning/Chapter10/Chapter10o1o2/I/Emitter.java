package com.hensen.rxjavalearning.Chapter10.Chapter10o1o2.I;

/**
 * Created by handsomexu on 2018/6/30.
 */

public interface Emitter<T> {
    void onNext(T t);
    void onError();
}
