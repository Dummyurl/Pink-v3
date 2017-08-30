package com.anglll.pink.ui.main.model;

import android.view.View;

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
 * Created by yuan on 2017/8/23 0023.
 */
@EpoxyModelClass(layout = R.layout.video_banner)
public abstract class VideoBanner extends EpoxyModelWithHolder<VideoBanner.VideoBannerHolder> {
    @EpoxyAttribute
    VideoMain.ContentsBean content;

    @Override
    public void bind(VideoBannerHolder holder) {
        super.bind(holder);
        holder.bindData(content);
    }

    @Override
    public int getSpanSize(int totalSpanCount, int position, int itemCount) {
        return totalSpanCount;
    }

    public static class VideoBannerHolder extends EpoxyHolder {
        @BindView(R.id.banner)
        SimpleDraweeView banner;

        @Override
        protected void bindView(View itemView) {
            ButterKnife.bind(this, itemView);
        }

        public void bindData(VideoMain.ContentsBean content) {
            if (content == null)
                return;
            Phoenix.with(banner).load(content.getImage());
        }
    }
}
