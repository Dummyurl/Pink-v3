package com.anglll.pink.data.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuan on 2017/8/22 0022.
 */

public class SuperModel {
    public static final int TYPE_HOME = 0;
    public static final int TYPE_MUSIC = 1;
    public static final int TYPE_VIDEO = 2;
    public int type = TYPE_HOME;
    private List<SongList> songLists = new ArrayList<>();
    private Weather weather;
    private SongList songList;
    private Todo todo;

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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<SongList> getSongLists() {
        return songLists;
    }

    public void setSongLists(List<SongList> songLists) {
        this.songLists = songLists;
    }
}
