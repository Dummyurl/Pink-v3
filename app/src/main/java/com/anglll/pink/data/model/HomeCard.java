package com.anglll.pink.data.model;

import com.anglll.pink.utils.IDUtils;

/**
 * Created by yuan on 2017/8/8 0008.
 */

public class HomeCard {
    public static final int TYPE_WEATHER = 1;
    public static final int TYPE_MUSIC = 2;
    public static final int TYPE_EVENT = 3;
    public long id = IDUtils.generateID();
    private int type;
    private Weather weather;
    private SongList songList;
    private Todo todo;

    public HomeCard(int type) {
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public SongList getSongList() {
        return songList;
    }

    public void setSongList(SongList songList) {
        this.songList = songList;
    }

    public Todo getTodo() {
        return todo;
    }

    public void setTodo(Todo todo) {
        this.todo = todo;
    }
}
