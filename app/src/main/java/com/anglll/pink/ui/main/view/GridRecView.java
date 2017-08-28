package com.anglll.pink.ui.main.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import com.airbnb.epoxy.EpoxyModel;
import com.airbnb.epoxy.SimpleEpoxyController;

import java.util.List;

/**
 * Created by yuan on 2017/8/24 0024.
 */

public class GridRecView extends RecyclerView {
    private GridLayoutManager layoutManager;
    private SimpleEpoxyController controller;
    public static final int SPAN_COUNT = 6;

    public GridRecView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setHasFixedSize(true);
        layoutManager =
                new GridLayoutManager(context, SPAN_COUNT, LinearLayoutManager.VERTICAL, false);
        setLayoutManager(layoutManager);
    }

    public void setInitialPrefetchItemCount(int count) {
        layoutManager.setInitialPrefetchItemCount(count);
    }

    public void setModels(List<? extends EpoxyModel<?>> models) {
        if (controller == null) {
            controller = new SimpleEpoxyController();
            controller.setSpanCount(SPAN_COUNT);
            layoutManager.setSpanSizeLookup(controller.getSpanSizeLookup());
            setAdapter(controller.getAdapter());
        }
        controller.setModels(models);
    }

    public void clearModels() {
        controller.cancelPendingModelBuild();
        controller = null;
        swapAdapter(null, true);
    }
}
