package com.hensen.rxjavalearning.Chapter9.Chapter9o4;

import com.hensen.rxjavalearning.Chapter9.Chapter9o4.MVP.MvpView;

/**
 * Created by handsomexu on 2018/7/21.
 */

interface CustomView extends MvpView {

    void onLoading(String text);

    void onRefreshData(String text);

    void onError(String text);

    void onComplete(String text);
}

