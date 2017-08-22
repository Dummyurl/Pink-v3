package com.anglll.pink.ui.main.model;

import android.view.View;

import com.airbnb.epoxy.EpoxyHolder;
import com.airbnb.epoxy.EpoxyModelClass;
import com.airbnb.epoxy.EpoxyModelWithHolder;
import com.anglll.pink.R;

import butterknife.ButterKnife;

/**
 * Created by yuan on 2017/8/22 0022.
 */
@EpoxyModelClass(layout = R.layout.home_calendar_empty)
public abstract class EventEmptyModel extends EpoxyModelWithHolder<EventEmptyModel.EventEmptyHolder> {

    @Override
    public void bind(EventEmptyHolder holder) {
        super.bind(holder);
    }

    @Override
    public void unbind(EventEmptyHolder holder) {
        super.unbind(holder);
    }

    @Override
    public int getSpanSize(int totalSpanCount, int position, int itemCount) {
        return totalSpanCount;
    }

    public static class EventEmptyHolder extends EpoxyHolder {

        @Override
        protected void bindView(View itemView) {
            ButterKnife.bind(this, itemView);
        }
    }
}
