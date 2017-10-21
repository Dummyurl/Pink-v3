package com.anglll.pink.ui.model;

import android.view.View;
import android.widget.TextView;

import com.airbnb.epoxy.EpoxyAttribute;
import com.airbnb.epoxy.EpoxyHolder;
import com.airbnb.epoxy.EpoxyModelClass;
import com.airbnb.epoxy.EpoxyModelWithHolder;
import com.anglll.pink.R;
import com.anglll.pink.data.model.Event;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yuan on 2017/8/8.
 */
@EpoxyModelClass(layout = R.layout.home_calendar_item)
public abstract class EventItemModel extends EpoxyModelWithHolder<EventItemModel.EventItemHolder> {
    @EpoxyAttribute
    Event event;

    @Override
    public void bind(EventItemHolder holder) {
        holder.bindData(event);
    }

    @Override
    public void unbind(EventItemHolder holder) {
        super.unbind(holder);
    }

    @Override
    public int getSpanSize(int totalSpanCount, int position, int itemCount) {
        return totalSpanCount;
    }

    public static class EventItemHolder extends EpoxyHolder {
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

        public void bindData(Event event) {
            mEventTitle.setText(event.getTitle());
            long time = Long.parseLong(event.getDtstart());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date(time));
            mEventTime.setText(new DecimalFormat("00").format(calendar.get(Calendar.HOUR_OF_DAY)));
            mEventTime.setText(new DecimalFormat("00").format(calendar.get(Calendar.MINUTE)));
        }
    }
}
