package com.anglll.pink.data.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.OrderBy;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Transient;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

import com.anglll.pink.data.db.DaoSession;
import com.anglll.pink.data.db.CreatorDao;
import com.anglll.pink.data.db.SongListDao;
import com.anglll.pink.data.db.SongDao;
import com.anglll.pink.player.PlayMode;

/**
 * Created by yuan on 2017/8/22 0022.
 */
@Entity
public class SongList {

    /**
     * subscribed : false
     * creator : null
     * status : 0
     * ordered : true
     * tags : ["日语","轻音乐","ACG"]
     * adType : 0
     * userId : 2198975
     * specialType : 0
     * anonimous : false
     * coverImgId : 6062707115744662
     * createTime : 1396084145587
     * privacy : 0
     * newImported : false
     * trackCount : 374
     * highQuality : false
     * trackUpdateTime : 1503080456707
     * updateTime : 1503079920429
     * commentThreadId : A_PL_0_10602549
     * coverImgUrl : http://p1.music.126.net/7sZ5WjNooQZ53-JHiTClkw==/6062707115744662.jpg
     * playCount : 2465170
     * totalDuration : 0
     * trackNumberUpdateTime : 1503079920429
     * cloudTrackCount : 0
     * subscribedCount : 132495
     * description : 怪力乱神静海现，月都飘摇鬼神殇。民智渐开妖仙绝，神龙八贤隐神迹。
     * 阴阳结界锁瀛东，博丽自祭终乱世。梦想天生幻想乡，符卡天则佑众生。
     * 红雾蔽日洋馆出，血族幼裔探天机。幽冥亡女守玉楼，墨染枯木不知春。
     * 罪饮蓬莱绝仙路，自锁幽林火凤怒。花塚葬灵传甲子，三途河畔叹阎罗。
     * 蛙蛇相争神国分，信仰绝断诸神刎。法界业火煅佛身，宝船东渡铸山门。
     * 苏我物部争佛陨，阐截圣德尸还魂。小槌逆命末裔呼，万宝难助辉针覆。
     * 绀珠黄粱空余泪，怨憎纯化月宫坠。
     * ——自作打油诗半首，待来日补足，以祭往日幻想之梦。
     * name : 東方百首神曲集
     * id : 10602549
     */

    public boolean subscribed;
    public Long creator_id;
    @ToOne(joinProperty = "creator_id")
    @NotNull
    public Creator creator;
    public int status;
    public boolean ordered;
    public int adType;
    public int userId;
    public int specialType;
    public boolean anonimous;
    public long coverImgId;
    public long createTime;
    public int privacy;
    public boolean newImported;
    public int trackCount;
    public boolean highQuality;
    public long trackUpdateTime;
    public long updateTime;
    public String commentThreadId;
    public String coverImgUrl;
    public int playCount;
    public int totalDuration;
    public long trackNumberUpdateTime;
    public int cloudTrackCount;
    public int subscribedCount;
    public String description;
    public String name;
    @Id
    public Long id;
    @ToMany(referencedJoinProperty = "songListId")
    @OrderBy("index ASC")
    public List<Song> playList;
    @Transient
    private static final int NO_POSITION = -1;
    @Transient
    public int playIndex = 0;
    @Transient
    public Song playingSong;
    /**
     * Used to resolve relations
     */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /**
     * Used for active entity operations.
     */
    @Generated(hash = 741189411)
    private transient SongListDao myDao;

    @Generated(hash = 1151245159)
    public SongList(boolean subscribed, Long creator_id, int status, boolean ordered,
                    int adType, int userId, int specialType, boolean anonimous, long coverImgId,
                    long createTime, int privacy, boolean newImported, int trackCount,
                    boolean highQuality, long trackUpdateTime, long updateTime,
                    String commentThreadId, String coverImgUrl, int playCount, int totalDuration,
                    long trackNumberUpdateTime, int cloudTrackCount, int subscribedCount,
                    String description, String name, Long id) {
        this.subscribed = subscribed;
        this.creator_id = creator_id;
        this.status = status;
        this.ordered = ordered;
        this.adType = adType;
        this.userId = userId;
        this.specialType = specialType;
        this.anonimous = anonimous;
        this.coverImgId = coverImgId;
        this.createTime = createTime;
        this.privacy = privacy;
        this.newImported = newImported;
        this.trackCount = trackCount;
        this.highQuality = highQuality;
        this.trackUpdateTime = trackUpdateTime;
        this.updateTime = updateTime;
        this.commentThreadId = commentThreadId;
        this.coverImgUrl = coverImgUrl;
        this.playCount = playCount;
        this.totalDuration = totalDuration;
        this.trackNumberUpdateTime = trackNumberUpdateTime;
        this.cloudTrackCount = cloudTrackCount;
        this.subscribedCount = subscribedCount;
        this.description = description;
        this.name = name;
        this.id = id;
    }

    @Generated(hash = 1144407077)
    public SongList() {
    }

    public boolean getSubscribed() {
        return this.subscribed;
    }

    public void setSubscribed(boolean subscribed) {
        this.subscribed = subscribed;
    }

    public Long getCreator_id() {
        return this.creator_id;
    }

    public void setCreator_id(Long creator_id) {
        this.creator_id = creator_id;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean getOrdered() {
        return this.ordered;
    }

    public void setOrdered(boolean ordered) {
        this.ordered = ordered;
    }

    public int getAdType() {
        return this.adType;
    }

    public void setAdType(int adType) {
        this.adType = adType;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSpecialType() {
        return this.specialType;
    }

    public void setSpecialType(int specialType) {
        this.specialType = specialType;
    }

    public boolean getAnonimous() {
        return this.anonimous;
    }

    public void setAnonimous(boolean anonimous) {
        this.anonimous = anonimous;
    }

    public long getCoverImgId() {
        return this.coverImgId;
    }

    public void setCoverImgId(long coverImgId) {
        this.coverImgId = coverImgId;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public int getPrivacy() {
        return this.privacy;
    }

    public void setPrivacy(int privacy) {
        this.privacy = privacy;
    }

    public boolean getNewImported() {
        return this.newImported;
    }

    public void setNewImported(boolean newImported) {
        this.newImported = newImported;
    }

    public int getTrackCount() {
        return this.trackCount;
    }

    public void setTrackCount(int trackCount) {
        this.trackCount = trackCount;
    }

    public boolean getHighQuality() {
        return this.highQuality;
    }

    public void setHighQuality(boolean highQuality) {
        this.highQuality = highQuality;
    }

    public long getTrackUpdateTime() {
        return this.trackUpdateTime;
    }

    public void setTrackUpdateTime(long trackUpdateTime) {
        this.trackUpdateTime = trackUpdateTime;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public String getCommentThreadId() {
        return this.commentThreadId;
    }

    public void setCommentThreadId(String commentThreadId) {
        this.commentThreadId = commentThreadId;
    }

    public String getCoverImgUrl() {
        return this.coverImgUrl;
    }

    public void setCoverImgUrl(String coverImgUrl) {
        this.coverImgUrl = coverImgUrl;
    }

    public int getPlayCount() {
        return this.playCount;
    }

    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }

    public int getTotalDuration() {
        return this.totalDuration;
    }

    public void setTotalDuration(int totalDuration) {
        this.totalDuration = totalDuration;
    }

    public long getTrackNumberUpdateTime() {
        return this.trackNumberUpdateTime;
    }

    public void setTrackNumberUpdateTime(long trackNumberUpdateTime) {
        this.trackNumberUpdateTime = trackNumberUpdateTime;
    }

    public int getCloudTrackCount() {
        return this.cloudTrackCount;
    }

    public void setCloudTrackCount(int cloudTrackCount) {
        this.cloudTrackCount = cloudTrackCount;
    }

    public int getSubscribedCount() {
        return this.subscribedCount;
    }

    public void setSubscribedCount(int subscribedCount) {
        this.subscribedCount = subscribedCount;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public int getPlayIndex() {
        return playIndex;
    }

    public void setPlayIndex(int playIndex) {
        this.playIndex = playIndex;
    }

    public Song getPlayingSong() {
        if(playingSong == null)
            playingSong = playList.get(playIndex);
        return playingSong;
    }

    public boolean hasNext(PlayMode playMode) {
        if (getPlayList().isEmpty())
            return false;
        if (playMode == PlayMode.LIST && playIndex >= getPlayList().size())
            return false;
        return true;
    }

    public void next(PlayMode playMode) {
        switch (playMode) {
            case LIST:
                playIndex = playIndex + 1 >= getNumOfSongs() ? 0 : playIndex + 1;
                break;
            case SINGLE:
                break;
            case SHUFFLE:
                playIndex = randomPlayIndex();
                break;
        }
        playingSong = getPlayList().get(playIndex);
    }

    private int randomPlayIndex() {
        int randomIndex = new Random().nextInt(getPlayList().size());
        if (getPlayList().size() > 1 && randomIndex == playIndex) {
            randomPlayIndex();
        }
        return randomIndex;
    }

    public void setPlayingSong(Song playingSong) {
        this.playingSong = playingSong;
    }

    public boolean prepare() {
        if (this.getPlayList() == null || this.getPlayList().isEmpty())
            return false;
        if (playIndex == NO_POSITION)
            playIndex = 0;
        return true;
    }

    @Generated(hash = 1767171241)
    private transient Long creator__resolvedKey;

    /**
     * To-one relationship, resolved on first access.
     */
    @Generated(hash = 324074231)
    public Creator getCreator() {
        Long __key = this.creator_id;
        if (creator__resolvedKey == null || !creator__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            CreatorDao targetDao = daoSession.getCreatorDao();
            Creator creatorNew = targetDao.load(__key);
            synchronized (this) {
                creator = creatorNew;
                creator__resolvedKey = __key;
            }
        }
        return creator;
    }

    /**
     * called by internal mechanisms, do not call yourself.
     */
    @Generated(hash = 487346457)
    public void setCreator(Creator creator) {
        synchronized (this) {
            this.creator = creator;
            creator_id = creator == null ? null : creator.getUserId();
            creator__resolvedKey = creator_id;
        }
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 493600516)
    public List<Song> getPlayList() {
        if (playList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            SongDao targetDao = daoSession.getSongDao();
            List<Song> playListNew = targetDao._querySongList_PlayList(id);
            synchronized (this) {
                if (playList == null) {
                    playList = playListNew;
                }
            }
        }
        return playList;
    }

    /**
     * Resets a to-many relationship, making the next get call to query for a fresh result.
     */
    @Generated(hash = 640270382)
    public synchronized void resetPlayList() {
        playList = null;
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

    /**
     * called by internal mechanisms, do not call yourself.
     */
    @Generated(hash = 1874485990)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getSongListDao() : null;
    }

    public int getNumOfSongs() {
        if (this.playList == null)
            return 0;
        return this.playList.size();
    }

    public boolean hasLast() {
        return playList != null && playList.size() != 0;
    }

    public void last(PlayMode playMode) {
        switch (playMode) {
            case LIST:
                playIndex = playIndex + 1 >= getNumOfSongs() ? 0 : playIndex + 1;
                break;
            case SINGLE:
                break;
            case SHUFFLE:
                playIndex = randomPlayIndex();
                break;
        }
        playingSong = playList.get(playIndex);
    }
}
