package com.hensen.rxjavalearning.Chapter9.Chapter9o4;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.hensen.rxjavalearning.Chapter9.Chapter9o4.MVP.MvpActivity;
import com.hensen.rxjavalearning.R;

public class RealView extends MvpActivity<RealPresenter> implements CustomView {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real_view);
        textView = findViewById(R.id.textView);
    }

    @Override
    protected RealPresenter createPresenter() {
        return new RealPresenter();
    }

    @Override
    public void onLoading(String text) {
        textView.append(text);
    }

    @Override
    public void onRefreshData(String text) {
        textView.append(text);
    }

    @Override
    public void onError(String text) {
        textView.append(text);
    }

    @Override
    public void onComplete(String text) {
        textView.append(text);
    }

    public void bt_get_data(View view) {
        presenter.loadData();
    }
}
