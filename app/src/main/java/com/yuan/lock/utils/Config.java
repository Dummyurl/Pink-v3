package com.yuan.lock.utils;

/**
 * Created by yuan on 2017/7/20 0020.
 */

public class Config {
    //开锁凭证缓存时间(ms)
    public static final long OATH_CACHE_TIME = 24 * 60 * 60 * 1000;
    //开锁间隔时间(ms)
    public static final int OPEN_LOCK_INTERVAL = 5 * 1000;
}
