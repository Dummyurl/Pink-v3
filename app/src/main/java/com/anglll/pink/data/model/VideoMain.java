package com.anglll.pink.data.model;

import java.util.List;

public class VideoMain {

    /**
     * belong : 0
     * channelId : 63
     * children : [12]
     * contentCount : 4
     * contents : [{"actionId":10,"ad":false,"channelId":110,"device":0,"hide":0,"id":116526,"image":"http://cdn.aixifan.com/dotnet/20120923/style/image/cover-night.png","intro":"90后直播农村生活获8万打赏 父母称其不务正业","latestBangumiVideo":{"bangumiId":1480114,"sort":110,"title":"第6话","updateTime":1503061097000,"videoId":5518151},"owner":{"avatar":"http://cdn.aixifan.com/dotnet/artemis/u/cms/www/201406/20081808e7s1.jpg","id":579011,"name":"会计","verified":0,"verifiedText":""},"regionId":21,"releaseDate":1504055515000,"releasedAt":1504087842000,"shareTagShow":0,"status":2,"subTitle":"","subUrl":"3948384","title":"90后直播农村生活获8万打赏 父母称其不务正业","updateAt":1504087842000,"url":"3948384","visit":{"comments":565,"danmakuSize":0,"goldBanana":6,"score":0,"stows":125,"ups":0,"views":85750},"webImage":"","webUrl":""}]
     * deviceType : -1
     * goText :
     * hide : 0
     * id : 21
     * image : http://imgs.aixifan.com/cms/2017_01_12/1484212564463.png
     * menuCount : 1
     * menus : [{"actionId":6,"channelId":63,"hide":0,"id":15,"image":"","name":"显示更多热门","regionId":21,"sort":0,"url":""}]
     * name : 文章
     * pid : -1
     * platformId : 1
     * showLine : 1
     * showMore : 1
     * showName : 1
     * sort : 58
     * type : {"id":2,"name":"文章","value":"articles"}
     * updateAt : 1495713979000
     * url :
     */

    private int belong;
    private int channelId;
    private int contentCount;
    private int deviceType;
    private String goText;
    private int hide;
    private int id;
    private String image;
    private int menuCount;
    private String name;
    private int pid;
    private int platformId;
    private int showLine;
    private int showMore;
    private int showName;
    private int sort;
    private TypeBean type;
    private long updateAt;
    private String url;
    private List<Integer> children;
    private List<ContentsBean> contents;
    private List<MenusBean> menus;

    public int getBelong() {
        return belong;
    }

    public void setBelong(int belong) {
        this.belong = belong;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public int getContentCount() {
        return contentCount;
    }

    public void setContentCount(int contentCount) {
        this.contentCount = contentCount;
    }

    public int getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(int deviceType) {
        this.deviceType = deviceType;
    }

    public String getGoText() {
        return goText;
    }

    public void setGoText(String goText) {
        this.goText = goText;
    }

    public int getHide() {
        return hide;
    }

    public void setHide(int hide) {
        this.hide = hide;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getMenuCount() {
        return menuCount;
    }

    public void setMenuCount(int menuCount) {
        this.menuCount = menuCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getPlatformId() {
        return platformId;
    }

    public void setPlatformId(int platformId) {
        this.platformId = platformId;
    }

    public int getShowLine() {
        return showLine;
    }

    public void setShowLine(int showLine) {
        this.showLine = showLine;
    }

    public int getShowMore() {
        return showMore;
    }

    public void setShowMore(int showMore) {
        this.showMore = showMore;
    }

    public int getShowName() {
        return showName;
    }

    public void setShowName(int showName) {
        this.showName = showName;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public TypeBean getType() {
        return type;
    }

    public void setType(TypeBean type) {
        this.type = type;
    }

    public long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(long updateAt) {
        this.updateAt = updateAt;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Integer> getChildren() {
        return children;
    }

    public void setChildren(List<Integer> children) {
        this.children = children;
    }

    public List<ContentsBean> getContents() {
        return contents;
    }

    public void setContents(List<ContentsBean> contents) {
        this.contents = contents;
    }

    public List<MenusBean> getMenus() {
        return menus;
    }

    public void setMenus(List<MenusBean> menus) {
        this.menus = menus;
    }

    public static class TypeBean {
        /**
         * id : 2
         * name : 文章
         * value : articles
         */

        private int id;
        private String name;
        private String value;

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

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public static class ContentsBean {
        /**
         * actionId : 10
         * ad : false
         * channelId : 110
         * device : 0
         * hide : 0
         * id : 116526
         * image : http://cdn.aixifan.com/dotnet/20120923/style/image/cover-night.png
         * intro : 90后直播农村生活获8万打赏 父母称其不务正业
         * latestBangumiVideo : {"bangumiId":1480114,"sort":110,"title":"第6话","updateTime":1503061097000,"videoId":5518151}
         * owner : {"avatar":"http://cdn.aixifan.com/dotnet/artemis/u/cms/www/201406/20081808e7s1.jpg","id":579011,"name":"会计","verified":0,"verifiedText":""}
         * regionId : 21
         * releaseDate : 1504055515000
         * releasedAt : 1504087842000
         * shareTagShow : 0
         * status : 2
         * subTitle :
         * subUrl : 3948384
         * title : 90后直播农村生活获8万打赏 父母称其不务正业
         * updateAt : 1504087842000
         * url : 3948384
         * visit : {"comments":565,"danmakuSize":0,"goldBanana":6,"score":0,"stows":125,"ups":0,"views":85750}
         * webImage :
         * webUrl :
         */

        private int actionId;
        private boolean ad;
        private int channelId;
        private int device;
        private int hide;
        private int id;
        private String image;
        private String intro;
        private LatestBangumiVideoBean latestBangumiVideo;
        private OwnerBean owner;
        private int regionId;
        private long releaseDate;
        private long releasedAt;
        private int shareTagShow;
        private int status;
        private String subTitle;
        private String subUrl;
        private String title;
        private long updateAt;
        private String url;
        private VisitBean visit;
        private String webImage;
        private String webUrl;

        public int getActionId() {
            return actionId;
        }

        public void setActionId(int actionId) {
            this.actionId = actionId;
        }

        public boolean isAd() {
            return ad;
        }

        public void setAd(boolean ad) {
            this.ad = ad;
        }

        public int getChannelId() {
            return channelId;
        }

        public void setChannelId(int channelId) {
            this.channelId = channelId;
        }

        public int getDevice() {
            return device;
        }

        public void setDevice(int device) {
            this.device = device;
        }

        public int getHide() {
            return hide;
        }

        public void setHide(int hide) {
            this.hide = hide;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }

        public LatestBangumiVideoBean getLatestBangumiVideo() {
            return latestBangumiVideo;
        }

        public void setLatestBangumiVideo(LatestBangumiVideoBean latestBangumiVideo) {
            this.latestBangumiVideo = latestBangumiVideo;
        }

        public OwnerBean getOwner() {
            return owner;
        }

        public void setOwner(OwnerBean owner) {
            this.owner = owner;
        }

        public int getRegionId() {
            return regionId;
        }

        public void setRegionId(int regionId) {
            this.regionId = regionId;
        }

        public long getReleaseDate() {
            return releaseDate;
        }

        public void setReleaseDate(long releaseDate) {
            this.releaseDate = releaseDate;
        }

        public long getReleasedAt() {
            return releasedAt;
        }

        public void setReleasedAt(long releasedAt) {
            this.releasedAt = releasedAt;
        }

        public int getShareTagShow() {
            return shareTagShow;
        }

        public void setShareTagShow(int shareTagShow) {
            this.shareTagShow = shareTagShow;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getSubTitle() {
            return subTitle;
        }

        public void setSubTitle(String subTitle) {
            this.subTitle = subTitle;
        }

        public String getSubUrl() {
            return subUrl;
        }

        public void setSubUrl(String subUrl) {
            this.subUrl = subUrl;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public long getUpdateAt() {
            return updateAt;
        }

        public void setUpdateAt(long updateAt) {
            this.updateAt = updateAt;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public VisitBean getVisit() {
            return visit;
        }

        public void setVisit(VisitBean visit) {
            this.visit = visit;
        }

        public String getWebImage() {
            return webImage;
        }

        public void setWebImage(String webImage) {
            this.webImage = webImage;
        }

        public String getWebUrl() {
            return webUrl;
        }

        public void setWebUrl(String webUrl) {
            this.webUrl = webUrl;
        }

        public static class LatestBangumiVideoBean {
            /**
             * bangumiId : 1480114
             * sort : 110
             * title : 第6话
             * updateTime : 1503061097000
             * videoId : 5518151
             */

            private int bangumiId;
            private int sort;
            private String title;
            private long updateTime;
            private int videoId;

            public int getBangumiId() {
                return bangumiId;
            }

            public void setBangumiId(int bangumiId) {
                this.bangumiId = bangumiId;
            }

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public long getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(long updateTime) {
                this.updateTime = updateTime;
            }

            public int getVideoId() {
                return videoId;
            }

            public void setVideoId(int videoId) {
                this.videoId = videoId;
            }
        }

        public static class OwnerBean {
            /**
             * avatar : http://cdn.aixifan.com/dotnet/artemis/u/cms/www/201406/20081808e7s1.jpg
             * id : 579011
             * name : 会计
             * verified : 0
             * verifiedText :
             */

            private String avatar;
            private int id;
            private String name;
            private int verified;
            private String verifiedText;

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
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

            public int getVerified() {
                return verified;
            }

            public void setVerified(int verified) {
                this.verified = verified;
            }

            public String getVerifiedText() {
                return verifiedText;
            }

            public void setVerifiedText(String verifiedText) {
                this.verifiedText = verifiedText;
            }
        }

        public static class VisitBean {
            /**
             * comments : 565
             * danmakuSize : 0
             * goldBanana : 6
             * score : 0
             * stows : 125
             * ups : 0
             * views : 85750
             */

            private int comments;
            private int danmakuSize;
            private int goldBanana;
            private int score;
            private int stows;
            private int ups;
            private int views;

            public int getComments() {
                return comments;
            }

            public void setComments(int comments) {
                this.comments = comments;
            }

            public int getDanmakuSize() {
                return danmakuSize;
            }

            public void setDanmakuSize(int danmakuSize) {
                this.danmakuSize = danmakuSize;
            }

            public int getGoldBanana() {
                return goldBanana;
            }

            public void setGoldBanana(int goldBanana) {
                this.goldBanana = goldBanana;
            }

            public int getScore() {
                return score;
            }

            public void setScore(int score) {
                this.score = score;
            }

            public int getStows() {
                return stows;
            }

            public void setStows(int stows) {
                this.stows = stows;
            }

            public int getUps() {
                return ups;
            }

            public void setUps(int ups) {
                this.ups = ups;
            }

            public int getViews() {
                return views;
            }

            public void setViews(int views) {
                this.views = views;
            }
        }
    }

    public static class MenusBean {
        /**
         * actionId : 6
         * channelId : 63
         * hide : 0
         * id : 15
         * image :
         * name : 显示更多热门
         * regionId : 21
         * sort : 0
         * url :
         */

        private int actionId;
        private int channelId;
        private int hide;
        private int id;
        private String image;
        private String name;
        private int regionId;
        private int sort;
        private String url;

        public int getActionId() {
            return actionId;
        }

        public void setActionId(int actionId) {
            this.actionId = actionId;
        }

        public int getChannelId() {
            return channelId;
        }

        public void setChannelId(int channelId) {
            this.channelId = channelId;
        }

        public int getHide() {
            return hide;
        }

        public void setHide(int hide) {
            this.hide = hide;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getRegionId() {
            return regionId;
        }

        public void setRegionId(int regionId) {
            this.regionId = regionId;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}