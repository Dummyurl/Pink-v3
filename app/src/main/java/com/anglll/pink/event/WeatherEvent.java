package com.anglll.pink.event;

import com.anglll.pink.data.model.WeatherInfo;

/**
 * Created by yuan on 2017/7/21 0021.
 */

public class WeatherEvent {
    private WeatherInfo weatherInfo;

    public WeatherEvent() {
    }

    public WeatherEvent(WeatherInfo info) {
        this.weatherInfo = info;
    }

    public WeatherInfo getWeatherInfo() {
        return weatherInfo;
    }
}
