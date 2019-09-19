package com.hensen.rxjavalearning.Chapter7.Chapter7o3;

import android.util.Log;

import io.reactivex.functions.Consumer;
import rx.plugins.RxJavaErrorHandler;

/**
 * Created by handsomexu on 2018/10/6.
 */

public class CustomErrorHandler implements Consumer<Throwable> {

    @Override
    public void accept(Throwable throwable) throws Exception {
        System.out.println("accept Error");
    }
}
