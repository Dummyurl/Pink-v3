package com.anglll.pink.utils;

/**
 * Created by yuan on 8/31/17.
 */

public class NumberUtils {
    public static String[] formatCountWithUnit(final int counts) {
        String[] count = new String[2];

        if (counts <= 0) {
            count[0] = "0";
            count[1] = null;
        } else if (counts < 1000) {
            count[0] = String.valueOf(counts);
            count[1] = null;
        } else if (counts < 10000) {
            count[0] = String.valueOf((int) (counts / 1000));
            count[1] = "千";
        } else if (counts < 100000000) {
            count[0] = String.valueOf((int) (counts / 10000));
            count[1] = "万";
        } else if (counts < 100000000) {
            count[0] = String.valueOf((int) (counts / 100000000));
            count[1] = "亿";
        } else {
            count[0] = String.valueOf("+∞");
            count[1] = null;
        }
        return count;
    }

    public static String formatCount(int counts) {
        String count;
        if (counts <= 0) {
            count = "0";
        } else if (counts < 10000) {
            count = String.valueOf(counts);
        } else if (counts < 100000000) {
            count = String.valueOf((counts / 10000)) + "万";
        } else if (counts < 100000000) {
            count = String.valueOf((counts / 100000000)) + "亿";
        } else {
            count = String.valueOf("+∞");
        }
        return count;
    }
}
