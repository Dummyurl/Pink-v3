package com.anglll.pink.data.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

import java.io.Serializable;

/**
 * Created by yuan on 2017/9/5 0005.
 */
@Entity
public class Creator{

    /**
     * userId : 3361534
     * remarkName :
     * mutual : false
     * nickname : 雨雾庵
     * accountStatus : 0
     * province : 410000
     * defaultAvatar : false
     * avatarUrl : http://p1.music.126.net/pQaNQcrY_LABKVzCH9JbBQ==/2917004350573679.jpg
     * gender : 1
     * birthday : 631154619850
     * city : 410100
     * avatarImgId : 2917004350573679
     * backgroundImgId : 2002210674180203
     * userType : 0
     * vipType : 0
     * authStatus : 0
     * avatarImgIdStr : 2917004350573679
     * backgroundImgIdStr : 2002210674180203
     * backgroundUrl : http://p1.music.126.net/bmA_ablsXpq3Tk9HlEg9sA==/2002210674180203.jpg
     * description :
     * detailDescription :
     * djStatus : 0
     * followed : false
     * signature : 我很懒的！
     * authority : 0
     * followeds : 3
     * follows : 2
     * blacklist : false
     * eventCount : 2
     * playlistCount : 6
     * playlistBeSubscribedCount : 0
     */
@Id
    public Long userId;
    public String remarkName;
    public boolean mutual;
    public String nickname;
    public int accountStatus;
    public int province;
    public boolean defaultAvatar;
    public String avatarUrl;
    public int gender;
    public long birthday;
    public int city;
    public long avatarImgId;
    public long backgroundImgId;
    public int userType;
    public int vipType;
    public int authStatus;
    public String avatarImgIdStr;
    public String backgroundImgIdStr;
    public String backgroundUrl;
    public String description;
    public String detailDescription;
    public int djStatus;
    public boolean followed;
    public String signature;
    public int authority;
    public int followeds;
    public int follows;
    public boolean blacklist;
    public int eventCount;
    public int playlistCount;
    public int playlistBeSubscribedCount;

    @Generated(hash = 1654541440)
    public Creator(Long userId, String remarkName, boolean mutual, String nickname,
            int accountStatus, int province, boolean defaultAvatar, String avatarUrl,
            int gender, long birthday, int city, long avatarImgId, long backgroundImgId,
            int userType, int vipType, int authStatus, String avatarImgIdStr,
            String backgroundImgIdStr, String backgroundUrl, String description,
            String detailDescription, int djStatus, boolean followed, String signature,
            int authority, int followeds, int follows, boolean blacklist, int eventCount,
            int playlistCount, int playlistBeSubscribedCount) {
        this.userId = userId;
        this.remarkName = remarkName;
        this.mutual = mutual;
        this.nickname = nickname;
        this.accountStatus = accountStatus;
        this.province = province;
        this.defaultAvatar = defaultAvatar;
        this.avatarUrl = avatarUrl;
        this.gender = gender;
        this.birthday = birthday;
        this.city = city;
        this.avatarImgId = avatarImgId;
        this.backgroundImgId = backgroundImgId;
        this.userType = userType;
        this.vipType = vipType;
        this.authStatus = authStatus;
        this.avatarImgIdStr = avatarImgIdStr;
        this.backgroundImgIdStr = backgroundImgIdStr;
        this.backgroundUrl = backgroundUrl;
        this.description = description;
        this.detailDescription = detailDescription;
        this.djStatus = djStatus;
        this.followed = followed;
        this.signature = signature;
        this.authority = authority;
        this.followeds = followeds;
        this.follows = follows;
        this.blacklist = blacklist;
        this.eventCount = eventCount;
        this.playlistCount = playlistCount;
        this.playlistBeSubscribedCount = playlistBeSubscribedCount;
    }

    @Generated(hash = 908439796)
    public Creator() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRemarkName() {
        return remarkName;
    }

    public void setRemarkName(String remarkName) {
        this.remarkName = remarkName;
    }

    public boolean isMutual() {
        return mutual;
    }

    public void setMutual(boolean mutual) {
        this.mutual = mutual;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(int accountStatus) {
        this.accountStatus = accountStatus;
    }

    public int getProvince() {
        return province;
    }

    public void setProvince(int province) {
        this.province = province;
    }

    public boolean isDefaultAvatar() {
        return defaultAvatar;
    }

    public void setDefaultAvatar(boolean defaultAvatar) {
        this.defaultAvatar = defaultAvatar;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public long getBirthday() {
        return birthday;
    }

    public void setBirthday(long birthday) {
        this.birthday = birthday;
    }

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    public long getAvatarImgId() {
        return avatarImgId;
    }

    public void setAvatarImgId(long avatarImgId) {
        this.avatarImgId = avatarImgId;
    }

    public long getBackgroundImgId() {
        return backgroundImgId;
    }

    public void setBackgroundImgId(long backgroundImgId) {
        this.backgroundImgId = backgroundImgId;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public int getVipType() {
        return vipType;
    }

    public void setVipType(int vipType) {
        this.vipType = vipType;
    }

    public int getAuthStatus() {
        return authStatus;
    }

    public void setAuthStatus(int authStatus) {
        this.authStatus = authStatus;
    }

    public String getAvatarImgIdStr() {
        return avatarImgIdStr;
    }

    public void setAvatarImgIdStr(String avatarImgIdStr) {
        this.avatarImgIdStr = avatarImgIdStr;
    }

    public String getBackgroundImgIdStr() {
        return backgroundImgIdStr;
    }

    public void setBackgroundImgIdStr(String backgroundImgIdStr) {
        this.backgroundImgIdStr = backgroundImgIdStr;
    }

    public String getBackgroundUrl() {
        return backgroundUrl;
    }

    public void setBackgroundUrl(String backgroundUrl) {
        this.backgroundUrl = backgroundUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetailDescription() {
        return detailDescription;
    }

    public void setDetailDescription(String detailDescription) {
        this.detailDescription = detailDescription;
    }

    public int getDjStatus() {
        return djStatus;
    }

    public void setDjStatus(int djStatus) {
        this.djStatus = djStatus;
    }

    public boolean isFollowed() {
        return followed;
    }

    public void setFollowed(boolean followed) {
        this.followed = followed;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public int getAuthority() {
        return authority;
    }

    public void setAuthority(int authority) {
        this.authority = authority;
    }

    public int getFolloweds() {
        return followeds;
    }

    public void setFolloweds(int followeds) {
        this.followeds = followeds;
    }

    public int getFollows() {
        return follows;
    }

    public void setFollows(int follows) {
        this.follows = follows;
    }

    public boolean isBlacklist() {
        return blacklist;
    }

    public void setBlacklist(boolean blacklist) {
        this.blacklist = blacklist;
    }

    public int getEventCount() {
        return eventCount;
    }

    public void setEventCount(int eventCount) {
        this.eventCount = eventCount;
    }

    public int getPlaylistCount() {
        return playlistCount;
    }

    public void setPlaylistCount(int playlistCount) {
        this.playlistCount = playlistCount;
    }

    public int getPlaylistBeSubscribedCount() {
        return playlistBeSubscribedCount;
    }

    public void setPlaylistBeSubscribedCount(int playlistBeSubscribedCount) {
        this.playlistBeSubscribedCount = playlistBeSubscribedCount;
    }

    public boolean getMutual() {
        return this.mutual;
    }

    public boolean getDefaultAvatar() {
        return this.defaultAvatar;
    }

    public boolean getFollowed() {
        return this.followed;
    }

    public boolean getBlacklist() {
        return this.blacklist;
    }
}
