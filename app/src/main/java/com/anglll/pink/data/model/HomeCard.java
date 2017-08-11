package com.anglll.pink.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.anglll.pink.utils.IDUtils;

/**
 * Created by yuan on 2017/8/8 0008.
 */

public class HomeCard implements Parcelable {
    public static final int TYPE_WEATHER = 1;
    public static final int TYPE_MUSIC = 2;
    public static final int TYPE_EVENT = 3;
    int type;
    public long id = IDUtils.generateID();
    Weather weather;
    PlayList playList;
    Todo todo;

    public HomeCard(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public PlayList getPlayList() {
        return playList;
    }

    public void setPlayList(PlayList playList) {
        this.playList = playList;
    }

    public Todo getTodo() {
        return todo;
    }

    public void setTodo(Todo todo) {
        this.todo = todo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.type);
        dest.writeLong(this.id);
        dest.writeParcelable(this.weather, flags);
        dest.writeParcelable(this.playList, flags);
        dest.writeParcelable(this.todo, flags);
    }

    protected HomeCard(Parcel in) {
        this.type = in.readInt();
        this.id = in.readLong();
        this.weather = in.readParcelable(Weather.class.getClassLoader());
        this.playList = in.readParcelable(PlayList.class.getClassLoader());
        this.todo = in.readParcelable(Todo.class.getClassLoader());
    }

    public static final Parcelable.Creator<HomeCard> CREATOR = new Parcelable.Creator<HomeCard>() {
        @Override
        public HomeCard createFromParcel(Parcel source) {
            return new HomeCard(source);
        }

        @Override
        public HomeCard[] newArray(int size) {
            return new HomeCard[size];
        }
    };
}
