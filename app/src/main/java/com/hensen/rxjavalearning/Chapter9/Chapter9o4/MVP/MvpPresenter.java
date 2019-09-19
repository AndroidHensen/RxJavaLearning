package com.hensen.rxjavalearning.Chapter9.Chapter9o4.MVP;

import android.os.Bundle;
import android.util.Log;

/**
 * 具有生命周期的P层
 * Created by handsomexu on 2018/7/20.
 */

public abstract class MvpPresenter<T extends MvpView> {

    public static final String TAG = "MvpPresenter";

    public T mView;

    public void attach(T view) {
        mView = view;
    }

    /**
     * 对应 activity/fragment onCreate
     */
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate");
    }

    /**
     * 对应 activity/fragment onStart
     */
    protected void onStart() {
        Log.i(TAG, "onStart");
    }

    /**
     * 对应 activity/fragment onResume
     */
    protected void onResume() {
        Log.i(TAG, "onResume");
    }

    /**
     * 对应 activity/fragment onPause
     */
    protected void onPause() {
        Log.i(TAG, "onPause");
    }

    /**
     * 对应 activity/fragment onStop
     */
    protected void onStop() {
        Log.i(TAG, "onStop");
    }

    /**
     * 对应 activity/fragment onDestroy
     */
    protected void onDestroy() {
        Log.i(TAG, "onDestroy");
        if (mView != null) {
            mView = null;
        }
    }
}
