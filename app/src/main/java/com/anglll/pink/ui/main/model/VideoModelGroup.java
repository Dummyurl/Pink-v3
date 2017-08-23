package com.anglll.pink.ui.main.model;

import android.support.annotation.LayoutRes;

import com.airbnb.epoxy.EpoxyModel;
import com.airbnb.epoxy.EpoxyModelGroup;

import java.util.Collection;
import java.util.List;

/**
 * Created by yuan on 2017/8/23 0023.
 */

public class VideoModelGroup extends EpoxyModelGroup {
    public VideoModelGroup(@LayoutRes int layoutRes, Collection<? extends EpoxyModel<?>> models) {
        super(layoutRes, models);
    }

    private static List<EpoxyModel<?>> buildModels() {
        return null;
    }

    @Override
    public int getSpanSize(int totalSpanCount, int position, int itemCount) {
        return totalSpanCount;
    }
}
