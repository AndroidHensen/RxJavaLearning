package com.hensen.rxjavalearning.Chapter3.Chapter3o2;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.observables.GroupedObservable;

/**
 * Created by handsomexu on 2018/4/9.
 */

public class GroupBy {

    public static void main(String[] args) {

        Observable.just("java", "c++", "c", "c#", "javaScript", "Android")
                .groupBy(new Function<String, Character>() {
                    @Override
                    public Character apply(String s) throws Exception {
                        return s.charAt(0);//按首字母分组
                    }
                })
                .subscribe(new Consumer<GroupedObservable<Character, String>>() {
                    @Override
                    public void accept(final GroupedObservable<Character, String> characterStringGroupedObservable) throws Exception {
                        //排序后，直接订阅输出key和value
                        characterStringGroupedObservable.sorted().subscribe(new Consumer<String>() {
                            @Override
                            public void accept(String s) throws Exception {
                                System.out.println("onNext= group:" + characterStringGroupedObservable.getKey() + " value:" + s);
                            }
                        });
                    }
                });


        Observable.just("java", "c++", "c", "c#", "javaScript", "Android")
                .groupBy(new Function<String, Character>() {
                    @Override
                    public Character apply(String s) throws Exception {
                        return s.charAt(0);//按首字母分组
                    }
                }, new Function<String, Boolean>() {
                    @Override
                    public Boolean apply(String s) throws Exception {
                        return s.startsWith("c");//按首字母为c开头分组
                    }
                })
                .subscribe(new Consumer<GroupedObservable<Character, Boolean>>() {
                    @Override
                    public void accept(final GroupedObservable<Character, Boolean> characterCharacterGroupedObservable) throws Exception {
                        //直接订阅输出key和value
                        characterCharacterGroupedObservable.subscribe(new Consumer<Boolean>() {
                            @Override
                            public void accept(Boolean b) throws Exception {
                                System.out.println("onNext= group:" + characterCharacterGroupedObservable.getKey() + " value is startWith c Language:" + b);
                            }
                        });
                    }
                });
    }
}
