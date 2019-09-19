package com.hensen.rxjavalearning.Chapter7.Chapter7o1;

import java.util.List;

import io.reactivex.ObservableOperator;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by handsomexu on 2018/7/3.
 */

public class CustomOperator implements ObservableOperator<String, List<String>> {

    @Override
    public Observer<? super List<String>> apply(final Observer<? super String> observer) throws Exception {
        return new Observer<List<String>>() {
            @Override
            public void onSubscribe(Disposable d) {
                observer.onSubscribe(d);
            }

            @Override
            public void onNext(List<String> strings) {
                observer.onNext(strings.toString());
            }

            @Override
            public void onError(Throwable e) {
                observer.onError(e);
            }

            @Override
            public void onComplete() {
                observer.onComplete();
            }
        };
    }
}
