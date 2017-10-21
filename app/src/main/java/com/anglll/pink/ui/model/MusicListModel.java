package com.anglll.pink.ui.model;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.airbnb.epoxy.EpoxyAttribute;
import com.airbnb.epoxy.EpoxyHolder;
import com.airbnb.epoxy.EpoxyModelClass;
import com.airbnb.epoxy.EpoxyModelWithHolder;
import com.anglll.pink.R;
import com.anglll.pink.data.model.SongList;
import com.anglll.pink.ui.songlist.SongListActivity;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.fresco.helper.Phoenix;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
        holder.bindData(songList);

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
        private SongList songList;

        @Override
        protected void bindView(View itemView) {
            ButterKnife.bind(this, itemView);
        }

        public void bindData(SongList songList) {
            this.songList = songList;
            if (songList == null)
                return;
            songListName.setText(songList.getName());
            Phoenix.with(songListCover).load(songList.getCoverImgUrl());
        }

        @OnClick(R.id.item_layout)
        void clickItem(View view) {
            if (songList == null)
                return;
            Intent intent = new Intent(view.getContext(), SongListActivity.class);
            intent.putExtra(SongListActivity.SONG_LIST_ID, songList.getId());
            view.getContext().startActivity(intent);
        }
    }
}
