package com.anglll.pink.utils;

/**
 * Created by yuan on 2017/8/8 0008.
 */

public class IDUtils {
    private static long id = 0;

    public static long generateID() {
        synchronized (IDUtils.class) {
            return id++;
        }
    }
}
