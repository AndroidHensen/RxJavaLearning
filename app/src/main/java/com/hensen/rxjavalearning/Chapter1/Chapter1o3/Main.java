package com.hensen.rxjavalearning.Chapter1.Chapter1o3;

/**
 * Created by handsomexu on 2018/4/7.
 */

public class Main {

    public static void main(String[] args) {
        Observable milkFactory = new MilkFactory();

        Observer milkConsumer1 = new MilkConsumer("顾客1");
        Observer milkConsumer2 = new MilkConsumer("顾客2");
        //订阅过程
        milkFactory.subscribe(milkConsumer1);
        milkFactory.subscribe(milkConsumer2);
        //发布过程
        System.out.println("此时，牛奶店已经产出早餐奶，通知并发送给各位顾客");
        milkFactory.onNext();
    }
}
