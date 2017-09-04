package com.anglll.pink.data.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;


/**
 * Created by yuan on 2017/8/22 0022.
 */
@Entity
public class Creator {

    /**
     * defaultAvatar : false
     * province : 310000
     * authStatus : 0
     * followed : false
     * avatarUrl : http://p1.music.126.net/mflxm5xc8W_8-oh9-JQZ7w==/1393081236973092.jpg
     * accountStatus : 0
     * gender : 1
     * city : 310101
     * birthday : 603907200000
     * userId : 2198975
     * userType : 0
     * nickname : 舞红铃
     * signature : 音乐是一种太过容易感人的艺术，一个小调，一个旋律，一段节奏，一支歌，都足以让我们感同身受。无论快乐，悲伤，郁郁，宁静，无论哪一种心境，你都能找到一首音乐来抒写此时此刻的人生情怀。——前AcFun创业团队主编，现轻文轻小说主编。
     * description :
     * detailDescription :
     * avatarImgId : 1393081236973092
     * backgroundImgId : 2002210674180200
     * backgroundUrl : http://p1.music.126.net/45Nu4EqvFqK_kQj6BkPwcw==/2002210674180200.jpg
     * authority : 0
     * mutual : false
     * expertTags : ["日语","轻音乐","ACG"]
     * djStatus : 0
     * vipType : 0
     * avatarImgIdStr : 1393081236973092
     * backgroundImgIdStr : 2002210674180200
     */

    public boolean defaultAvatar;
    public int province;
    public int authStatus;
    public boolean followed;
    public String avatarUrl;
    public int accountStatus;
    public int gender;
    public int city;
    public long birthday;
    @Id
    public Long userId;
    public int userType;
    public String nickname;
    public String signature;
    public String description;
    public String detailDescription;
    public long avatarImgId;
    public long backgroundImgId;
    public String backgroundUrl;
    public int authority;
    public boolean mutual;
    public int djStatus;
    public int vipType;
    public String avatarImgIdStr;
    public String backgroundImgIdStr;
    @Generated(hash = 166743735)
    public Creator(boolean defaultAvatar, int province, int authStatus, boolean followed, String avatarUrl, int accountStatus,
            int gender, int city, long birthday, Long userId, int userType, String nickname, String signature, String description,
            String detailDescription, long avatarImgId, long backgroundImgId, String backgroundUrl, int authority, boolean mutual,
            int djStatus, int vipType, String avatarImgIdStr, String backgroundImgIdStr) {
        this.defaultAvatar = defaultAvatar;
        this.province = province;
        this.authStatus = authStatus;
        this.followed = followed;
        this.avatarUrl = avatarUrl;
        this.accountStatus = accountStatus;
        this.gender = gender;
        this.city = city;
        this.birthday = birthday;
        this.userId = userId;
        this.userType = userType;
        this.nickname = nickname;
        this.signature = signature;
        this.description = description;
        this.detailDescription = detailDescription;
        this.avatarImgId = avatarImgId;
        this.backgroundImgId = backgroundImgId;
        this.backgroundUrl = backgroundUrl;
        this.authority = authority;
        this.mutual = mutual;
        this.djStatus = djStatus;
        this.vipType = vipType;
        this.avatarImgIdStr = avatarImgIdStr;
        this.backgroundImgIdStr = backgroundImgIdStr;
    }
    @Generated(hash = 908439796)
    public Creator() {
    }
    public boolean getDefaultAvatar() {
        return this.defaultAvatar;
    }
    public void setDefaultAvatar(boolean defaultAvatar) {
        this.defaultAvatar = defaultAvatar;
    }
    public int getProvince() {
        return this.province;
    }
    public void setProvince(int province) {
        this.province = province;
    }
    public int getAuthStatus() {
        return this.authStatus;
    }
    public void setAuthStatus(int authStatus) {
        this.authStatus = authStatus;
    }
    public boolean getFollowed() {
        return this.followed;
    }
    public void setFollowed(boolean followed) {
        this.followed = followed;
    }
    public String getAvatarUrl() {
        return this.avatarUrl;
    }
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
    public int getAccountStatus() {
        return this.accountStatus;
    }
    public void setAccountStatus(int accountStatus) {
        this.accountStatus = accountStatus;
    }
    public int getGender() {
        return this.gender;
    }
    public void setGender(int gender) {
        this.gender = gender;
    }
    public int getCity() {
        return this.city;
    }
    public void setCity(int city) {
        this.city = city;
    }
    public long getBirthday() {
        return this.birthday;
    }
    public void setBirthday(long birthday) {
        this.birthday = birthday;
    }
    public Long getUserId() {
        return this.userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public int getUserType() {
        return this.userType;
    }
    public void setUserType(int userType) {
        this.userType = userType;
    }
    public String getNickname() {
        return this.nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getSignature() {
        return this.signature;
    }
    public void setSignature(String signature) {
        this.signature = signature;
    }
    public String getDescription() {
        return this.description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDetailDescription() {
        return this.detailDescription;
    }
    public void setDetailDescription(String detailDescription) {
        this.detailDescription = detailDescription;
    }
    public long getAvatarImgId() {
        return this.avatarImgId;
    }
    public void setAvatarImgId(long avatarImgId) {
        this.avatarImgId = avatarImgId;
    }
    public long getBackgroundImgId() {
        return this.backgroundImgId;
    }
    public void setBackgroundImgId(long backgroundImgId) {
        this.backgroundImgId = backgroundImgId;
    }
    public String getBackgroundUrl() {
        return this.backgroundUrl;
    }
    public void setBackgroundUrl(String backgroundUrl) {
        this.backgroundUrl = backgroundUrl;
    }
    public int getAuthority() {
        return this.authority;
    }
    public void setAuthority(int authority) {
        this.authority = authority;
    }
    public boolean getMutual() {
        return this.mutual;
    }
    public void setMutual(boolean mutual) {
        this.mutual = mutual;
    }
    public int getDjStatus() {
        return this.djStatus;
    }
    public void setDjStatus(int djStatus) {
        this.djStatus = djStatus;
    }
    public int getVipType() {
        return this.vipType;
    }
    public void setVipType(int vipType) {
        this.vipType = vipType;
    }
    public String getAvatarImgIdStr() {
        return this.avatarImgIdStr;
    }
    public void setAvatarImgIdStr(String avatarImgIdStr) {
        this.avatarImgIdStr = avatarImgIdStr;
    }
    public String getBackgroundImgIdStr() {
        return this.backgroundImgIdStr;
    }
    public void setBackgroundImgIdStr(String backgroundImgIdStr) {
        this.backgroundImgIdStr = backgroundImgIdStr;
    }
}
