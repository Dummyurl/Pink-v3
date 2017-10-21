package com.anglll.pink.ui.main;

import android.support.v7.widget.RecyclerView;

import com.airbnb.epoxy.AutoModel;
import com.airbnb.epoxy.TypedEpoxyController;
import com.anglll.pink.data.model.SongList;
import com.anglll.pink.data.model.SuperModel;
import com.anglll.pink.data.model.VideoMain;
import com.anglll.pink.ui.model.EventModelGroup;
import com.anglll.pink.ui.model.MusicCarouselsModel_;
import com.anglll.pink.ui.model.MusicDividerModel_;
import com.anglll.pink.ui.model.MusicHeaderModel_;
import com.anglll.pink.ui.model.MusicListModel_;
import com.anglll.pink.ui.model.MusicModel_;
import com.anglll.pink.ui.model.VideoBanner_;
import com.anglll.pink.ui.model.VideoCarouselsModel_;
import com.anglll.pink.ui.model.VideoModelGroup;
import com.anglll.pink.ui.model.WeatherModel_;

/**
 * Created by yuan on 2017/8/7 0007.
 */

public class MainController extends TypedEpoxyController<SuperModel> {

    private final RecyclerView.RecycledViewPool recycledViewPool;
    private MainCallback callback;

    @AutoModel
    WeatherModel_ weatherModel;
    @AutoModel
    MusicModel_ musicModel;
    @AutoModel
    MusicHeaderModel_ musicHeader;
    @AutoModel
    MusicDividerModel_ songListDivider;
    @AutoModel
    MusicCarouselsModel_ musicCarousels;


    MainController(MainCallback callback, RecyclerView.RecycledViewPool recycledViewPool) {
        this.callback = callback;
        this.recycledViewPool = recycledViewPool;
    }

    @Override
    protected void buildModels(SuperModel superModel) {
        switch (superModel.getType()) {
            case SuperModel.TYPE_HOME:
                showHomeView(superModel);
                break;
            case SuperModel.TYPE_MUSIC:
                showMusicView(superModel);
                break;
            case SuperModel.TYPE_VIDEO:
                showVideoView(superModel);
                break;
            default:
        }
    }


    private void showHomeView(SuperModel superModel) {
        add(weatherModel.weather(superModel.getWeather()));
        musicModel
                .player(superModel.getMusicPlayer())
                .addIf(superModel.getMusicPlayer() != null, this);
        EventModelGroup eventModelGroup =
                new EventModelGroup(superModel.getTodo(), callback, recycledViewPool);
        add(eventModelGroup);
    }

    private void showMusicView(SuperModel superModel) {
        add(musicCarousels);
        add(musicHeader);
        add(songListDivider.title("我的歌单"));
        for (SongList songList : superModel.getSongLists()) {
            add(new MusicListModel_()
                    .songList(songList)
                    .id(songList.getId()));
        }
    }

    private void showVideoView(SuperModel superModel) {
        for (VideoMain videoMain : superModel.getVideoMainList()) {
            switch (videoMain.getType().getId()) {
                case 1://videos
                case 2://articles
                case 3://bangumis
                case 12://banana videos
                    add(new VideoModelGroup(videoMain, callback, recycledViewPool));
                    break;
                case 5://carousels
                    add(new VideoCarouselsModel_()
                            .id(videoMain.getId()));
                    break;
                case 6://banners
                    add(new VideoBanner_()
                            .contents(videoMain.getContents())
                            .id(videoMain.getId()));
                    break;
                default:
            }
        }
    }

    public interface MainCallback {

    }

}
