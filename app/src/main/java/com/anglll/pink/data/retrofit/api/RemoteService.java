package com.anglll.pink.data.retrofit.api;

import com.anglll.pink.data.model.Weather;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by yuan on 2017/7/20 0020.
 */

public interface RemoteService {
    //获取天气实况信息
    @GET("")
    Flowable<Weather> getWeatherInfo(
            @Query("location") String location,
            @Query("language") String language,
            @Query("unit") String unit
    );

}
