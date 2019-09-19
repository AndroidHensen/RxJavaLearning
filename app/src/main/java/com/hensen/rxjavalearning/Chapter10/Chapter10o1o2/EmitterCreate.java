package com.hensen.rxjavalearning.Chapter10.Chapter10o1o2;

import com.hensen.rxjavalearning.Chapter10.Chapter10o1o2.I.Disposable;
import com.hensen.rxjavalearning.Chapter10.Chapter10o1o2.I.Emitter;
import com.hensen.rxjavalearning.Chapter10.Chapter10o1o2.I.Observer;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by handsomexu on 2018/10/8.
 */

public class EmitterCreate<T>
        extends AtomicReference<Disposable>
        implements Emitter<T>, Disposable {

    private Observer<T> observer;

    public EmitterCreate(Observer<T> observer) {
        this.observer = observer;
    }

    @Override
    public void onNext(T t) {
        if (!isDisposed()) {
            observer.onNext(t);
        }
    }

    @Override
    public void onError() {
        if (!isDisposed()) {
            try {
                observer.onError();
            } finally {
                dispose();
            }
        }
    }

    @Override
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }
}