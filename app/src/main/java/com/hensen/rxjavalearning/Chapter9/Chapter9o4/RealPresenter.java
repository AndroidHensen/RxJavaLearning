package com.hensen.rxjavalearning.Chapter9.Chapter9o4;


import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by handsomexu on 2018/7/21.
 */

public class RealPresenter extends CustomPresenter {

    @Override
    void loadData() {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                e.onNext("俊俊俊很帅");
                e.onNext("你值得拥有");
                e.onNext("取消关注");
                e.onNext("但还是要保持微笑");
                e.onComplete();
            }
        })
                .subscribeOn(Schedulers.io())
                //将观察者切换到主线程  需要在Android环境下运行
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                               @Override
                               public void onSubscribe(Disposable d) {
                                   mView.onLoading("正在加载中...... \n");
                               }

                               @Override
                               public void onNext(String s) {
                                   try {
                                       Thread.sleep(200); //模拟网络访问
                                   } catch (InterruptedException e) {
                                       e.printStackTrace();
                                   }
                                   mView.onRefreshData("从网络上获取数据：" + s + "\n");
                               }

                               @Override
                               public void onError(Throwable t) {
                                   mView.onError(t.getMessage());
                               }

                               @Override
                               public void onComplete() {
                                   mView.onComplete("加载完成...... \n");
                               }
                           }
                );

    }
}
