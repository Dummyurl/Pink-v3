package com.anglll.pink.data.model;

import java.util.List;

/**
 * Created by yuan on 2017/8/24 0024.
 */

public class VideoMain {

    /**
     * belong : 0
     * channelId : 60
     * contentCount : 4
     * contents : [{"actionId":1,"ad":false,"channelId":87,"device":0,"hide":0,"id":115656,"image":"http://imgs.aixifan.com/content/2017_08_21/1503312662.jpg","intro":"谢谢jianjian的填词~这词看得我好感动啊，稍微改了改词，希望大家喜欢~原曲：锦鲤抄\u2014\u2014银临&amp;amp;云之泣","latestBangumiVideo":{"bangumiId":1480113,"sort":140,"title":"第8话","updateTime":1503424780000,"videoId":5528930},"regionId":11,"releaseDate":1503312794000,"releasedAt":1503467268000,"shareTagShow":0,"status":2,"subTitle":"","subUrl":"3932298","subVideo":{"channelId":94,"contentId":1480058,"cover":"http://g2.ykimg.com/1100641F46543F8399E57707D2AC492672181F-8290-46FA-4141-8F11C9971A47","description":"一代神锋！克雷斯波生涯劲爆进球集锦","display":0,"image":"http://g2.ykimg.com/1100641F46543F8399E57707D2AC492672181F-8290-46FA-4141-8F11C9971A47","isAd":0,"isArticle":0,"isComment":true,"isRecommend":0,"owner":{"avatar":"http://cdn.aixifan.com/dotnet/artemis/u/cms/www/201601/20171313dz8r16qu.jpg","id":523776,"name":"JTR的百年孤寂","verified":0,"verifiedText":""},"parentChannelId":69,"releaseDate":1413451668000,"status":2,"tags":["克雷斯波","神锋"],"title":"一代神锋！克雷斯波生涯劲爆进球集锦","topLevel":0,"updatedAt":1503507922000,"videoCount":-1,"viewOnly":0,"visit":{"comments":5,"danmakuSize":0,"goldBanana":5,"score":0,"stows":1168,"ups":0,"views":371066}},"title":"【白展堂】锦鲤抄","updateAt":1503467268000,"url":"3932298","visit":{"comments":40,"danmakuSize":98,"goldBanana":655,"score":0,"stows":318,"ups":0,"views":43230},"webImage":"","webUrl":""}]
     * deviceType : -1
     * goText :
     * hide : 0
     * id : 11
     * image : http://imgs.aixifan.com/cms/2017_01_12/1484212553481.png
     * menuCount : 1
     * menus : [{"actionId":6,"channelId":60,"hide":0,"id":6,"image":"","name":"更多娱乐内容","regionId":11,"sort":0,"url":""}]
     * name : 娱乐
     * pid : -1
     * platformId : 1
     * showLine : 1
     * showMore : 1
     * showName : 1
     * sort : 64
     * type : {"id":1,"name":"视频","value":"videos"}
     * updateAt : 1500018460000
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
         * id : 1
         * name : 视频
         * value : videos
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
         * actionId : 1
         * ad : false
         * channelId : 87
         * device : 0
         * hide : 0
         * id : 115656
         * image : http://imgs.aixifan.com/content/2017_08_21/1503312662.jpg
         * intro : 谢谢jianjian的填词~这词看得我好感动啊，稍微改了改词，希望大家喜欢~原曲：锦鲤抄——银临&amp;amp;云之泣
         * latestBangumiVideo : {"bangumiId":1480113,"sort":140,"title":"第8话","updateTime":1503424780000,"videoId":5528930}
         * regionId : 11
         * releaseDate : 1503312794000
         * releasedAt : 1503467268000
         * shareTagShow : 0
         * status : 2
         * subTitle :
         * subUrl : 3932298
         * subVideo : {"channelId":94,"contentId":1480058,"cover":"http://g2.ykimg.com/1100641F46543F8399E57707D2AC492672181F-8290-46FA-4141-8F11C9971A47","description":"一代神锋！克雷斯波生涯劲爆进球集锦","display":0,"image":"http://g2.ykimg.com/1100641F46543F8399E57707D2AC492672181F-8290-46FA-4141-8F11C9971A47","isAd":0,"isArticle":0,"isComment":true,"isRecommend":0,"owner":{"avatar":"http://cdn.aixifan.com/dotnet/artemis/u/cms/www/201601/20171313dz8r16qu.jpg","id":523776,"name":"JTR的百年孤寂","verified":0,"verifiedText":""},"parentChannelId":69,"releaseDate":1413451668000,"status":2,"tags":["克雷斯波","神锋"],"title":"一代神锋！克雷斯波生涯劲爆进球集锦","topLevel":0,"updatedAt":1503507922000,"videoCount":-1,"viewOnly":0,"visit":{"comments":5,"danmakuSize":0,"goldBanana":5,"score":0,"stows":1168,"ups":0,"views":371066}}
         * title : 【白展堂】锦鲤抄
         * updateAt : 1503467268000
         * url : 3932298
         * visit : {"comments":40,"danmakuSize":98,"goldBanana":655,"score":0,"stows":318,"ups":0,"views":43230}
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
        private int regionId;
        private long releaseDate;
        private long releasedAt;
        private int shareTagShow;
        private int status;
        private String subTitle;
        private String subUrl;
        private SubVideoBean subVideo;
        private String title;
        private long updateAt;
        private String url;
        private VisitBeanX visit;
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

        public SubVideoBean getSubVideo() {
            return subVideo;
        }

        public void setSubVideo(SubVideoBean subVideo) {
            this.subVideo = subVideo;
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

        public VisitBeanX getVisit() {
            return visit;
        }

        public void setVisit(VisitBeanX visit) {
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
             * bangumiId : 1480113
             * sort : 140
             * title : 第8话
             * updateTime : 1503424780000
             * videoId : 5528930
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

        public static class SubVideoBean {
            /**
             * channelId : 94
             * contentId : 1480058
             * cover : http://g2.ykimg.com/1100641F46543F8399E57707D2AC492672181F-8290-46FA-4141-8F11C9971A47
             * description : 一代神锋！克雷斯波生涯劲爆进球集锦
             * display : 0
             * image : http://g2.ykimg.com/1100641F46543F8399E57707D2AC492672181F-8290-46FA-4141-8F11C9971A47
             * isAd : 0
             * isArticle : 0
             * isComment : true
             * isRecommend : 0
             * owner : {"avatar":"http://cdn.aixifan.com/dotnet/artemis/u/cms/www/201601/20171313dz8r16qu.jpg","id":523776,"name":"JTR的百年孤寂","verified":0,"verifiedText":""}
             * parentChannelId : 69
             * releaseDate : 1413451668000
             * status : 2
             * tags : ["克雷斯波","神锋"]
             * title : 一代神锋！克雷斯波生涯劲爆进球集锦
             * topLevel : 0
             * updatedAt : 1503507922000
             * videoCount : -1
             * viewOnly : 0
             * visit : {"comments":5,"danmakuSize":0,"goldBanana":5,"score":0,"stows":1168,"ups":0,"views":371066}
             */

            private int channelId;
            private int contentId;
            private String cover;
            private String description;
            private int display;
            private String image;
            private int isAd;
            private int isArticle;
            private boolean isComment;
            private int isRecommend;
            private OwnerBean owner;
            private int parentChannelId;
            private long releaseDate;
            private int status;
            private String title;
            private int topLevel;
            private long updatedAt;
            private int videoCount;
            private int viewOnly;
            private VisitBean visit;
            private List<String> tags;

            public int getChannelId() {
                return channelId;
            }

            public void setChannelId(int channelId) {
                this.channelId = channelId;
            }

            public int getContentId() {
                return contentId;
            }

            public void setContentId(int contentId) {
                this.contentId = contentId;
            }

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public int getDisplay() {
                return display;
            }

            public void setDisplay(int display) {
                this.display = display;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public int getIsAd() {
                return isAd;
            }

            public void setIsAd(int isAd) {
                this.isAd = isAd;
            }

            public int getIsArticle() {
                return isArticle;
            }

            public void setIsArticle(int isArticle) {
                this.isArticle = isArticle;
            }

            public boolean isIsComment() {
                return isComment;
            }

            public void setIsComment(boolean isComment) {
                this.isComment = isComment;
            }

            public int getIsRecommend() {
                return isRecommend;
            }

            public void setIsRecommend(int isRecommend) {
                this.isRecommend = isRecommend;
            }

            public OwnerBean getOwner() {
                return owner;
            }

            public void setOwner(OwnerBean owner) {
                this.owner = owner;
            }

            public int getParentChannelId() {
                return parentChannelId;
            }

            public void setParentChannelId(int parentChannelId) {
                this.parentChannelId = parentChannelId;
            }

            public long getReleaseDate() {
                return releaseDate;
            }

            public void setReleaseDate(long releaseDate) {
                this.releaseDate = releaseDate;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getTopLevel() {
                return topLevel;
            }

            public void setTopLevel(int topLevel) {
                this.topLevel = topLevel;
            }

            public long getUpdatedAt() {
                return updatedAt;
            }

            public void setUpdatedAt(long updatedAt) {
                this.updatedAt = updatedAt;
            }

            public int getVideoCount() {
                return videoCount;
            }

            public void setVideoCount(int videoCount) {
                this.videoCount = videoCount;
            }

            public int getViewOnly() {
                return viewOnly;
            }

            public void setViewOnly(int viewOnly) {
                this.viewOnly = viewOnly;
            }

            public VisitBean getVisit() {
                return visit;
            }

            public void setVisit(VisitBean visit) {
                this.visit = visit;
            }

            public List<String> getTags() {
                return tags;
            }

            public void setTags(List<String> tags) {
                this.tags = tags;
            }

            public static class OwnerBean {
                /**
                 * avatar : http://cdn.aixifan.com/dotnet/artemis/u/cms/www/201601/20171313dz8r16qu.jpg
                 * id : 523776
                 * name : JTR的百年孤寂
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
                 * comments : 5
                 * danmakuSize : 0
                 * goldBanana : 5
                 * score : 0
                 * stows : 1168
                 * ups : 0
                 * views : 371066
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

        public static class VisitBeanX {
            /**
             * comments : 40
             * danmakuSize : 98
             * goldBanana : 655
             * score : 0
             * stows : 318
             * ups : 0
             * views : 43230
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
         * channelId : 60
         * hide : 0
         * id : 6
         * image :
         * name : 更多娱乐内容
         * regionId : 11
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
