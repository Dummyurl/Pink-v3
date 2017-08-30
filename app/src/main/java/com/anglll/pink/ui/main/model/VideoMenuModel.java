package com.anglll.pink.ui.main.model;

import android.view.View;
import android.widget.TextView;

import com.airbnb.epoxy.EpoxyAttribute;
import com.airbnb.epoxy.EpoxyHolder;
import com.airbnb.epoxy.EpoxyModelClass;
import com.airbnb.epoxy.EpoxyModelWithHolder;
import com.anglll.pink.R;
import com.anglll.pink.data.model.VideoMain;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yuan on 2017/8/23 0023.
 */
@EpoxyModelClass(layout = R.layout.video_menu)
public abstract class VideoMenuModel extends EpoxyModelWithHolder<VideoMenuModel.VideoMenuHolder> {
    @EpoxyAttribute
    VideoMain videoMain;

    @Override
    public void bind(VideoMenuHolder holder) {
        super.bind(holder);
        holder.bindData(videoMain);
    }

    @Override
    public int getSpanSize(int totalSpanCount, int position, int itemCount) {
        return totalSpanCount;
    }

    public static class VideoMenuHolder extends EpoxyHolder {
        @BindView(R.id.textView)
        TextView textView;

        @Override
        protected void bindView(View itemView) {
            ButterKnife.bind(this, itemView);
        }

        public void bindData(VideoMain videoMain) {
            if (videoMain == null)
                return;
            if (videoMain.getMenuCount() > 0) {
                textView.setText(videoMain.getMenus().get(0).getName());
            } else {
                textView.setText("");
            }
        }
    }
}
