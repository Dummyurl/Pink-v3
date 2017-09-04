package com.anglll.pink.data.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by yuan on 2017/9/4 0004.
 */
@Entity
public class JoinArWithSong {
    @Id(autoincrement = true)
    public Long id;
    public Long ar_id;
    public Long song_id;
    @Generated(hash = 27811185)
    public JoinArWithSong(Long id, Long ar_id, Long song_id) {
        this.id = id;
        this.ar_id = ar_id;
        this.song_id = song_id;
    }
    @Generated(hash = 1657456410)
    public JoinArWithSong() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getAr_id() {
        return this.ar_id;
    }
    public void setAr_id(Long ar_id) {
        this.ar_id = ar_id;
    }
    public Long getSong_id() {
        return this.song_id;
    }
    public void setSong_id(Long song_id) {
        this.song_id = song_id;
    }
}
