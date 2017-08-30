package com.anglll.pink.data.retrofit.api;

import com.anglll.pink.data.model.SongList;
import com.anglll.pink.data.model.VideoMain;
import com.anglll.pink.data.model.Weather;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by yuan on 2017/7/20 0020.
 */

public interface RemoteService {
    //获取天气实况信息
    //http://localhost:3000/api/v1/weather/now.json?location=ip&language=zh-Hans&unit=c
    @GET("api/v1/weather/now.json")
    Flowable<Weather> getWeatherInfo(
            @Query("location") String location,
            @Query("language") String language,
            @Query("unit") String unit
    );

    //获取推荐视频列表
    //http://localhost:3000/api/v1/video/recommend.json
    @GET("api/v1/video/recommend.json")
    Flowable<List<VideoMain>> getRecommendVideo();

    //获取用户歌单列表
    //http://localhost:3000/api/v1/music/songList.json
    @GET("api/v1/music/songLists.json")
    Flowable<List<SongList>> getUserSongList(
            @Query("uid") String uid
    );
}
