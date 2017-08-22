package com.anglll.pink.data.model;

import java.util.List;

/**
 * Created by yuan on 2017/8/22 0022.
 */

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

    private boolean defaultAvatar;
    private int province;
    private int authStatus;
    private boolean followed;
    private String avatarUrl;
    private int accountStatus;
    private int gender;
    private int city;
    private long birthday;
    private int userId;
    private int userType;
    private String nickname;
    private String signature;
    private String description;
    private String detailDescription;
    private long avatarImgId;
    private long backgroundImgId;
    private String backgroundUrl;
    private int authority;
    private boolean mutual;
    private int djStatus;
    private int vipType;
    private String avatarImgIdStr;
    private String backgroundImgIdStr;
    private List<String> expertTags;

    public boolean isDefaultAvatar() {
        return defaultAvatar;
    }

    public void setDefaultAvatar(boolean defaultAvatar) {
        this.defaultAvatar = defaultAvatar;
    }

    public int getProvince() {
        return province;
    }

    public void setProvince(int province) {
        this.province = province;
    }

    public int getAuthStatus() {
        return authStatus;
    }

    public void setAuthStatus(int authStatus) {
        this.authStatus = authStatus;
    }

    public boolean isFollowed() {
        return followed;
    }

    public void setFollowed(boolean followed) {
        this.followed = followed;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public int getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(int accountStatus) {
        this.accountStatus = accountStatus;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    public long getBirthday() {
        return birthday;
    }

    public void setBirthday(long birthday) {
        this.birthday = birthday;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
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

    public String getBackgroundUrl() {
        return backgroundUrl;
    }

    public void setBackgroundUrl(String backgroundUrl) {
        this.backgroundUrl = backgroundUrl;
    }

    public int getAuthority() {
        return authority;
    }

    public void setAuthority(int authority) {
        this.authority = authority;
    }

    public boolean isMutual() {
        return mutual;
    }

    public void setMutual(boolean mutual) {
        this.mutual = mutual;
    }

    public int getDjStatus() {
        return djStatus;
    }

    public void setDjStatus(int djStatus) {
        this.djStatus = djStatus;
    }

    public int getVipType() {
        return vipType;
    }

    public void setVipType(int vipType) {
        this.vipType = vipType;
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

    public List<String> getExpertTags() {
        return expertTags;
    }

    public void setExpertTags(List<String> expertTags) {
        this.expertTags = expertTags;
    }
}
