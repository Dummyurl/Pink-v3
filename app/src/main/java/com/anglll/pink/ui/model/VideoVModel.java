package com.anglll.pink.ui.model;

import android.view.View;
import android.widget.TextView;

import com.airbnb.epoxy.EpoxyAttribute;
import com.airbnb.epoxy.EpoxyHolder;
import com.airbnb.epoxy.EpoxyModelClass;
import com.airbnb.epoxy.EpoxyModelWithHolder;
import com.anglll.pink.R;
import com.anglll.pink.data.model.VideoMain;
import com.anglll.pink.utils.NumberUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.fresco.helper.Phoenix;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yuan on 2017/8/23 0023.
 */
@EpoxyModelClass(layout = R.layout.video_item_v)
public abstract class VideoVModel extends EpoxyModelWithHolder<VideoVModel.VideoVHolder> {
    @EpoxyAttribute
    VideoMain.ContentsBean content;

    @Override
    public void bind(VideoVHolder holder) {
        super.bind(holder);
        holder.bindData(content);
    }

    @Override
    public void unbind(VideoVHolder holder) {
        super.unbind(holder);
    }

    @Override
    public int getSpanSize(int totalSpanCount, int position, int itemCount) {
        return totalSpanCount / 2;
    }

    public static class VideoVHolder extends EpoxyHolder {
        @BindView(R.id.video_cover)
        SimpleDraweeView videoCover;
        @BindView(R.id.video_title)
        TextView videoTitle;
        @BindView(R.id.video_play_count)
        TextView videoPlayCount;
        @BindView(R.id.video_danmu_count)
        TextView videoDanmuCount;

        @Override
        protected void bindView(View itemView) {
            ButterKnife.bind(this, itemView);
        }

        public void bindData(VideoMain.ContentsBean content) {
            if (content == null)
                return;
            Phoenix.with(videoCover).load(content.getImage());
            videoTitle.setText(content.getTitle());
            videoPlayCount.setText(NumberUtils.formatCount(content.getVisit().getViews()));
            videoDanmuCount.setText(NumberUtils.formatCount(content.getVisit().getDanmakuSize()));
        }
    }
}
