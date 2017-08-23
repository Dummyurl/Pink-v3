package com.anglll.pink.ui.main.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import com.airbnb.epoxy.EpoxyModel;
import com.airbnb.epoxy.SimpleEpoxyController;

import java.util.List;

public class VerticalView extends RecyclerView {
    private LinearLayoutManager layoutManager;
    private SimpleEpoxyController controller;

    public VerticalView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setHasFixedSize(true);
        layoutManager
                = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        setLayoutManager(layoutManager);
    }

    public void setInitialPrefetchItemCount(int count) {
        layoutManager.setInitialPrefetchItemCount(count);
    }

    public void setModels(List<? extends EpoxyModel<?>> models) {
        if (controller == null) {
            controller = new SimpleEpoxyController();
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