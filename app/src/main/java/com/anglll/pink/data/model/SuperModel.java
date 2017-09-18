package com.anglll.pink.data.model;


import com.anglll.pink.player.PlaybackService;

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
    private List<VideoMain> videoMainList = new ArrayList<>();
    private Weather weather;
    private Todo todo = new Todo();
    private PlaybackService musicPlayer;


    public List<VideoMain> getVideoMainList() {
        return videoMainList;
    }

    public void setVideoMainList(List<VideoMain> videoMainList) {
        this.videoMainList = videoMainList;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public PlaybackService getMusicPlayer() {
        return musicPlayer;
    }

    public void setMusicPlayer(PlaybackService musicPlayer) {
        this.musicPlayer = musicPlayer;
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
