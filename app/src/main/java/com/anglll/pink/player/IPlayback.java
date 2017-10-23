package com.anglll.pink.player;

import android.support.annotation.Nullable;

import com.anglll.pink.data.model.Song;
import com.anglll.pink.data.model.SongList;

/**
 * Created by yuan on 2017/9/16 0016.
 */

public interface IPlayback {
    boolean play();

    boolean play(SongList songList);

    boolean playLast();

    boolean playNext();

    boolean pause();

    boolean isPlaying();

    int getProgress();

    Song getPlayingSong();

    boolean seekTo(int progress);

    PlayMode getPlayMode();

    void setPlayMode(PlayMode playMode);

    void releasePlayer();

    void addCallback(Callback callback);

    void removeCallback(Callback callback);

    interface Callback {
        void onSwitchLast(@Nullable Song last);

        void onSwitchNext(@Nullable Song next);

        void onPlayComplete();

        void onPlayStatusChanged(boolean isPlaying);

        void onProgressChanged(int progress, int total);
    }
}
