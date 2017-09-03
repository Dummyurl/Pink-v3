package com.anglll.pink.data.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.Transient;

import java.util.List;

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

    private boolean subscribed;
    private Creator creator;
    private int status;
    private boolean ordered;
    private int adType;
    private int userId;
    private int specialType;
    private boolean anonimous;
    private long coverImgId;
    private long createTime;
    private int privacy;
    private boolean newImported;
    private int trackCount;
    private boolean highQuality;
    private long trackUpdateTime;
    private long updateTime;
    private String commentThreadId;
    private String coverImgUrl;
    private int playCount;
    private int totalDuration;
    private long trackNumberUpdateTime;
    private int cloudTrackCount;
    private int subscribedCount;
    private String description;
    private String name;
    @Id
    private Long id;
    private List<String> tags;
    @ToMany(referencedJoinProperty = "songListId")
    private List<Song> playList;
    @Transient
    private int playIndex = -1;

    private Song playingSong;

    public List<Song> getPlayList() {
        return playList;
    }

    public void setPlayList(List<Song> playList) {
        this.playList = playList;
    }

    public int getPlayIndex() {
        return playIndex;
    }

    public void setPlayIndex(int playIndex) {
        this.playIndex = playIndex;
    }

    public Song getPlayingSong() {
        return playingSong;
    }

    public void setPlayingSong(Song playingSong) {
        this.playingSong = playingSong;
    }

    public boolean isSubscribed() {
        return subscribed;
    }

    public void setSubscribed(boolean subscribed) {
        this.subscribed = subscribed;
    }

    public Creator getCreator() {
        return creator;
    }

    public void setCreator(Creator creator) {
        this.creator = creator;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isOrdered() {
        return ordered;
    }

    public void setOrdered(boolean ordered) {
        this.ordered = ordered;
    }

    public int getAdType() {
        return adType;
    }

    public void setAdType(int adType) {
        this.adType = adType;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSpecialType() {
        return specialType;
    }

    public void setSpecialType(int specialType) {
        this.specialType = specialType;
    }

    public boolean isAnonimous() {
        return anonimous;
    }

    public void setAnonimous(boolean anonimous) {
        this.anonimous = anonimous;
    }

    public long getCoverImgId() {
        return coverImgId;
    }

    public void setCoverImgId(long coverImgId) {
        this.coverImgId = coverImgId;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public int getPrivacy() {
        return privacy;
    }

    public void setPrivacy(int privacy) {
        this.privacy = privacy;
    }

    public boolean isNewImported() {
        return newImported;
    }

    public void setNewImported(boolean newImported) {
        this.newImported = newImported;
    }

    public int getTrackCount() {
        return trackCount;
    }

    public void setTrackCount(int trackCount) {
        this.trackCount = trackCount;
    }

    public boolean isHighQuality() {
        return highQuality;
    }

    public void setHighQuality(boolean highQuality) {
        this.highQuality = highQuality;
    }

    public long getTrackUpdateTime() {
        return trackUpdateTime;
    }

    public void setTrackUpdateTime(long trackUpdateTime) {
        this.trackUpdateTime = trackUpdateTime;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public String getCommentThreadId() {
        return commentThreadId;
    }

    public void setCommentThreadId(String commentThreadId) {
        this.commentThreadId = commentThreadId;
    }

    public String getCoverImgUrl() {
        return coverImgUrl;
    }

    public void setCoverImgUrl(String coverImgUrl) {
        this.coverImgUrl = coverImgUrl;
    }

    public int getPlayCount() {
        return playCount;
    }

    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }

    public int getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(int totalDuration) {
        this.totalDuration = totalDuration;
    }

    public long getTrackNumberUpdateTime() {
        return trackNumberUpdateTime;
    }

    public void setTrackNumberUpdateTime(long trackNumberUpdateTime) {
        this.trackNumberUpdateTime = trackNumberUpdateTime;
    }

    public int getCloudTrackCount() {
        return cloudTrackCount;
    }

    public void setCloudTrackCount(int cloudTrackCount) {
        this.cloudTrackCount = cloudTrackCount;
    }

    public int getSubscribedCount() {
        return subscribedCount;
    }

    public void setSubscribedCount(int subscribedCount) {
        this.subscribedCount = subscribedCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
