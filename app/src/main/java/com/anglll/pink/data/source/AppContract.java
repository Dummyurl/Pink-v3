package com.anglll.pink.data.source;

import com.anglll.pink.data.model.SongList;
import com.anglll.pink.data.model.Todo;
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

    Flowable<List<SongList>> getSongListsByNet(long uid);
    Flowable<List<SongList>> getSongListsByLocal();

    Flowable<SongList> getSongListByNet(long id);

    Flowable<SongList> getSongListByLocal(long id);

    Flowable<Todo> getTodo();

    Flowable<SongList> getOffSongList();
}
