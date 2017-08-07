package com.anglll.pink.ui.home;

import com.airbnb.epoxy.AutoModel;
import com.airbnb.epoxy.TypedEpoxyController;
import com.anglll.pink.ui.home.model.MusicModel_;

import java.util.List;

/**
 * Created by yuan on 2017/8/7 0007.
 */

public class HomeController extends TypedEpoxyController<List<Object>> {

    private HomeCallbacks callback;
    @AutoModel
    MusicModel_ musicModel;

    HomeController(HomeCallbacks callback) {
        this.callback = callback;
    }

    @Override
    protected void buildModels(List<Object> data) {
        musicModel.addIf(data.size() == 0,this);
    }

    public interface HomeCallbacks {
    }

}
