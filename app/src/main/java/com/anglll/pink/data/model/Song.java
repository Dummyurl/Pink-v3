package com.anglll.pink.data.model;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by yuan on 2017/8/8.
 */
@Entity
public class Song {


    /**
     * id : 28031119
     * name : Let It Go
     * ar_id : 60841
     * ar_name : Idina Menzel
     * alia : 《冰雪奇缘》插曲
     * al_id : 2715905
     * al_name : Frozen (Original Motion Picture Soundtrack / Deluxe Edition)
     * al_picUrl : http://p1.music.126.net/p54vIlo105Nz0F0V5vyYRg==/19150194021209209.jpg
     * tns : 放手吧
     */
    public String name;
    @Id
    public Long id;
    public Long ar_id;
    public String ar_name;
    public String alia;
    public Long al_id;
    public String al_name;
    public String al_picUrl;
    public String tns;
    public String path;
    @Index
    public long songListId;
    @Generated(hash = 1966804951)
    public Song(String name, Long id, Long ar_id, String ar_name, String alia, Long al_id,
            String al_name, String al_picUrl, String tns, String path, long songListId) {
        this.name = name;
        this.id = id;
        this.ar_id = ar_id;
        this.ar_name = ar_name;
        this.alia = alia;
        this.al_id = al_id;
        this.al_name = al_name;
        this.al_picUrl = al_picUrl;
        this.tns = tns;
        this.path = path;
        this.songListId = songListId;
    }
    @Generated(hash = 87031450)
    public Song() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getAr_id() {
        return this.ar_id;
    }
    public void setAr_id(Long ar_id) {
        this.ar_id = ar_id;
    }
    public String getAr_name() {
        return this.ar_name;
    }
    public void setAr_name(String ar_name) {
        this.ar_name = ar_name;
    }
    public String getAlia() {
        return this.alia;
    }
    public void setAlia(String alia) {
        this.alia = alia;
    }
    public Long getAl_id() {
        return this.al_id;
    }
    public void setAl_id(Long al_id) {
        this.al_id = al_id;
    }
    public String getAl_name() {
        return this.al_name;
    }
    public void setAl_name(String al_name) {
        this.al_name = al_name;
    }
    public String getAl_picUrl() {
        return this.al_picUrl;
    }
    public void setAl_picUrl(String al_picUrl) {
        this.al_picUrl = al_picUrl;
    }
    public String getTns() {
        return this.tns;
    }
    public void setTns(String tns) {
        this.tns = tns;
    }
    public String getPath() {
        return this.path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    public long getSongListId() {
        return this.songListId;
    }
    public void setSongListId(long songListId) {
        this.songListId = songListId;
    }
}
