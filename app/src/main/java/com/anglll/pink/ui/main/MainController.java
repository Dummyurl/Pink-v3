package com.anglll.pink.ui.main;

import android.support.v7.widget.RecyclerView;

import com.airbnb.epoxy.AutoModel;
import com.airbnb.epoxy.TypedEpoxyController;
import com.anglll.pink.data.model.SongList;
import com.anglll.pink.data.model.SuperModel;
import com.anglll.pink.data.model.VideoMain;
import com.anglll.pink.ui.main.model.EventModelGroup;
import com.anglll.pink.ui.main.model.MusicDividerModel_;
import com.anglll.pink.ui.main.model.MusicHeaderModel_;
import com.anglll.pink.ui.main.model.MusicListModel_;
import com.anglll.pink.ui.main.model.MusicModel_;
import com.anglll.pink.ui.main.model.VideoBanner_;
import com.anglll.pink.ui.main.model.VideoCarouselsModel_;
import com.anglll.pink.ui.main.model.VideoModelGroup;
import com.anglll.pink.ui.main.model.WeatherModel_;

/**
 * Created by yuan on 2017/8/7 0007.
 */

public class MainController extends TypedEpoxyController<SuperModel> {

    private final RecyclerView.RecycledViewPool recycledViewPool;
    private HomeCallbacks callback;

    @AutoModel
    WeatherModel_ weatherModel;
    @AutoModel
    MusicModel_ musicModel;
    @AutoModel
    MusicHeaderModel_ musicHeader;
    @AutoModel
    MusicDividerModel_ songListDivider;


    MainController(HomeCallbacks callback, RecyclerView.RecycledViewPool recycledViewPool) {
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
        add(weatherModel);
        add(musicModel);
        EventModelGroup eventModelGroup =
                new EventModelGroup(superModel.getTodo(), callback, recycledViewPool);
        add(eventModelGroup);
    }

    private void showMusicView(SuperModel superModel) {
        add(musicHeader);
        add(songListDivider);
        for (SongList songList : superModel.getSongLists()) {
             add(new MusicListModel_()
                    .id(songList.getId()));
        }
    }

    private void showVideoView(SuperModel superModel) {
        for (VideoMain videoMain : superModel.getVideoMainList()) {
            switch (videoMain.getType().getId()) {
                case 1://videos
                case 2://articles
                case 3://bangumis
                    add(new VideoModelGroup(videoMain, callback, recycledViewPool));
                    break;
                case 5://carousels
                    add(new VideoCarouselsModel_()
                            .id(videoMain.getId()));
                    break;
                case 6://banners
                    add(new VideoBanner_()
                            .id(videoMain.getId()));
                    break;
                default:
            }
        }
    }

    public interface HomeCallbacks {
        void onWeatherItemClicked();

        void onMusicItemClicked();

        void onMusicPlayClicked();

        void onMusicPlayNext();

        void onMusicPlayPre();
    }

}
