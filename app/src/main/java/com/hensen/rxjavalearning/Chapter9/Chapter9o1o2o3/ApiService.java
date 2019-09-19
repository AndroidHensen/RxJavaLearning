package com.hensen.rxjavalearning.Chapter9.Chapter9o1o2o3;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by handsomexu on 2018/6/24.
 */

public interface ApiService {
    @GET("/getUserInfo.php")
    Observable<Main2Activity.UserInfo> getUserInfo(@Query("username") String username, @Query("password") String password);

    @GET("/getVipInfo.php")
    Observable<Main2Activity.VipInfo> getVipInfo(@Query("uid") String uid);
}

