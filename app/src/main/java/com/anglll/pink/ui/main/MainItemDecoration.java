package com.anglll.pink.ui.main;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.anglll.pink.R;

/**
 * Created by yuan on 2017/10/21 0021.
 */
//http://www.jianshu.com/p/b46a4ff7c10a
public class MainItemDecoration extends RecyclerView.ItemDecoration {
    private final int divider;

    public MainItemDecoration(Context context) {
        divider = context.getResources().getDimensionPixelSize(R.dimen.card_interval);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.top = divider;
        outRect.right = divider;
        outRect.left = divider;
    }
}
