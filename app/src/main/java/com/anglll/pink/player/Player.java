package com.anglll.pink.player;

import android.media.MediaPlayer;

import com.anglll.pink.data.model.Song;
import com.anglll.pink.data.model.SongList;

/**
 * Created by yuan on 2017/9/16 0016.
 */

public class Player implements MediaPlayer.OnPreparedListener,
        MediaPlayer.OnCompletionListener,IPlayback {
    private static volatile Player instance;

    private MediaPlayer mediaPlayer;
    private SongList songList;


    private Player() {
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setOnPreparedListener(this);
        mediaPlayer.setOnCompletionListener(this);
    }

    public static Player getInstance() {
        synchronized (Player.class) {
            if (instance == null)
                instance = new Player();
        }
        return instance;
    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {

    }

    @Override
    public void onPrepared(MediaPlayer mediaPlayer) {

    }

    @Override
    public boolean play() {
        return false;
    }

    @Override
    public boolean play(SongList songList) {
        return false;
    }

    @Override
    public boolean play(SongList songList, int index) {
        return false;
    }

    @Override
    public boolean play(Song song) {
        return false;
    }

    @Override
    public boolean playLast() {
        return false;
    }

    @Override
    public boolean playNext() {
        return false;
    }

    @Override
    public boolean pause() {
        return false;
    }

    @Override
    public boolean isPlaying() {
        return false;
    }

    @Override
    public int getProgress() {
        return 0;
    }

    @Override
    public Song getPlayingSong() {
        return null;
    }

    @Override
    public boolean seeTo(int progress) {
        return false;
    }

    @Override
    public PlayMode getPlayMode() {
        return null;
    }

    @Override
    public void switchPlayMode() {

    }

    @Override
    public void releasePlayer() {

    }

    @Override
    public void removeCallbacks() {

    }

    @Override
    public void addCallback(Callback callback) {

    }

    @Override
    public void removeCallback(Callback callback) {

    }
}
