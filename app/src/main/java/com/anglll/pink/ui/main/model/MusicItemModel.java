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
@EpoxyModelClass(layout = R.layout.music_songlist_item)
public abstract class MusicItemModel extends EpoxyModelWithHolder<MusicItemModel.MusicItemHoder> {

    @Override
    public void bind(MusicItemHoder holder) {
        super.bind(holder);
    }

    @Override
    public void unbind(MusicItemHoder holder) {
        super.unbind(holder);
    }

    public static class MusicItemHoder extends EpoxyHolder {

        @Override
        protected void bindView(View itemView) {
            ButterKnife.bind(this, itemView);
        }
    }
}
