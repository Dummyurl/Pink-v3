package com.anglll.pink.ui.main;

import android.support.v7.widget.RecyclerView;

import com.airbnb.epoxy.TypedEpoxyController;
import com.anglll.pink.BuildConfig;
import com.anglll.pink.data.model.HomeCard;
import com.anglll.pink.ui.main.model.EventModelGroup;
import com.anglll.pink.ui.main.model.MusicModel_;
import com.anglll.pink.ui.main.model.WeatherModel_;

import java.util.List;

/**
 * Created by yuan on 2017/8/7 0007.
 */

public class HomeController extends TypedEpoxyController<List<HomeCard>> {

    private final RecyclerView.RecycledViewPool recycledViewPool;
    private HomeCallbacks callback;

    HomeController(HomeCallbacks callback, RecyclerView.RecycledViewPool recycledViewPool) {
        this.callback = callback;
        this.recycledViewPool = recycledViewPool;
        if(BuildConfig.DEBUG)
        setDebugLoggingEnabled(true);
    }

    @Override
    protected void buildModels(List<HomeCard> data) {
        for (HomeCard card : data) {
            switch (card.getType()) {
                case HomeCard.TYPE_WEATHER:
                    add(new WeatherModel_()
                            .id(card.id)
                    );
                    break;
                case HomeCard.TYPE_MUSIC:
                    add(new MusicModel_()
                            .id(card.id));
                    break;
                case HomeCard.TYPE_EVENT:
                    add(new EventModelGroup(card,callback,recycledViewPool));
                    break;
                default:
                    break;
            }
        }
    }

    public interface HomeCallbacks {
    }

}
