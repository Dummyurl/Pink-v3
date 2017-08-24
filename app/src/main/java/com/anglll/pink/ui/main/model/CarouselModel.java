package com.anglll.pink.ui.main.model;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.airbnb.epoxy.EpoxyAttribute;
import com.airbnb.epoxy.EpoxyModel;
import com.airbnb.epoxy.EpoxyModelClass;
import com.airbnb.epoxy.EpoxyModelWithView;
import com.anglll.pink.ui.main.view.GridRecView;

import java.util.List;

/**
 * Created by yuan on 2017/8/9 0009.
 */
@EpoxyModelClass
public abstract class CarouselModel extends EpoxyModelWithView<GridRecView> {

    @EpoxyAttribute
    List<? extends EpoxyModel<?>> models;
    @EpoxyAttribute
    int numItemsExpectedOnDisplay;
    @EpoxyAttribute(hash = false)
    RecyclerView.RecycledViewPool recycledViewPool;

    @Override
    public void bind(GridRecView view) {
        if (recycledViewPool != null)
            view.setRecycledViewPool(recycledViewPool);
        if (numItemsExpectedOnDisplay != 0)
            view.setInitialPrefetchItemCount(numItemsExpectedOnDisplay);
        view.setModels(models);
    }

    @Override
    public void unbind(GridRecView view) {
        view.clearModels();
    }

    @Override
    protected GridRecView buildView(ViewGroup parent) {
        return new GridRecView(parent.getContext(), null);
    }

    @Override
    public boolean shouldSaveViewState() {
        return true;
    }
}
