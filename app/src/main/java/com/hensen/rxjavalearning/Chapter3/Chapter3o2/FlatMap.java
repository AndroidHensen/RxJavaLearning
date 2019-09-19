package com.hensen.rxjavalearning.Chapter3.Chapter3o2;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by handsomexu on 2018/4/11.
 */

public class FlatMap {

    public static class UserParams {

        public UserParams(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String username;
        public String password;
    }

    public static void main(String[] args) {
        Observable.just(new UserParams("hensen", "123456")).flatMap(new Function<UserParams, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(UserParams userParams) throws Exception {
                return Observable.just(userParams.username + "登录成功").delay(2, TimeUnit.SECONDS);
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println(s);
            }
        });
    }
}
