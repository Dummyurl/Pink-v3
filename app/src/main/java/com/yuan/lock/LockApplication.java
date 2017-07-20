package com.yuan.lock;

import android.app.Application;

/**
 * Created by yuan on 2017/7/20 0020.
 */

public class LockApplication extends Application{
    private static LockApplication instance;
    public static LockApplication getInstance(){
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        //init

    }
}
