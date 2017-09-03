package com.anglll.pink.data.model;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.util.List;

/**
 * Created by yuan on 2017/8/8.
 */
@Entity
public class Song{

    /**
     * name : Let It Go
     * id : 28031119
     * ar : [{"id":60841,"name":"Idina Menzel","tns":[""],"alias":[""]}]
     * alia : ["《冰雪奇缘》插曲"]
     * al : {"id":2715905,"name":"Frozen (Original Motion Picture Soundtrack / Deluxe Edition)","picUrl":"http://p1.music.126.net/p54vIlo105Nz0F0V5vyYRg==/19150194021209209.jpg","tns":["冰雪奇缘"],"pic_str":"19150194021209209","pic":19150194021209210}
     * dt : 224626
     * copyright : 1
     * tns : ["放手吧"]
     */

    private String name;
    @Id
    private Long id;
    private AlBean al;
    private int dt;
    private int copyright;
    private List<ArBean> ar;
    private List<String> alia;
    private List<String> tns;
    private String path;
    private long songListId;

    public long getSongListId() {
        return songListId;
    }

    public void setSongListId(long songListId) {
        this.songListId = songListId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public AlBean getAl() {
        return al;
    }

    public void setAl(AlBean al) {
        this.al = al;
    }

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public int getCopyright() {
        return copyright;
    }

    public void setCopyright(int copyright) {
        this.copyright = copyright;
    }

    public List<ArBean> getAr() {
        return ar;
    }

    public void setAr(List<ArBean> ar) {
        this.ar = ar;
    }

    public List<String> getAlia() {
        return alia;
    }

    public void setAlia(List<String> alia) {
        this.alia = alia;
    }

    public List<String> getTns() {
        return tns;
    }

    public void setTns(List<String> tns) {
        this.tns = tns;
    }

    public static class AlBean {
        /**
         * id : 2715905
         * name : Frozen (Original Motion Picture Soundtrack / Deluxe Edition)
         * picUrl : http://p1.music.126.net/p54vIlo105Nz0F0V5vyYRg==/19150194021209209.jpg
         * tns : ["冰雪奇缘"]
         * pic_str : 19150194021209209
         * pic : 19150194021209210
         */

        private int id;
        private String name;
        private String picUrl;
        private String pic_str;
        private long pic;
        private List<String> tns;

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

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getPic_str() {
            return pic_str;
        }

        public void setPic_str(String pic_str) {
            this.pic_str = pic_str;
        }

        public long getPic() {
            return pic;
        }

        public void setPic(long pic) {
            this.pic = pic;
        }

        public List<String> getTns() {
            return tns;
        }

        public void setTns(List<String> tns) {
            this.tns = tns;
        }
    }

    public static class ArBean {
        /**
         * id : 60841
         * name : Idina Menzel
         * tns : [""]
         * alias : [""]
         */

        private int id;
        private String name;
        private List<String> tns;
        private List<String> alias;

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

        public List<String> getTns() {
            return tns;
        }

        public void setTns(List<String> tns) {
            this.tns = tns;
        }

        public List<String> getAlias() {
            return alias;
        }

        public void setAlias(List<String> alias) {
            this.alias = alias;
        }
    }
}
