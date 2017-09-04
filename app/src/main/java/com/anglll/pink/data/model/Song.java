package com.anglll.pink.data.model;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.JoinEntity;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.ToOne;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import com.anglll.pink.data.db.DaoSession;
import com.anglll.pink.data.db.ArBeanDao;
import com.anglll.pink.data.db.AlBeanDao;
import org.greenrobot.greendao.annotation.NotNull;
import com.anglll.pink.data.db.SongDao;

/**
 * Created by yuan on 2017/8/8.
 */
@Entity
public class Song {

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

    public String name;
    @Id
    public Long id;
    public long al_id;
    @ToOne(joinProperty = "al_id")
    public AlBean al;
    public int dt;
    public int copyright;
    @ToMany
    @JoinEntity(
            entity = JoinArWithSong.class,
            sourceProperty = "song_id",
            targetProperty = "ar_id"
    )
    public List<ArBean> ar;
    public String path;

    @Index(unique = true)
    public long songListId;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1369727947)
    private transient SongDao myDao;

    @Generated(hash = 332612565)
    public Song(String name, Long id, long al_id, int dt, int copyright, String path, long songListId) {
        this.name = name;
        this.id = id;
        this.al_id = al_id;
        this.dt = dt;
        this.copyright = copyright;
        this.path = path;
        this.songListId = songListId;
    }

    @Generated(hash = 87031450)
    public Song() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getAl_id() {
        return this.al_id;
    }

    public void setAl_id(long al_id) {
        this.al_id = al_id;
    }

    public int getDt() {
        return this.dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public int getCopyright() {
        return this.copyright;
    }

    public void setCopyright(int copyright) {
        this.copyright = copyright;
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

    @Generated(hash = 1211076505)
    private transient Long al__resolvedKey;

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1560841298)
    public AlBean getAl() {
        long __key = this.al_id;
        if (al__resolvedKey == null || !al__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            AlBeanDao targetDao = daoSession.getAlBeanDao();
            AlBean alNew = targetDao.load(__key);
            synchronized (this) {
                al = alNew;
                al__resolvedKey = __key;
            }
        }
        return al;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1315865755)
    public void setAl(@NotNull AlBean al) {
        if (al == null) {
            throw new DaoException("To-one property 'al_id' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.al = al;
            al_id = al.getId();
            al__resolvedKey = al_id;
        }
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1848538540)
    public List<ArBean> getAr() {
        if (ar == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ArBeanDao targetDao = daoSession.getArBeanDao();
            List<ArBean> arNew = targetDao._querySong_Ar(id);
            synchronized (this) {
                if (ar == null) {
                    ar = arNew;
                }
            }
        }
        return ar;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 127437506)
    public synchronized void resetAr() {
        ar = null;
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 767980484)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getSongDao() : null;
    }
   
}
