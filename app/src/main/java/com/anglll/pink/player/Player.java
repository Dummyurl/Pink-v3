package com.anglll.pink.player;

import android.media.MediaPlayer;
import android.os.Handler;
import android.support.annotation.NonNull;

import com.anglll.pink.data.model.Song;
import com.anglll.pink.data.model.SongList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuan on 2017/9/16 0016.
 */

public class Player implements MediaPlayer.OnPreparedListener,
        MediaPlayer.OnCompletionListener, IPlayback {
    private static volatile Player instance;

    private MediaPlayer mediaPlayer;
    private PlayMode mPlayMode = PlayMode.LIST;
    private SongList songList;
    private boolean isPaused;
    private int playProgress;
    private List<Callback> callbacks = new ArrayList<>();
    private Handler handler = new Handler();
    private boolean isRunning = false;


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
        notifyPlayComplete();
        playNext();
    }

    @Override
    public void onPrepared(MediaPlayer mediaPlayer) {
        if (playProgress <= 0 || playProgress <= songList.getPlayingSong().getDuration())
            mediaPlayer.seekTo(playProgress);
        mediaPlayer.start();
        isPaused = false;
        notifyPlayStatusChanged();
    }

    @Override
    public boolean play() {
        if (isPaused && mediaPlayer != null) {
            mediaPlayer.start();
            isPaused = false;
            notifyPlayStatusChanged();
            return true;
        }
        if (mediaPlayer == null) {
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setOnPreparedListener(this);
            mediaPlayer.setOnCompletionListener(this);
        }

        if (!songList.prepare()) {
            isPaused = true;
            notifyPlayStatusChanged();
            return false;
        }
        Song song = songList.getPlayingSong();
        try {
            mediaPlayer.reset();
            mediaPlayer.setDataSource(song.getPath());
            mediaPlayer.prepareAsync();
            isPaused = false;
            return true;
        } catch (IOException e) {
            isPaused = true;
            return false;
        } finally {
            notifyPlayStatusChanged();
        }
    }

    @Override
    public boolean play(@NonNull SongList songList) {
        playProgress = 0;
        this.songList = songList;
        return play();
    }

    public void setSongList(@NonNull SongList songList) {
        this.songList = songList;
    }

    @Override
    public boolean play(int index) {
        if (index < 0 || index >= this.songList.getNumOfSongs())
            return false;
        playProgress = 0;
        this.songList.setPlayIndex(index);
        return play();
    }

    @Override
    public boolean playLast() {
        playProgress = 0;
        boolean hasLast = songList.hasLast();
        if (hasLast) {
            songList.last(mPlayMode);
            notifySwitchLast(songList.getPlayingSong());
            play();
            return true;
        }
        return false;
    }

    @Override
    public boolean playNext() {
        playProgress = 0;
        isPaused = false;
        boolean hasNext = songList.hasNext(mPlayMode);
        if (hasNext) {
            songList.next(mPlayMode);
            notifySwitchNext(songList.getPlayingSong());
            play();
            return true;
        }
        return false;
    }

    @Override
    public boolean pause() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            isPaused = true;
            notifyPlayStatusChanged();
            return true;
        }
        return false;
    }

    @Override
    public boolean isPlaying() {
        if (mediaPlayer == null || !mediaPlayer.isPlaying())
            return false;
        return true;
    }

    @Override
    public int getProgress() {
        return mediaPlayer.getCurrentPosition();
    }

    @Override
    public Song getPlayingSong() {
        return songList.getPlayingSong();
    }

    @Override
    public boolean seekTo(int progress) {
        Song currentSong = songList.getPlayingSong();
        if (currentSong != null) {
            if (currentSong.getDuration() <= progress) {
                onCompletion(mediaPlayer);
            } else {
                mediaPlayer.seekTo(progress);
            }
            return true;
        }
        return false;
    }

    @Override
    public PlayMode getPlayMode() {
        return mPlayMode;
    }

    @Override
    public void setPlayMode(PlayMode playMode) {
        this.mPlayMode = playMode;
    }

    @Override
    public void releasePlayer() {
        if (mediaPlayer == null)
            return;
        pause();
        removeCallbacks();
        mediaPlayer.stop();
        mediaPlayer.release();
        mediaPlayer = null;
    }

    public void removeCallbacks() {
        callbacks.clear();
    }

    @Override
    public void addCallback(Callback callback) {
        callbacks.add(callback);
    }

    @Override
    public void removeCallback(Callback callback) {
        callbacks.remove(callback);
    }

    private void notifySwitchLast(@NonNull Song last) {
        for (Callback callback : callbacks)
            callback.onSwitchLast(last);
    }

    private void notifySwitchNext(@NonNull Song next) {
        for (Callback callback : callbacks)
            callback.onSwitchNext(next);
    }

    private void notifyPlayComplete() {
        for (Callback callback : callbacks)
            callback.onPlayComplete();
    }

    public void setVolume(float left, float right) {
        if (mediaPlayer != null && mediaPlayer.isPlaying())
            mediaPlayer.setVolume(left, right);
    }

    private void notifyPlayStatusChanged() {
        if (isPaused && isRunning) {
            handler.removeCallbacks(playRunnable);
            isRunning = false;
        }
        if (!isPaused && !isRunning) {
            handler.post(playRunnable);
            isRunning = true;
        }
        for (Callback callback : callbacks)
            callback.onPlayStatusChanged(!isPaused);
    }

    private void notifyProgressChanged(int progress, int total) {
        for (Callback callback : callbacks)
            callback.onProgressChanged(progress, total);
    }

    private Runnable playRunnable = new Runnable() {
        @Override
        public void run() {
            notifyProgressChanged(mediaPlayer.getCurrentPosition(), mediaPlayer.getDuration());
            handler.postDelayed(playRunnable, 1000);
        }
    };

}
