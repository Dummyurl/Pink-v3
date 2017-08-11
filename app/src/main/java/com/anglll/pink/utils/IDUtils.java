package com.anglll.pink.utils;

import android.util.Log;

import com.anglll.pink.BuildConfig;

/**
 * Created by yuan on 2017/8/8 0008.
 */

public class IDUtils {
    private static long id = 0;

    public static long generateID() {
        synchronized (IDUtils.class) {
            if(BuildConfig.DEBUG)
                Log.d("generateID",String.valueOf(id));
            return id++;
        }
    }
}
