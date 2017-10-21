package com.anglll.pink.core;

import android.support.annotation.StringRes;

import com.anglll.pink.data.model.Todo;
import com.anglll.pink.data.model.Weather;

/**
 * Created by yuan on 2017/10/20 0020.
 */

public interface PinkListener {
    void onTodoLoaded(boolean isSuccess, Todo todo, @StringRes int msgRes);

    void onWeatherLoaded(boolean isSuccess, Weather weather, @StringRes int msgRes);
}
