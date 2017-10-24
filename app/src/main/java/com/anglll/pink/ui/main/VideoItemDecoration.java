package com.anglll.pink.ui.main;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.anglll.pink.R;

/**
 * Created by yuan on 2017/10/24 0024.
 */

public class VideoItemDecoration extends RecyclerView.ItemDecoration {

    private final int dividerLeft;
    private final int dividerTop;

    public VideoItemDecoration(Context context) {
        dividerTop = context.getResources().getDimensionPixelSize(R.dimen.card_interval);
        dividerLeft = dividerTop / 2;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int position = parent.getLayoutManager().getPosition(view);
        GridLayoutManager manager = (GridLayoutManager) parent.getLayoutManager();
        int totalSpanSize = manager.getSpanCount();
        int SpanSize = manager.getSpanSizeLookup().getSpanSize(position);
        outRect.left = dividerLeft;
        outRect.right = dividerLeft;

        if (SpanSize == totalSpanSize) {
            outRect.top = dividerTop;
        } else {
            int a = totalSpanSize / SpanSize;
            if (position < a) {
                outRect.top = 0;
            } else {
                outRect.top = dividerTop;
            }
        }
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
    }
}
