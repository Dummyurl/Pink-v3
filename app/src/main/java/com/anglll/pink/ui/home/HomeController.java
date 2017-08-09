package com.anglll.pink.ui.home;

import com.airbnb.epoxy.TypedEpoxyController;
import com.anglll.pink.data.model.HomeCard;
import com.anglll.pink.ui.home.model.EventModelGroup;
import com.anglll.pink.ui.home.model.MusicModel_;
import com.anglll.pink.ui.home.model.WeatherModel_;

import java.util.List;

/**
 * Created by yuan on 2017/8/7 0007.
 */

public class HomeController extends TypedEpoxyController<List<HomeCard>> {

    private HomeCallbacks callback;

    HomeController(HomeCallbacks callback) {
        this.callback = callback;
    }

    @Override
    protected void buildModels(List<HomeCard> data) {
        for (HomeCard card : data) {
            switch (card.getType()) {
                case HomeCard.TYPE_WEATHER:
                    add(new WeatherModel_()
                            .id(card.getId())
                    );
                    break;
                case HomeCard.TYPE_MUSIC:
                    add(new MusicModel_()
                            .id(card.getId()));
                    break;
                case HomeCard.TYPE_EVENT:
                    add(new EventModelGroup(card));
                    break;
                default:
                    break;
            }
        }
    }

    public interface HomeCallbacks {
    }

}