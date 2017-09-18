package com.anglll.pink.ui.main.model;

import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.airbnb.epoxy.EpoxyAttribute;
import com.airbnb.epoxy.EpoxyHolder;
import com.airbnb.epoxy.EpoxyModelClass;
import com.airbnb.epoxy.EpoxyModelWithHolder;
import com.anglll.pink.R;
import com.anglll.pink.data.model.Song;
import com.anglll.pink.player.IPlayback;
import com.anglll.pink.player.PlaybackService;
import com.anglll.pink.ui.main.MainController;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by yuan on 2017/8/7 0007.
 */
@EpoxyModelClass(layout = R.layout.home_music_model)
public abstract class MusicModel extends EpoxyModelWithHolder<MusicModel.MusicHolder> implements IPlayback.Callback, View.OnClickListener {

    @EpoxyAttribute
    PlaybackService player;
    @EpoxyAttribute
    MainController.MainCallback callback;
    private MusicHolder holder;


    @Override
    public void bind(MusicHolder holder) {
        player.addCallback(this);
        this.holder = holder;
        holder.bindSong(player.getPlayingSong(),player.getProgress());
    }

    @Override
    public void unbind(MusicHolder holder) {
        player.removeCallback(this);
        this.holder = null;
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public int getSpanSize(int totalSpanCount, int position, int itemCount) {
        return totalSpanCount;
    }

    @Override
    public void onSwitchLast(@Nullable Song last) {

    }

    @Override
    public void onSwitchNext(@Nullable Song next) {

    }

    @Override
    public void onPlayComplete() {

    }

    @Override
    public void onPlayStatusChanged(boolean isPlaying) {

    }

    @Override
    public void onProgressChanged(int progress, int total) {
        Log.d("progress", progress + "/" + total);
        if (holder == null)
            return;
        holder.mProgressBar.setProgress(progress*100/total);
    }

    public class MusicHolder extends EpoxyHolder {
        @BindView(R.id.progressBar)
        ProgressBar mProgressBar;
        @BindView(R.id.simpleDraweeView2)
        SimpleDraweeView mSimpleDraweeView2;
        @BindView(R.id.music_name)
        TextView mMusicName;
        @BindView(R.id.music_art)
        TextView mMusicArt;
        @BindView(R.id.music_play)
        AppCompatImageView mMusicPlay;
        @BindView(R.id.divider)
        TextView mDivider;
        View itemView;

        @Override
        protected void bindView(View itemView) {
            ButterKnife.bind(this, itemView);
            this.itemView = itemView;
        }

        @OnClick(R.id.music_play)
        void playClicked(View view) {
            if (callback != null) {
                callback.onMusicPlay();
            }
        }

        public void bindSong(Song playingSong, int progress) {
            mMusicName.setText(playingSong.getName());
            mMusicArt.setText(playingSong.getAr_name());
            updateProgress(progress,playingSong.getDuration());
        }

        public void updateProgress(int progress, int total){
            mProgressBar.setMax(total/1000);
            mProgressBar.setProgress(progress/1000);
        }
    }
}
