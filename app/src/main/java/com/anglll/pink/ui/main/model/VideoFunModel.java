package com.anglll.pink.ui.main.model;

import android.view.View;

import com.airbnb.epoxy.EpoxyHolder;
import com.airbnb.epoxy.EpoxyModelClass;
import com.airbnb.epoxy.EpoxyModelWithHolder;
import com.anglll.pink.R;

import butterknife.ButterKnife;

/**
 * Created by yuan on 8/30/17.
 */
@EpoxyModelClass(layout = R.layout.video_fun_v)
public abstract class VideoFunModel extends EpoxyModelWithHolder<VideoFunModel.VideoFunHolder> {
    @Override
    public int getSpanSize(int totalSpanCount, int position, int itemCount) {
        return totalSpanCount / 3;
    }

    public static class VideoFunHolder extends EpoxyHolder {

        @Override
        protected void bindView(View itemView) {
            ButterKnife.bind(this, itemView);
        }
    }
}
