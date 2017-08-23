package com.anglll.pink.ui.main;

import com.anglll.pink.base.BasePresenter;
import com.anglll.pink.base.BaseView;

/**
 * Created by yuan on 2017/8/22 0022.
 */

public class MainContract {

    interface View extends BaseView<Presenter> {

    }

    interface Presenter extends BasePresenter {
        void getWeatherInfo();
    }
}
