package com.anglll.pink.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.anglll.pink.utils.IDUtils;

/**
 * Created by yuan on 2017/8/8.
 */

public class Event implements Parcelable {
    long id = IDUtils.generateID();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
    }

    public Event() {
    }

    protected Event(Parcel in) {
        this.id = in.readLong();
    }

    public static final Parcelable.Creator<Event> CREATOR = new Parcelable.Creator<Event>() {
        @Override
        public Event createFromParcel(Parcel source) {
            return new Event(source);
        }

        @Override
        public Event[] newArray(int size) {
            return new Event[size];
        }
    };
}
