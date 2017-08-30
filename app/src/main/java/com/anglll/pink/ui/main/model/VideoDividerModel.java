package com.anglll.pink.ui.main.model;

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

import java.io.LineNumberInputStream;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yuan on 2017/8/23 0023.
 */
@EpoxyModelClass(layout = R.layout.video_divider)
public abstract class VideoDividerModel extends EpoxyModelWithHolder<VideoDividerModel.VideoDividerHolder> {
    @EpoxyAttribute
    VideoMain videoMain;

    @Override
    public void bind(VideoDividerHolder holder) {
        super.bind(holder);
        holder.bindData(videoMain);
    }

    @Override
    public int getSpanSize(int totalSpanCount, int position, int itemCount) {
        return totalSpanCount;
    }

    public static class VideoDividerHolder extends EpoxyHolder {
        @BindView(R.id.icon)
        SimpleDraweeView icon;
        @BindView(R.id.title)
        TextView title;

        @Override
        protected void bindView(View itemView) {
            ButterKnife.bind(this, itemView);
        }

        public void bindData(VideoMain videoMain) {
            if (videoMain == null)
                return;
            Phoenix.with(icon).load(videoMain.getImage());
            title.setText(videoMain.getName());
        }
    }
}
