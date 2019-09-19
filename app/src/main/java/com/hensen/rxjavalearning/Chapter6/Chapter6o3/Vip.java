package com.hensen.rxjavalearning.Chapter6.Chapter6o3;

import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * Created by handsomexu on 2018/10/4.
 */

public class Vip {

    private static HashMap<Long, VipBean> mVipCache = new HashMap<>();//作为缓存的类型

    /**
     * 模拟合并本地信息和服务器信息
     */
    public static void vip(View view) {
        List<Long> uids = new ArrayList<>();

        Log.e("TAG", "第一次查询，进入好友列表界面，查询好友列表的会员信息");
        uids.add(1L);
        uids.add(2L);
        getVipFromCache(uids);
        uids.clear();

        Log.e("TAG", "第二次查询，进入群聊界面，查询群聊中的会员信息");
        uids.add(1L);
        uids.add(3L);
        uids.add(4L);
        getVipFromCache(uids);
        uids.clear();

        Log.e("TAG", "第三次查询，定时更新最新会员信息，更新所有缓存里的数据");
        uids.add(1L);
        uids.add(2L);
        uids.add(3L);
        uids.add(4L);
        mVipCache.clear();
        getVipFromCache(uids);
    }

    /**
     * 从网络上批量查询Vip信息
     */
    public static Observable<HashMap<Long, VipBean>> getVipFromWeb(List<Long> uids) {
        //由于这里没有对应的接口，所以模拟请求网络数据
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //模拟返回的数据
        HashMap<Long, VipBean> vip = new HashMap<>();
        for (Long uid : uids) {
            //后台返回的数据进行赋值
            VipBean vipInfo = new VipBean();
            //vipInfo.xxx = WebValue;
            //vipInfo.xxx = WebValue;
            vip.put(uid, vipInfo);
        }

        //缓存到本地
        mVipCache.putAll(vip);

        return Observable.just(vip);
    }

    /**
     * 从本地缓存中获取数据
     */
    public static Observable<HashMap<Long, VipBean>> getVipFromCache(List<Long> uids) {
        List<Long> mRequestList = new ArrayList<>();
        HashMap<Long, VipBean> vipInfo = new HashMap<>();

        for (Long uid : uids) {
            if (mVipCache.containsKey(uid)) {
                Log.e("TAG", "从本地获取数据:" + uid + "用户");
                vipInfo.put(uid, mVipCache.get(uid));//如果缓存中有数据，则从本地中取出
            } else {
                Log.e("TAG", "从网络获取数据:" + uid + "用户");
                mRequestList.add(uid);//如果缓存中没有数据，则加入到网络请求列表中
            }
        }

        if (mRequestList.isEmpty()) {
            //如果请求列表中为空，则直接返回缓存的数据
            return Observable.just(vipInfo);
        }

        //合并缓存的数据和网络获取的数据
        return Observable.merge(Observable.just(vipInfo), getVipFromWeb(mRequestList));
    }
}
