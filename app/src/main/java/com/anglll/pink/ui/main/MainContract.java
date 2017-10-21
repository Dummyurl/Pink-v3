package com.anglll.pink.ui.main;

import android.support.annotation.StringRes;

import com.anglll.pink.base.BasePresenter;
import com.anglll.pink.base.BaseView;
import com.anglll.pink.data.model.SongList;
import com.anglll.pink.data.model.VideoMain;
import com.anglll.pink.data.model.Weather;

import java.util.List;

/**
 * Created by yuan on 2017/8/22 0022.
 */

public class MainContract {

    interface View extends BaseView<Presenter> {

        void getSongListSuccess(List<SongList> songLists);

        void getSongListFail(@StringRes int stringRes);

        void getVideoRecommendSuccess(List<VideoMain> videoMainList);

        void getVideoRecommendFail(@StringRes int stringRes);

        void getOffSongList(SongList songList);
    }

    interface Presenter extends BasePresenter {

        void getSongList(long uid);

        void getVideoRecommend();

        void getOffSongList();
    }
}
