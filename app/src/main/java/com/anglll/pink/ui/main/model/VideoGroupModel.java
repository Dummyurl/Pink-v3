package com.anglll.pink.ui.main.model;

import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.airbnb.epoxy.EpoxyModel;
import com.airbnb.epoxy.EpoxyModelGroup;
import com.anglll.pink.R;
import com.anglll.pink.data.model.VideoMain;
import com.anglll.pink.ui.main.MainController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuan on 2017/8/24 0024.
 */

public class VideoGroupModel extends EpoxyModelGroup {
    public VideoGroupModel(VideoMain videoMain,
                           MainController.HomeCallbacks callbacks,
                           RecyclerView.RecycledViewPool recycledViewPool) {
        super(R.layout.video_group,buildModels(videoMain,callbacks,recycledViewPool));
        Log.d("VideoGroupModel",String.valueOf(videoMain.getId()));
        id(videoMain.getId());
    }

    private static List<EpoxyModel<?>> buildModels(VideoMain videoMain, MainController.HomeCallbacks callbacks, RecyclerView.RecycledViewPool recycledViewPool) {
        ArrayList<EpoxyModel<?>> models = new ArrayList<>();
        models.add(new VideoDividerModel_());
        List<EpoxyModel<?>> list = new ArrayList<>();
        for (VideoMain.ContentsBean content : videoMain.getContents()) {
            list.add(new VideoVModel_()
                    .id(content.getId()));
        }
        models.add(new CarouselModel_()
                .recycledViewPool(recycledViewPool)
                .models(list));

        if (videoMain.getMenuCount() > 0) {
            models.add(new VideoMenuModel_());
        }

        return models;
    }
}
