package com.anglll.pink.ui.model;

import android.view.View;
import android.widget.TextView;

import com.airbnb.epoxy.EpoxyAttribute;
import com.airbnb.epoxy.EpoxyHolder;
import com.airbnb.epoxy.EpoxyModelClass;
import com.airbnb.epoxy.EpoxyModelWithHolder;
import com.anglll.pink.R;
import com.anglll.pink.data.model.VideoMain;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.fresco.helper.Phoenix;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yuan on 8/30/17.
 */
@EpoxyModelClass(layout = R.layout.video_fun_v)
public abstract class VideoFunModel extends EpoxyModelWithHolder<VideoFunModel.VideoFunHolder> {
    @EpoxyAttribute
    VideoMain.ContentsBean content;

    @Override
    public void bind(VideoFunHolder holder) {
        super.bind(holder);
        holder.bindData(content);
    }

    @Override
    public int getSpanSize(int totalSpanCount, int position, int itemCount) {
        return totalSpanCount / 3;
    }

    public static class VideoFunHolder extends EpoxyHolder {
        @BindView(R.id.fun_cover)
        SimpleDraweeView funCover;
        @BindView(R.id.fun_title)
        TextView funTitle;
        @BindView(R.id.fun_info)
        TextView funInfo;

        @Override
        protected void bindView(View itemView) {
            ButterKnife.bind(this, itemView);
        }

        public void bindData(VideoMain.ContentsBean content) {
            if (content == null)
                return;
            Phoenix.with(funCover).load(content.getImage());
            funTitle.setText(content.getTitle());
            funInfo.setText(content.getLatestBangumiVideo().getTitle());
        }
    }
}
