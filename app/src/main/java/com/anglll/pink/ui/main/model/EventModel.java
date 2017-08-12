package com.anglll.pink.ui.main.model;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.ViewGroup;

import com.airbnb.epoxy.EpoxyAttribute;
import com.airbnb.epoxy.EpoxyModel;
import com.airbnb.epoxy.EpoxyModelClass;
import com.airbnb.epoxy.EpoxyModelWithView;
import com.airbnb.epoxy.SimpleEpoxyController;

import java.util.List;

/**
 * Created by yuan on 2017/8/9 0009.
 */
@EpoxyModelClass
public abstract class EventModel extends EpoxyModelWithView<EventModel.EventView> {

    @EpoxyAttribute
    List<? extends EpoxyModel<?>> models;
    @EpoxyAttribute
    int numItemsExpectedOnDisplay;
    @EpoxyAttribute(hash = false)
    RecyclerView.RecycledViewPool recycledViewPool;

    @Override
    public void bind(EventView view) {
        if (recycledViewPool != null)
            view.setRecycledViewPool(recycledViewPool);
        if (numItemsExpectedOnDisplay != 0)
            view.setInitialPrefetchItemCount(numItemsExpectedOnDisplay);
        view.setModels(models);
    }

    @Override
    public void unbind(EventView view) {
        view.clearModels();
    }

    @Override
    protected EventView buildView(ViewGroup parent) {
        return new EventView(parent.getContext(), null);
    }

    @Override
    public boolean shouldSaveViewState() {
        return true;
    }

    public class EventView extends RecyclerView {
        private LinearLayoutManager layoutManager;
        private SimpleEpoxyController controller;

        public EventView(Context context, @Nullable AttributeSet attrs) {
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
}
