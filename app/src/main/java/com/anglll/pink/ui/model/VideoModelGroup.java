package com.anglll.pink.ui.model;

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
                           MainController.MainCallback callbacks,
                           RecyclerView.RecycledViewPool recycledViewPool) {
        super(R.layout.video_group, buildModels(videoMain, callbacks, recycledViewPool));
        id(videoMain.getId());
    }

    private static List<EpoxyModel<?>> buildModels(VideoMain videoMain,
                                                   MainController.MainCallback callbacks,
                                                   RecyclerView.RecycledViewPool recycledViewPool) {
        ArrayList<EpoxyModel<?>> models = new ArrayList<>();
        models.add(new VideoDividerModel_()
                .videoMain(videoMain));
        int type = videoMain.getType().getId();
        List<EpoxyModel<?>> modelList = new ArrayList<>();
        switch (type) {
            case 2://articles
                for (VideoMain.ContentsBean content : videoMain.getContents()) {
                    modelList.add(new ArticleModel_()
                            .content(content)
                            .id(content.getId()));
                }
                break;
            case 3://bangumis
                for (VideoMain.ContentsBean content : videoMain.getContents()) {
                    modelList.add(new VideoFunModel_()
                            .content(content)
                            .id(content.getId()));
                }
                break;
            case 12://banana videos
                for (VideoMain.ContentsBean content : videoMain.getContents()) {
                    modelList.add(new VideoRankModel_()
                            .content(content)
                            .id(Integer.parseInt(content.getUrl())));
                    // TODO: 2017/8/31 id问题
                }
                break;
            default:
                for (VideoMain.ContentsBean content : videoMain.getContents()) {
                    modelList.add(new VideoVModel_()
                            .content(content)
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
