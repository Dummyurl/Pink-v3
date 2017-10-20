package com.anglll.pink.core;

import com.anglll.pink.base.BasePresenter;
import com.anglll.pink.base.BaseView;
import com.anglll.pink.data.model.Todo;
import com.anglll.pink.data.model.Weather;

/**
 * Created by yuan on 2017/9/27 0027.
 */

public class PinkContract {
    interface View extends BaseView<Presenter> {
        void onTodoLoaded(boolean isSuccess, Todo todo, String msg);

        void onWeatherLoaded(boolean isSuccess, Weather weather, String msg);
    }

    interface Presenter extends BasePresenter {
        void getWeatherInfo(String location);

        void getTodo();
    }
}
