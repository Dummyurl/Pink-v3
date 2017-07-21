package com.yuan.lock.data.retrofit.api;

import com.yuan.lock.data.model.WeatherInfo;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by yuan on 2017/7/20 0020.
 */

public interface RemoteService {
    //http://mobile.weather.com.cn/data/forecast/101010100.html
    @GET("data/forecast/{cityId}.html")
    Observable<WeatherInfo> getWeatherInfo(@Path("cityId") String cityId);
}
