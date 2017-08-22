package com.anglll.pink.data.model;

import com.anglll.pink.utils.IDUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuan on 2017/8/8.
 */

public class Todo {
    List<Event> events = new ArrayList<>();
    public long id = IDUtils.generateID();

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
