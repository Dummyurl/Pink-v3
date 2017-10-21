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
 * Created by yuan on 2017/8/31.
 */
@EpoxyModelClass(layout = R.layout.video_rank)
public abstract class VideoRankModel extends EpoxyModelWithHolder<VideoRankModel.VideoRankHolder> {
    @EpoxyAttribute
    VideoMain.ContentsBean content;

    @Override
    public void bind(VideoRankHolder holder) {
        super.bind(holder);
        holder.bindData(content);
    }

    @Override
    public int getSpanSize(int totalSpanCount, int position, int itemCount) {
        return totalSpanCount;
    }

    public class VideoRankHolder extends EpoxyHolder {
        @BindView(R.id.video_cover)
        SimpleDraweeView mVideoCover;
        @BindView(R.id.videoTitle)
        TextView mVideoTitle;
        @BindView(R.id.upName)
        TextView mUpName;
        @BindView(R.id.viewCount)
        TextView mViewCount;
        @BindView(R.id.videoBanana)
        TextView mVideoBanana;

        @Override
        protected void bindView(View itemView) {
            ButterKnife.bind(this, itemView);
        }

        public void bindData(VideoMain.ContentsBean content) {
            if (content == null)
                return;
            Phoenix.with(mVideoCover).load(content.getImage());
            mVideoTitle.setText(content.getTitle());
            mUpName.setText(content.getOwner().getName());
            mViewCount.setText(String.valueOf(content.getVisit().getViews()));
            mVideoBanana.setText(String.valueOf(content.getVisit().getGoldBanana()));
        }
    }
}
