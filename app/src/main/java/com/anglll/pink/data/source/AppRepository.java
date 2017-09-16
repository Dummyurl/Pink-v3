package com.anglll.pink.data.source;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import com.anglll.pink.data.db.SongListDao;
import com.anglll.pink.data.model.Song;
import com.anglll.pink.data.model.SongList;
import com.anglll.pink.data.model.VideoMain;
import com.anglll.pink.data.model.Weather;
import com.anglll.pink.data.retrofit.RetrofitAPI;
import com.anglll.pink.data.retrofit.api.LocalService;
import com.anglll.pink.data.retrofit.api.RemoteService;
import com.anglll.pink.data.source.db.DaoMasterHelper;

import org.reactivestreams.Publisher;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by yuan on 2017/7/20 0020.
 */

public class AppRepository implements AppContract {
    private static AppRepository instance;
    private final RemoteService remoteService;
    private final LocalService localService;

    private AppRepository() {
        remoteService = RetrofitAPI.getInstance().getRemoteService();
        localService = RetrofitAPI.getInstance().getLocalService();
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


    @Override
    public Flowable<SongList> getSongListByNet(final ContentResolver cr, long id) {
        return remoteService.getSongList(id)
                .map(new Function<SongList, SongList>() {
                    @Override
                    public SongList apply(@NonNull SongList songList) throws Exception {
                        List<Song> songs = songList.playList;
                        Map<String, String> songMap = new HashMap<>();

                        Uri songUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                        Cursor musicCursor = cr.query(
                                songUri,
                                null,
                                null,
                                null,
                                MediaStore.Audio.Media._ID + " DESC"
                        );
                        if (musicCursor == null)
                            return null;
                        while (musicCursor.moveToNext()) {
                            String title = musicCursor.getString(musicCursor.getColumnIndex(MediaStore.Audio.Media.TITLE));
                            String path = musicCursor.getString(musicCursor.getColumnIndex(MediaStore.Audio.Media.DATA));
                            songMap.put(title, path);
                        }
                        musicCursor.close();

                        for (int i = 0; i < songs.size(); i++) {
                            songs.get(i).setIndex((long) i);
                            songs.get(i).setSongListId(songList.getId());
                            songs.get(i).setPath(songMap.get(songs.get(i).getName()));
                        }

                        DaoMasterHelper.getDaoSession()
                                .getSongDao()
                                .insertOrReplaceInTx(songs);
                        songList.playList = songs;
                        return songList;
                    }
                });
    }

    @Override
    public Flowable<SongList> getSongListByLocal(long id) {
        return localService.getSongList(id);
    }
}
