package com.anglll.pink.data.model;

/**
 * Created by yuan on 2017/8/8 0008.
 */

public class HomeCard {
    public static final int TYPE_WEATHER = 1;
    public static final int TYPE_MUSIC = 2;
    public static final int TYPE_EVENT = 3;
    int type;
    long id;
    Weather weather;
    PlayList playList;
    EventList eventList;

    public HomeCard(int type, long id) {
        this.type = type;
        this.id = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public PlayList getPlayList() {
        return playList;
    }

    public void setPlayList(PlayList playList) {
        this.playList = playList;
    }

    public EventList getEventList() {
        return eventList;
    }

    public void setEventList(EventList eventList) {
        this.eventList = eventList;
    }
}
