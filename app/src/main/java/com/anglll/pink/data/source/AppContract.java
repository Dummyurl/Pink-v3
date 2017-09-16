package com.anglll.pink.data.source;

import android.content.ContentResolver;

import com.anglll.pink.data.model.SongList;
import com.anglll.pink.data.model.VideoMain;
import com.anglll.pink.data.model.Weather;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by yuan on 2017/7/20 0020.
 */

public interface AppContract {
    Flowable<Weather> getWeather(String location);

    Flowable<List<VideoMain>> getRecommendVideo();

    Flowable<List<SongList>> getSongLists(long uid);

    Flowable<SongList> getSongListByNet(ContentResolver cr, long id);

    Flowable<SongList> getSongListByLocal(long id);
}
