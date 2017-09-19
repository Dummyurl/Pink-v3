package com.anglll.pink.ui.main.model;

import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
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
import butterknife.OnLongClick;

/**
 * Created by yuan on 2017/8/7 0007.
 */
@EpoxyModelClass(layout = R.layout.home_music_model)
public abstract class MusicModel extends EpoxyModelWithHolder<MusicModel.MusicHolder> implements IPlayback.Callback {

    @EpoxyAttribute
    PlaybackService player;
    private MusicHolder holder;


    @Override
    public void bind(MusicHolder holder) {
        this.holder = holder;
        player.addCallback(this);
        holder.bindSong(player.getPlayingSong(), player.getProgress());
    }

    @Override
    public void unbind(MusicHolder holder) {
        player.removeCallback(this);
        this.holder = null;
    }

    @Override
    public int getSpanSize(int totalSpanCount, int position, int itemCount) {
        return totalSpanCount;
    }

    @Override
    public void onSwitchLast(@Nullable Song last) {
        holder.bindSong(last, 0);
    }

    @Override
    public void onSwitchNext(@Nullable Song next) {
        holder.bindSong(next, 0);
    }

    @Override
    public void onPlayComplete() {

    }

    @Override
    public void onPlayStatusChanged(boolean isPlaying) {
        Log.d("playStatus", String.valueOf(isPlaying));
    }

    @Override
    public void onProgressChanged(int progress, int total) {
        holder.mProgressBar.setProgress(progress * 100 / total);
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
        @BindView(R.id.play_icon)
        ImageView mPlayIcon;
        View itemView;

        @Override
        protected void bindView(View itemView) {
            ButterKnife.bind(this, itemView);
            this.itemView = itemView;
        }

        @OnClick(R.id.music_play)
        void playClicked(View view) {

        }

        @OnClick(R.id.cardView)
        void playOrPause(View view) {
            if (player.isPlaying()) {
                player.pause();
                mPlayIcon.setVisibility(View.VISIBLE);
            } else {
                player.play();
                mPlayIcon.setVisibility(View.GONE);
            }
        }

        @OnClick(R.id.music_play)
        void playNext(View view) {
            player.playNext();
        }

        public void bindSong(Song playingSong, int progress) {
            mMusicName.setText(playingSong.getName());
            mMusicArt.setText(playingSong.getAr_name());
            updateProgress(progress, playingSong.getDuration());
        }

        public void updateProgress(int progress, int total) {
            mProgressBar.setMax(total / 1000);
            mProgressBar.setProgress(progress / 1000);
        }
    }
}
