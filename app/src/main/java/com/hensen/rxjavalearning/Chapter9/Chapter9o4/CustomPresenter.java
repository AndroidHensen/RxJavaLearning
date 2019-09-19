package com.hensen.rxjavalearning.Chapter9.Chapter9o4;

import com.hensen.rxjavalearning.Chapter9.Chapter9o4.MVP.MvpPresenter;

/**
 * Created by handsomexu on 2018/7/23.
 */

public abstract class CustomPresenter extends MvpPresenter<CustomView> {

    public CustomPresenter() {
        super();
    }

    abstract void loadData();
}
