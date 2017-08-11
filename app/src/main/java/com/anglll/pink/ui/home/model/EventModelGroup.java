package com.anglll.pink.ui.home.model;

import android.support.v7.widget.RecyclerView;

import com.airbnb.epoxy.EpoxyModel;
import com.airbnb.epoxy.EpoxyModelGroup;
import com.anglll.pink.R;
import com.anglll.pink.data.model.Event;
import com.anglll.pink.data.model.HomeCard;
import com.anglll.pink.ui.home.HomeController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuan on 2017/8/8.
 */

public class EventModelGroup extends EpoxyModelGroup {

    public EventModelGroup(HomeCard homeCard,
                           HomeController.HomeCallbacks homeCallbacks,
                           RecyclerView.RecycledViewPool recycledViewPool) {
        super(R.layout.home_calendar_model, buildModels(homeCard, homeCallbacks, recycledViewPool));
        id(homeCard.id);
    }

    private static List<EpoxyModel<?>> buildModels(HomeCard homeCard, HomeController.HomeCallbacks homeCallbacks, RecyclerView.RecycledViewPool recycledViewPool) {
        ArrayList<EpoxyModel<?>> models = new ArrayList<>();
        models.add(new EventHeaderModel_());
        models.add(new EventHeaderModel_());

//        List<EventItemModel_> itemList = new ArrayList<>();
//        for (Event event : homeCard.getTodo().getEvents()) {
//            itemList.add(new EventItemModel_()
//                    .id(event.getId()));
//        }
//        models.add(new EventModel_()
//                .recycledViewPool(recycledViewPool)
//                .models(itemList));
        return models;
    }

    @Override
    public int getSpanSize(int totalSpanCount, int position, int itemCount) {
        return totalSpanCount;
    }
}
