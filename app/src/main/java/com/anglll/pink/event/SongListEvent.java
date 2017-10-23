package com.anglll.pink.event;

import com.anglll.pink.data.model.SongList;

/**
 * Created by yuan on 2017/10/23 0023.
 */

public class SongListEvent {
    private SongList songList;

    public SongListEvent(SongList songList) {
        this.songList = songList;
    }

    public SongList getSongList() {
        return songList;
    }
}
