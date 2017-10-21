package com.anglll.pink.ui.model;

import android.view.View;

import com.airbnb.epoxy.EpoxyHolder;
import com.airbnb.epoxy.EpoxyModelClass;
import com.airbnb.epoxy.EpoxyModelWithHolder;
import com.anglll.pink.R;

import butterknife.ButterKnife;

/**
 * Created by yuan on 2017/10/21 0021.
 */
@EpoxyModelClass(layout = R.layout.music_carousels)
public abstract class MusicCarouselsModel extends EpoxyModelWithHolder<MusicCarouselsModel.MusicCarouselsHolder> {

    @Override
    public int getSpanSize(int totalSpanCount, int position, int itemCount) {
        return totalSpanCount;
    }

    public static class MusicCarouselsHolder extends EpoxyHolder {
        @Override
        protected void bindView(View itemView) {
            ButterKnife.bind(this, itemView);
        }
    }
}
