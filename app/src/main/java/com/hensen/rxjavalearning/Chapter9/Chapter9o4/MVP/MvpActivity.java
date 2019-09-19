package com.hensen.rxjavalearning.Chapter9.Chapter9o4.MVP;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hensen.rxjavalearning.R;

public abstract class MvpActivity<P extends MvpPresenter> extends AppCompatActivity implements MvpView {

    protected P presenter;

    protected abstract P createPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);

        presenter = createPresenter();
        if (presenter != null) {
            presenter.attach(this);
            presenter.onCreate(savedInstanceState);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (presenter != null) {
            presenter.onStart();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (presenter != null) {
            presenter.onResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (presenter != null) {
            presenter.onPause();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (presenter != null) {
            presenter.onStop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.onDestroy();
        }
    }
}
