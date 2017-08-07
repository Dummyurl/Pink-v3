package com.anglll.pink.ui.home.model;

import android.support.v7.widget.AppCompatImageView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.airbnb.epoxy.EpoxyHolder;
import com.airbnb.epoxy.EpoxyModelClass;
import com.airbnb.epoxy.EpoxyModelWithHolder;
import com.anglll.pink.R;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yuan on 2017/8/7 0007.
 */
@EpoxyModelClass(layout = R.layout.home_music_model)
public abstract class MusicModel extends EpoxyModelWithHolder<MusicModel.MusicHolder> {


    @Override
    public void bind(MusicHolder holder) {
    }

    @Override
    public void unbind(MusicHolder holder) {
    }

    @Override
    public int getSpanSize(int totalSpanCount, int position, int itemCount) {
        return totalSpanCount;
    }

    public static class MusicHolder extends EpoxyHolder {
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

        @Override
        protected void bindView(View itemView) {
            ButterKnife.bind(this, itemView);
        }
    }
}
