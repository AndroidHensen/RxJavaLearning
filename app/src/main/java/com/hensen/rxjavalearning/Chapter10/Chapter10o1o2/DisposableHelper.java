package com.hensen.rxjavalearning.Chapter10.Chapter10o1o2;

import com.hensen.rxjavalearning.Chapter10.Chapter10o1o2.I.Disposable;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by handsomexu on 2018/6/30.
 */

public enum DisposableHelper implements Disposable {

    DISPOSED;

    public static boolean isDisposed(Disposable disposable) {
        return DISPOSED == disposable;
    }

    public static boolean dispose(AtomicReference<Disposable> field) {
        Disposable current = field.get();
        Disposable d = DISPOSED;
        if (current != d) {
            current = field.getAndSet(d);
            if (current != d) {
                if (current != null) {
                    current.dispose();
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public void dispose() {

    }

    @Override
    public boolean isDisposed() {
        return true;
    }
}
