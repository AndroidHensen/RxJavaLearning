package com.hensen.rxjavalearning.Chapter3.Chapter3o6;

import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by handsomexu on 2018/4/9.
 */

public class Using {

    public static class UserBean {
        String name;
        int age;

        public UserBean(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        Observable.using(new Callable<UserBean>() {
            @Override
            public UserBean call() throws Exception {
                //从网络中获取某个对象
                return new UserBean("俊俊俊", 22);
            }
        }, new Function<UserBean, ObservableSource<?>>() {
            @Override
            public ObservableSource<?> apply(UserBean userBean) throws Exception {
                //拿出你想要的资源
                return Observable.just(userBean.name);
            }
        }, new Consumer<UserBean>() {
            @Override
            public void accept(UserBean userBean) throws Exception {
                //释放对象
                userBean = null;
            }
        }).subscribe(new Consumer<Object>() {
            @Override
            public void accept(Object o) throws Exception {
                System.out.println("onNext=" + o.toString());
            }
        });
    }
}
