package com.anglll.pink.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by yuan on 2017/8/8.
 */

public class Song implements Parcelable {
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    public Song() {
    }

    protected Song(Parcel in) {
    }

    public static final Parcelable.Creator<Song> CREATOR = new Parcelable.Creator<Song>() {
        @Override
        public Song createFromParcel(Parcel source) {
            return new Song(source);
        }

        @Override
        public Song[] newArray(int size) {
            return new Song[size];
        }
    };
}
