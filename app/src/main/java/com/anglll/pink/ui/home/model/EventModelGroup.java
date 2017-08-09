package com.anglll.pink.ui.home.model;

import com.airbnb.epoxy.EpoxyModel;
import com.airbnb.epoxy.EpoxyModelGroup;
import com.anglll.pink.R;
import com.anglll.pink.data.model.Event;
import com.anglll.pink.data.model.HomeCard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuan on 2017/8/8.
 */

public class EventModelGroup extends EpoxyModelGroup {

    public EventModelGroup(HomeCard homeCard) {
        super(R.layout.home_calendar_model, buildModels(homeCard));
    }

    private static List<EpoxyModel<?>> buildModels(HomeCard homeCard) {
        ArrayList<EpoxyModel<?>> models = new ArrayList<>();
        models.add(new EventHeaderModel_());

        List<EventItemModel_> itemList = new ArrayList<>();
        for (Event event : homeCard.getTodo().getEvents()) {
            itemList.add(new EventItemModel_()
            .id(event.getId()));
        }
        models.add(new EventModel_()
                .models(itemList));
        return models;
    }

    @Override
    public int getSpanSize(int totalSpanCount, int position, int itemCount) {
        return totalSpanCount;
    }
}
