package com.anglll.pink.ui.main.model;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.airbnb.epoxy.EpoxyAttribute;
import com.airbnb.epoxy.EpoxyHolder;
import com.airbnb.epoxy.EpoxyModelClass;
import com.airbnb.epoxy.EpoxyModelWithHolder;
import com.anglll.pink.R;
import com.anglll.pink.data.model.VideoMain;
import com.anglll.pink.utils.NumberUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yuan on 2017/8/23 0023.
 */
@EpoxyModelClass(layout = R.layout.article_item)
public abstract class ArticleModel extends EpoxyModelWithHolder<ArticleModel.ArticleHolder> {

    @EpoxyAttribute
    VideoMain.ContentsBean content;

    @Override
    public void bind(ArticleHolder holder) {
        super.bind(holder);
        holder.bindData(content);
    }

    @Override
    public int getSpanSize(int totalSpanCount, int position, int itemCount) {
        return totalSpanCount;
    }

    public static class ArticleHolder extends EpoxyHolder {
        @BindView(R.id.comment_count)
        TextView commentCount;
        @BindView(R.id.article_title)
        TextView articleTitle;
        @BindView(R.id.article_up)
        TextView articleUp;
        @BindView(R.id.article_view_count)
        TextView articleViewCount;
        @BindView(R.id.from)
        TextView from;

        @Override
        protected void bindView(View itemView) {
            ButterKnife.bind(this, itemView);
        }

        public void bindData(VideoMain.ContentsBean content) {
            if (content == null)
                return;
            commentCount.setText(NumberUtils.formatCount(content.getVisit().getComments()));
            articleTitle.setText(content.getTitle());
            articleUp.setText(content.getOwner().getName());
            articleViewCount.setText(NumberUtils.formatCount(content.getVisit().getViews()));
        }
    }
}
