package com.anglll.pink.ui.songlist.model;

import android.view.View;

import com.airbnb.epoxy.EpoxyHolder;
import com.airbnb.epoxy.EpoxyModelClass;
import com.airbnb.epoxy.EpoxyModelWithHolder;
import com.anglll.pink.R;

import butterknife.ButterKnife;

/**
 * Created by yuan on 2017/9/5 0005.
 */
@EpoxyModelClass(layout = R.layout.music_item)
public abstract class MusicItemModel extends EpoxyModelWithHolder<MusicItemModel.MusicItemHolder> {

    @Override
    public void bind(MusicItemHolder holder) {
        super.bind(holder);
    }

    @Override
    public int getSpanSize(int totalSpanCount, int position, int itemCount) {
        return totalSpanCount;
    }

    public class MusicItemHolder extends EpoxyHolder {

        @Override
        protected void bindView(View itemView) {
            ButterKnife.bind(this, itemView);
        }
    }
}
