package com.anglll.pink.ui.model;

import android.view.View;
import android.widget.TextView;

import com.airbnb.epoxy.EpoxyAttribute;
import com.airbnb.epoxy.EpoxyHolder;
import com.airbnb.epoxy.EpoxyModelClass;
import com.airbnb.epoxy.EpoxyModelWithHolder;
import com.anglll.pink.R;
import com.anglll.pink.data.model.Song;
import com.anglll.pink.player.IPlayback;
import com.anglll.pink.ui.songlist.SongListController;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by yuan on 2017/9/5 0005.
 */
@EpoxyModelClass(layout = R.layout.music_item)
public abstract class MusicItemModel extends EpoxyModelWithHolder<MusicItemModel.MusicItemHolder> {

    @EpoxyAttribute
    Song song;
    @EpoxyAttribute
    int index;
    @EpoxyAttribute
    SongListController.SongListCallback callback;

    @Override
    public void bind(MusicItemHolder holder) {
        super.bind(holder);
        holder.bindData(song, index);
    }

    @Override
    public int getSpanSize(int totalSpanCount, int position, int itemCount) {
        return totalSpanCount;
    }

    public class MusicItemHolder extends EpoxyHolder {
        @BindView(R.id.index)
        TextView index;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.artist)
        TextView artist;
        private int position;
        private Song song;

        @OnClick(R.id.layout_song_item)
        void songClicked() {
            if (callback != null)
                callback.onSongClick(song,position);
        }

        @Override
        protected void bindView(View itemView) {
            ButterKnife.bind(this, itemView);
        }

        public void bindData(Song song, int index) {
            this.position = index;
            this.song = song;
            if (song == null)
                return;
            this.index.setText(String.valueOf(index + 1));
            this.name.setText(song.getName());
            this.artist.setText(song.getAr_name());
        }
    }
}
