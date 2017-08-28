package com.anglll.pink.ui.main.model;

import android.view.View;

import com.airbnb.epoxy.EpoxyHolder;
import com.airbnb.epoxy.EpoxyModelClass;
import com.airbnb.epoxy.EpoxyModelWithHolder;
import com.anglll.pink.R;

import butterknife.ButterKnife;

/**
 * Created by yuan on 2017/8/23 0023.
 */
@EpoxyModelClass(layout = R.layout.video_item_v)
public abstract class VideoVModel extends EpoxyModelWithHolder<VideoVModel.VideoVHolder> {

    @Override
    public int getSpanSize(int totalSpanCount, int position, int itemCount) {
        return totalSpanCount / 2;
    }

    public static class VideoVHolder extends EpoxyHolder {

        @Override
        protected void bindView(View itemView) {
            ButterKnife.bind(this, itemView);
        }
    }
}
