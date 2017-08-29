package com.anglll.pink.ui.main.model;

import android.support.v7.widget.RecyclerView;

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

public class VideoModelGroup extends EpoxyModelGroup {
    public VideoModelGroup(VideoMain videoMain,
                           MainController.HomeCallbacks callbacks,
                           RecyclerView.RecycledViewPool recycledViewPool) {
        super(R.layout.video_group, buildModels(videoMain, callbacks, recycledViewPool));
        id(videoMain.getId());
    }

    private static List<EpoxyModel<?>> buildModels(VideoMain videoMain,
                                                   MainController.HomeCallbacks callbacks,
                                                   RecyclerView.RecycledViewPool recycledViewPool) {
        ArrayList<EpoxyModel<?>> models = new ArrayList<>();
        models.add(new VideoDividerModel_()
                .name(videoMain.getName()));
        int type = videoMain.getType().getId();
        List<EpoxyModel<?>> modelList =  new ArrayList<>();
        switch (type){
            case 2://articles
                for (VideoMain.ContentsBean content : videoMain.getContents()) {
                    modelList.add(new ArticleModel_()
                            .id(content.getId()));
                }
                break;
            case 3://bangumis
                for (VideoMain.ContentsBean content : videoMain.getContents()) {
                    modelList.add(new VideoFunModel_()
                            .id(content.getId()));
                }
                break;
            default:
                for (VideoMain.ContentsBean content : videoMain.getContents()) {
                    modelList.add(new VideoVModel_()
                            .id(content.getId()));
                }
        }
        models.add(new CarouselModel_()
                .recycledViewPool(recycledViewPool)
                .models(modelList));

        models.add(new VideoMenuModel_());
        return models;
    }
}
