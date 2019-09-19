package com.hensen.rxjavalearning.Chapter6.Chapter6o1;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by handsomexu on 2018/10/4.
 */

public class Verify {

    public static void verify(View view) {
        final long count = 3;//倒计时时间
        final Button button = (Button) view;//当前按钮

        Observable.interval(0, 1, TimeUnit.SECONDS)//定时器
                .take(count + 1)//取定时器前4个，当前值：0，1，2，3
                .map(new Function<Long, Long>() {
                    @Override
                    public Long apply(@NonNull Long aLong) throws Exception {
                        return count - aLong;//将值转换下，当前值：3，2，1，0
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())//主线程更新UI
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(@NonNull Disposable disposable) throws Exception {
                        //监听订阅时，将按钮设置为不可点击
                        button.setEnabled(false);
                        button.setTextColor(Color.BLACK);
                    }
                })
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(Long aLong) {
                        //设置倒计时文本
                        button.setText("剩余" + aLong + "秒");
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {
                        //事件完成后恢复点击
                        button.setEnabled(true);
                        button.setText("发送验证码");
                    }
                });
    }

}
