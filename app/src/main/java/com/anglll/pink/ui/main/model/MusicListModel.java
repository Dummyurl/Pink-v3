package com.anglll.pink.ui.main.model;

import android.view.View;
import android.widget.TextView;

import com.airbnb.epoxy.EpoxyAttribute;
import com.airbnb.epoxy.EpoxyHolder;
import com.airbnb.epoxy.EpoxyModelClass;
import com.airbnb.epoxy.EpoxyModelWithHolder;
import com.anglll.pink.R;
import com.anglll.pink.data.model.SongList;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yuan on 2017/8/23 0023.
 */
@EpoxyModelClass(layout = R.layout.music_songlist_item)
public abstract class MusicListModel extends EpoxyModelWithHolder<MusicListModel.MusicItemHolder> {
    @EpoxyAttribute
    SongList songList;

    @Override
    public void bind(MusicItemHolder holder) {
        super.bind(holder);
        if (songList != null) {
            holder.songListName.setText(String.valueOf(songList.getName()));
        }

    }

    @Override
    public void unbind(MusicItemHolder holder) {
        super.unbind(holder);
    }

    @Override
    public int getSpanSize(int totalSpanCount, int position, int itemCount) {
        return totalSpanCount;
    }

    public static class MusicItemHolder extends EpoxyHolder {
        @BindView(R.id.song_list_cover)
        SimpleDraweeView songListCover;
        @BindView(R.id.song_list_name)
        TextView songListName;
        @BindView(R.id.song_count)
        TextView songCount;

        @Override
        protected void bindView(View itemView) {
            ButterKnife.bind(this, itemView);
        }
    }
}
