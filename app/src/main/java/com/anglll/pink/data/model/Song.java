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
    @Id
    private int id;
    private String name;
    private int ar_id;
    private String ar_name;
    private String alia;
    private int al_id;
    private String al_name;
    private String al_picUrl;
    private String tns;
    public String path;
    @Index
    public long songListId;

    @Generated(hash = 1108221611)
    public Song(int id, String name, int ar_id, String ar_name, String alia, int al_id,
            String al_name, String al_picUrl, String tns, String path, long songListId) {
        this.id = id;
        this.name = name;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAr_id() {
        return ar_id;
    }

    public void setAr_id(int ar_id) {
        this.ar_id = ar_id;
    }

    public String getAr_name() {
        return ar_name;
    }

    public void setAr_name(String ar_name) {
        this.ar_name = ar_name;
    }

    public String getAlia() {
        return alia;
    }

    public void setAlia(String alia) {
        this.alia = alia;
    }

    public int getAl_id() {
        return al_id;
    }

    public void setAl_id(int al_id) {
        this.al_id = al_id;
    }

    public String getAl_name() {
        return al_name;
    }

    public void setAl_name(String al_name) {
        this.al_name = al_name;
    }

    public String getAl_picUrl() {
        return al_picUrl;
    }

    public void setAl_picUrl(String al_picUrl) {
        this.al_picUrl = al_picUrl;
    }

    public String getTns() {
        return tns;
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
