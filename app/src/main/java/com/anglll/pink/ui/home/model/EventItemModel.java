package com.anglll.pink.ui.home.model;

import android.view.View;
import android.widget.TextView;

import com.airbnb.epoxy.EpoxyHolder;
import com.airbnb.epoxy.EpoxyModelClass;
import com.airbnb.epoxy.EpoxyModelWithHolder;
import com.anglll.pink.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yuan on 2017/8/8.
 */
@EpoxyModelClass(layout = R.layout.home_calendar_item)
public abstract class EventItemModel extends EpoxyModelWithHolder<EventItemModel.EventItemHoder> {

    @Override
    public void bind(EventItemHoder holder) {
        super.bind(holder);
    }

    @Override
    public void unbind(EventItemHoder holder) {
        super.unbind(holder);
    }

    @Override
    public int getSpanSize(int totalSpanCount, int position, int itemCount) {
        return totalSpanCount;
    }

    public static class EventItemHoder extends EpoxyHolder {
        @BindView(R.id.event_color)
        TextView mEventColor;
        @BindView(R.id.event_title)
        TextView mEventTitle;
        @BindView(R.id.event_time)
        TextView mEventTime;
        @BindView(R.id.event_type_color)
        TextView mEventTypeColor;
        @BindView(R.id.event_type)
        TextView mEventType;

        @Override
        protected void bindView(View itemView) {
            ButterKnife.bind(this, itemView);
        }
    }
}
