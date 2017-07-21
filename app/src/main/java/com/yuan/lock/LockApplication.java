package com.yuan.lock;

import android.app.Application;

import com.yuan.lock.utils.Config;

import cn.touchair.uslock.TALockManager;

/**
 * Created by yuan on 2017/7/20 0020.
 */

public class LockApplication extends Application {
    private static LockApplication instance;

    public static LockApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        //init
        TALockManager.init(this, Config.API_KEY);

    }
}
