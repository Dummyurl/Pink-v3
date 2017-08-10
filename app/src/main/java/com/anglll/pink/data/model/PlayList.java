package com.anglll.pink.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuan on 2017/8/8.
 */

public class PlayList implements Parcelable {
    List<Song> songList = new ArrayList<>();
    Song playingSong;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(this.songList);
        dest.writeParcelable(this.playingSong, flags);
    }

    public PlayList() {
    }

    protected PlayList(Parcel in) {
        this.songList = new ArrayList<Song>();
        in.readList(this.songList, Song.class.getClassLoader());
        this.playingSong = in.readParcelable(Song.class.getClassLoader());
    }

    public static final Parcelable.Creator<PlayList> CREATOR = new Parcelable.Creator<PlayList>() {
        @Override
        public PlayList createFromParcel(Parcel source) {
            return new PlayList(source);
        }

        @Override
        public PlayList[] newArray(int size) {
            return new PlayList[size];
        }
    };
}
