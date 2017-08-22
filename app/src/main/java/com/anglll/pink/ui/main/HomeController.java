package com.anglll.pink.ui.main;

import android.support.v7.widget.RecyclerView;

import com.airbnb.epoxy.AutoModel;
import com.airbnb.epoxy.TypedEpoxyController;
import com.anglll.pink.BuildConfig;
import com.anglll.pink.data.model.HomeCard;
import com.anglll.pink.data.model.SuperModel;
import com.anglll.pink.ui.main.model.EventModelGroup;
import com.anglll.pink.ui.main.model.MusicModel_;
import com.anglll.pink.ui.main.model.WeatherModel_;

import java.util.List;

/**
 * Created by yuan on 2017/8/7 0007.
 */

public class HomeController extends TypedEpoxyController<SuperModel> {

    private final RecyclerView.RecycledViewPool recycledViewPool;
    private HomeCallbacks callback;

    @AutoModel
    WeatherModel_ weatherModel;
    @AutoModel
    MusicModel_ musicModel;
    private EventModelGroup eventModelGroup;


    HomeController(HomeCallbacks callback, RecyclerView.RecycledViewPool recycledViewPool) {
        this.callback = callback;
        this.recycledViewPool = recycledViewPool;
        eventModelGroup = new EventModelGroup(null, callback, recycledViewPool);
    }

    @Override
    protected void buildModels(SuperModel superModel) {
        switch (superModel.getType()) {
            case SuperModel.TYPE_HOME:
                showHomeView();
                break;
            case SuperModel.TYPE_MUSIC:
                showMusicView();
                break;
            case SuperModel.TYPE_VIDEO:
                showVideoView();
                break;
            default:
        }
    }


    private void showHomeView() {
        add(weatherModel);
        add(musicModel);
        add(eventModelGroup);
    }

    private void showMusicView() {

    }

    private void showVideoView() {

    }

    public interface HomeCallbacks {
        void onWeatherItemClicked();

        void onMusicItemClicked();

        void onMusicPlayClicked();

        void onMusicPlayNext();

        void onMusicPlayPre();
    }

}
