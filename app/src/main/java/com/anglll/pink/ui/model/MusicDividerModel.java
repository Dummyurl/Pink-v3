package com.anglll.pink.ui.model;

import android.support.annotation.ColorRes;
import android.view.View;
import android.widget.TextView;

import com.airbnb.epoxy.EpoxyAttribute;
import com.airbnb.epoxy.EpoxyHolder;
import com.airbnb.epoxy.EpoxyModelClass;
import com.airbnb.epoxy.EpoxyModelWithHolder;
import com.anglll.pink.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yuan on 2017/8/23 0023.
 */

@EpoxyModelClass(layout = R.layout.music_divider)
public abstract class MusicDividerModel extends EpoxyModelWithHolder<MusicDividerModel.MusicDividerHolder> {
    @EpoxyAttribute
    String title;
    @EpoxyAttribute
    @ColorRes
    int color;


    @Override
    public void bind(MusicDividerHolder holder) {
        super.bind(holder);
        holder.mDividerTitle.setText(title);
        if (color != 0) {
            holder.mDividerColorBlock.setBackgroundResource(color);
        }
    }

    @Override
    public void unbind(MusicDividerHolder holder) {
        super.unbind(holder);
    }

    @Override
    public int getSpanSize(int totalSpanCount, int position, int itemCount) {
        return totalSpanCount;
    }

    class MusicDividerHolder extends EpoxyHolder {
        @BindView(R.id.divider_color_block)
        View mDividerColorBlock;
        @BindView(R.id.divider_title)
        TextView mDividerTitle;

        @Override
        protected void bindView(View itemView) {
            ButterKnife.bind(this, itemView);
        }
    }
}
