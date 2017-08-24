package com.anglll.pink.ui.main.model;

import android.support.v7.widget.RecyclerView;

import com.airbnb.epoxy.EpoxyModel;
import com.airbnb.epoxy.EpoxyModelGroup;
import com.anglll.pink.R;
import com.anglll.pink.data.model.Event;
import com.anglll.pink.data.model.Todo;
import com.anglll.pink.ui.main.MainController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuan on 2017/8/8.
 */

public class EventModelGroup extends EpoxyModelGroup {

    public EventModelGroup(Todo todo,
                           MainController.HomeCallbacks homeCallbacks,
                           RecyclerView.RecycledViewPool recycledViewPool) {
        super(R.layout.home_calendar_model, buildModels(todo, homeCallbacks, recycledViewPool));
        id(todo.id);
    }

    private static List<EpoxyModel<?>> buildModels(Todo todo, MainController.HomeCallbacks homeCallbacks,
                                                   RecyclerView.RecycledViewPool recycledViewPool) {
        ArrayList<EpoxyModel<?>> models = new ArrayList<>();
        models.add(new EventHeaderModel_());

        if (todo != null && todo.getEvents().size() > 0) {
            List<EventItemModel_> itemList = new ArrayList<>();
            for (Event event : todo.getEvents()) {
                itemList.add(new EventItemModel_()
                        .id(event.getId()));
            }
            models.add(new CarouselModel_()
                    .recycledViewPool(recycledViewPool)
                    .models(itemList));
        } else {
            models.add(new EventEmptyModel_());
        }


        return models;
    }

    @Override
    public int getSpanSize(int totalSpanCount, int position, int itemCount) {
        return totalSpanCount;
    }
}
