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
@EpoxyModelClass(layout = R.layout.music_header)
public abstract class MusicHeaderModel extends EpoxyModelWithHolder<MusicHeaderModel.MusicHeaderHolder> {
    @Override
    public void bind(MusicHeaderHolder holder) {
        super.bind(holder);
    }

    @Override
    public void unbind(MusicHeaderHolder holder) {
        super.unbind(holder);
    }

    public static class MusicHeaderHolder extends EpoxyHolder {

        @Override
        protected void bindView(View itemView) {
            ButterKnife.bind(this, itemView);
        }
    }
}
