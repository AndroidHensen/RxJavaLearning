package com.hensen.rxjavalearning.Chapter1.Chapter1o3;

/**
 * Created by handsomexu on 2018/4/7.
 */

//顾客
public class MilkConsumer implements Observer {

    private String name;

    public MilkConsumer(String name) {
        this.name = name;
    }

    @Override
    public void onNotify() {
        System.out.println(this.name + " 收到牛奶");
    }
}
