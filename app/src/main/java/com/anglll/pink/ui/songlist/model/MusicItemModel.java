package com.anglll.pink.ui.songlist.model;

import android.view.View;
import android.widget.TextView;

import com.airbnb.epoxy.EpoxyAttribute;
import com.airbnb.epoxy.EpoxyHolder;
import com.airbnb.epoxy.EpoxyModelClass;
import com.airbnb.epoxy.EpoxyModelWithHolder;
import com.anglll.pink.R;
import com.anglll.pink.data.model.Song;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yuan on 2017/9/5 0005.
 */
@EpoxyModelClass(layout = R.layout.music_item)
public abstract class MusicItemModel extends EpoxyModelWithHolder<MusicItemModel.MusicItemHolder> {

    @EpoxyAttribute
    Song song;
    @EpoxyAttribute
    int index;

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

        @Override
        protected void bindView(View itemView) {
            ButterKnife.bind(this, itemView);
        }

        public void bindData(Song song, int index) {
            if(song==null)
                return;
            this.index.setText(String.valueOf(index));
            this.name.setText(song.getName());
            this.artist.setText(song.getAr_name());
        }
    }
}
