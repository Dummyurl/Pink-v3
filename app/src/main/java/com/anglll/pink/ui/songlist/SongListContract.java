package com.anglll.pink.ui.songlist;

import android.support.annotation.StringRes;

import com.anglll.pink.base.BasePresenter;
import com.anglll.pink.base.BaseView;
import com.anglll.pink.data.model.SongList;

/**
 * Created by yuan on 2017/9/5 0005.
 */

public class SongListContract {
    interface View extends BaseView<Presenter> {

        void getSongList(SongList songList);

        void getSongListFail(@StringRes int stringRes);

        void getSongListNet(SongList songList);

        void getSongListNetFail(@StringRes int stringRes);
    }

    interface Presenter extends BasePresenter {
        void getSongList(long id);

        void getSongListByNet(long id);
    }
}
