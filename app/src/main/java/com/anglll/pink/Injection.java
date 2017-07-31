package com.anglll.pink;

import android.content.Context;

/**
 * Created by yuan on 2017/7/20 0020.
 */

public class Injection {
    public static Context provideContext(){
        return LockApplication.getInstance();
    }
}
