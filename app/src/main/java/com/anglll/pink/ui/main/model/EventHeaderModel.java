package com.anglll.pink.ui.main.model;

import android.support.v7.widget.AppCompatImageView;
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
@EpoxyModelClass(layout = R.layout.home_calendar_header)
public abstract class EventHeaderModel extends EpoxyModelWithHolder<EventHeaderModel.EventHeaderHolder> {
    @Override
    public void bind(EventHeaderHolder holder) {
        super.bind(holder);
    }

    @Override
    public void unbind(EventHeaderHolder holder) {
        super.unbind(holder);
    }

    @Override
    public int getSpanSize(int totalSpanCount, int position, int itemCount) {
        return totalSpanCount;
    }

    public static class EventHeaderHolder extends EpoxyHolder {
        @BindView(R.id.event_title)
        TextView mEventTitle;
        @BindView(R.id.event_add)
        AppCompatImageView mEventAdd;

        @Override
        protected void bindView(View itemView) {
            ButterKnife.bind(this, itemView);
        }
    }
}
