package com.anglll.pink.data.source;

import com.anglll.pink.data.model.SongList;
import com.anglll.pink.data.model.VideoMain;
import com.anglll.pink.data.model.Weather;
import com.anglll.pink.data.retrofit.RetrofitAPI;
import com.anglll.pink.data.retrofit.api.RemoteService;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by yuan on 2017/7/20 0020.
 */

public class AppRepository implements AppContract {
    private static AppRepository instance;
    private final RemoteService remoteService;

    private AppRepository() {
        remoteService = RetrofitAPI.getInstance().getRemoteService();
    }

    public static AppRepository getInstance() {
        synchronized (AppRepository.class) {
            if (instance == null) {
                instance = new AppRepository();
            }
            return instance;
        }
    }

    @Override
    public Flowable<Weather> getWeather(String location) {
        return remoteService.getWeatherInfo(location, "zh-Hans", "c");
    }

    @Override
    public Flowable<List<VideoMain>> getRecommendVideo() {
        return remoteService.getRecommendVideo();
    }

    @Override
    public Flowable<List<SongList>> getSongLists(long uid) {
        return remoteService.getSongLists(uid);
    }
}
