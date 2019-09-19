package com.hensen.rxjavalearning.Chapter9.Chapter9o1o2o3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.hensen.rxjavalearning.Chapter9.Chapter9o4.RealView;
import com.hensen.rxjavalearning.R;
import com.jakewharton.rxbinding2.widget.RxTextView;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main2Activity extends RxAppCompatActivity {

    private EditText editText;
    private TextView textView;
    private TextView textView2;
    private TextView textView3;
    ApiService apiService;

    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        editText = findViewById(R.id.edittext);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);

        rxbinding();
        rxlifecycle();
    }

    public void retrofit(View view) {
        //构建Retrofit
        apiService = new Retrofit.Builder()
                .baseUrl("http://172.26.83.19/")
                //rx与Gson混用
                .addConverterFactory(GsonConverterFactory.create())
                //rx与retrofit混用
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class);

        //构建RxJava
        UserParam param = new UserParam("hensen", "123456");
        //发送param参数
        Observable.just(param)
                .flatMap(new Function<UserParam, ObservableSource<UserInfo>>() {
                    @Override
                    public ObservableSource<UserInfo> apply(@NonNull UserParam userParam) throws Exception {
                        return apiService.getUserInfo(userParam.param1, userParam.param2);
                    }
                })
                .flatMap(new Function<UserInfo, ObservableSource<VipInfo>>() {
                    @Override
                    public ObservableSource<VipInfo> apply(@NonNull UserInfo userInfo) throws Exception {
                        return apiService.getVipInfo(userInfo.uid);
                    }
                })
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<VipInfo>() {
                    @Override
                    public void accept(@NonNull VipInfo vipInfo) throws Exception {
                        textView.setText("会员等级：" + vipInfo.vipLevel + "--会员积分：" + vipInfo.vipScore);
                    }
                });
    }

    class UserInfo {
        public String success;
        public String uid;
        public String username;
        public String password;
        public String nikename;
    }

    class VipInfo {
        public String success;
        public String uid;
        public String vipLevel;
        public String vipScore;
    }

    class UserParam {
        public String param1;
        public String param2;

        public UserParam(String param1, String param2) {
            this.param1 = param1;
            this.param2 = param2;
        }
    }


    public void rxbinding() {
        RxTextView.textChanges(editText)
                //当你敲完字之后停下来的半秒就会执行下面语句
                .debounce(500, TimeUnit.MILLISECONDS)
                //下面这两个都是数据转换
                //flatMap：当同时多个网络请求访问的时候，前面的网络数据会覆盖后面的网络数据
                //switchMap：当同时多个网络请求访问的时候，会以最后一个发送请求为准，前面网路数据会被最后一个覆盖
                .switchMap(new Function<CharSequence, ObservableSource<List<String>>>() {
                    @Override
                    public ObservableSource<List<String>> apply(@NonNull CharSequence charSequence) throws Exception {
                        //网络操作，获取我们需要的数据
                        List<String> list = new ArrayList<String>();
                        list.add("输入文本变化时，请求网络次数：" + ++i);
                        return Observable.just(list);
                    }
                })
                //网络请求是在子线程的
                .subscribeOn(Schedulers.io())
                //界面更新在主线程
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<String>>() {
                    @Override
                    public void accept(@NonNull List<String> strings) throws Exception {
                        //界面更新
                        textView2.setText(strings.toString());
                    }
                });
    }

    public void rxlifecycle() {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                for (int j = 0; j < 20; j++) {
                    Thread.sleep(2000);
                    emitter.onNext("rxlifecycle " + j);
                }
            }
        })
                .compose(this.bindUntilEvent(ActivityEvent.PAUSE))
                //网络请求是在子线程的
                .subscribeOn(Schedulers.io())
                //界面更新在主线程
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(@NonNull Object strings) throws Exception {
                        //界面更新
                        textView3.setText(strings.toString());
                    }
                });
    }

    public void rxlifeCycle(View view) {
        startActivity(new Intent(this, Main3Activity.class));
    }

    public void rxmvp(View view) {
        startActivity(new Intent(this, RealView.class));
    }
}
