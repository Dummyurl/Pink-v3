package com.anglll.pink.data.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class AlBean {
    /**
     * id : 2715905
     * name : Frozen (Original Motion Picture Soundtrack / Deluxe Edition)
     * picUrl : http://p1.music.126.net/p54vIlo105Nz0F0V5vyYRg==/19150194021209209.jpg
     * tns : ["冰雪奇缘"]
     * pic_str : 19150194021209209
     * pic : 19150194021209210
     */
    @Id
    public Long id;
    public String name;
    public String picUrl;
    public String pic_str;
    public long pic;
    @Generated(hash = 1464854023)
    public AlBean(Long id, String name, String picUrl, String pic_str, long pic) {
        this.id = id;
        this.name = name;
        this.picUrl = picUrl;
        this.pic_str = pic_str;
        this.pic = pic;
    }
    @Generated(hash = 1175591457)
    public AlBean() {
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
    public String getPicUrl() {
        return this.picUrl;
    }
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
    public String getPic_str() {
        return this.pic_str;
    }
    public void setPic_str(String pic_str) {
        this.pic_str = pic_str;
    }
    public long getPic() {
        return this.pic;
    }
    public void setPic(long pic) {
        this.pic = pic;
    }
}