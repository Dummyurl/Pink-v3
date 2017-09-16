package com.anglll.pink.player;

/**
 * Created by yuan on 2017/9/16 0016.
 */

public enum PlayMode {
    SINGLE,
    LIST,
    SHUFFLE;

    public static PlayMode getDefault() {
        return LIST;
    }

    public static PlayMode switchNextMode(PlayMode currentMode) {
        if (currentMode == null)
            return getDefault();
        switch (currentMode) {
            case LIST:
                return SHUFFLE;
            case SHUFFLE:
                return SINGLE;
            case SINGLE:
                return LIST;
        }
        return getDefault();
    }
}
