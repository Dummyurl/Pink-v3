package com.anglll.pink.data.model;

import com.anglll.pink.utils.IDUtils;

/**
 * Created by yuan on 2017/8/8.
 */

public class Event {
    long id = IDUtils.generateID();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
