package com.anglll.pink.player;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.anglll.pink.data.model.Song;
import com.anglll.pink.data.model.SongList;

/**
 * Created by yuan on 2017/9/16 0016.
 */

public interface IPlayback {
    boolean play();

    boolean play(SongList songList);

    boolean play(SongList songList, int index);

    boolean play(Song song);

    boolean playLast();

    boolean playNext();

    boolean pause();

    boolean isPlaying();

    int getProgress();

    Song getPlayingSong();

    boolean seeTo(int progress);

    PlayMode getPlayMode();

    void switchPlayMode();

    void releasePlayer();

    void removeCallbacks();

    void addCallback(Callback callback);

    void removeCallback(Callback callback);

    interface Callback {
        void onSwitchLast(@Nullable Song last);

        void onSwitchNext(@Nullable Song next);

        void onComplete(@Nullable Song next);

        void onPlayStatusChanged(boolean isPlaying);
    }
}
