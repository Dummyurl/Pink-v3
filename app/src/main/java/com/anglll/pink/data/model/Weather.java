package com.anglll.pink.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuan on 2017/8/8.
 */

public class Weather implements Parcelable {

    private LocationBean location;
    private NowBean now;
    private String last_update;
    private List<DailyBean> daily;

    public LocationBean getLocation() {
        return location;
    }

    public void setLocation(LocationBean location) {
        this.location = location;
    }

    public NowBean getNow() {
        return now;
    }

    public void setNow(NowBean now) {
        this.now = now;
    }

    public String getLast_update() {
        return last_update;
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }

    public List<DailyBean> getDaily() {
        return daily;
    }

    public void setDaily(List<DailyBean> daily) {
        this.daily = daily;
    }

    public static class LocationBean implements Parcelable {

        private String id;
        private String name;
        private String country;
        private String path;
        private String timezone;
        private String timezone_offset;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public String getTimezone() {
            return timezone;
        }

        public void setTimezone(String timezone) {
            this.timezone = timezone;
        }

        public String getTimezone_offset() {
            return timezone_offset;
        }

        public void setTimezone_offset(String timezone_offset) {
            this.timezone_offset = timezone_offset;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.id);
            dest.writeString(this.name);
            dest.writeString(this.country);
            dest.writeString(this.path);
            dest.writeString(this.timezone);
            dest.writeString(this.timezone_offset);
        }

        public LocationBean() {
        }

        protected LocationBean(Parcel in) {
            this.id = in.readString();
            this.name = in.readString();
            this.country = in.readString();
            this.path = in.readString();
            this.timezone = in.readString();
            this.timezone_offset = in.readString();
        }

        public static final Creator<LocationBean> CREATOR = new Creator<LocationBean>() {
            @Override
            public LocationBean createFromParcel(Parcel source) {
                return new LocationBean(source);
            }

            @Override
            public LocationBean[] newArray(int size) {
                return new LocationBean[size];
            }
        };
    }

    public static class NowBean implements Parcelable {

        private String text;
        private String code;
        private String temperature;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getTemperature() {
            return temperature;
        }

        public void setTemperature(String temperature) {
            this.temperature = temperature;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.text);
            dest.writeString(this.code);
            dest.writeString(this.temperature);
        }

        public NowBean() {
        }

        protected NowBean(Parcel in) {
            this.text = in.readString();
            this.code = in.readString();
            this.temperature = in.readString();
        }

        public static final Creator<NowBean> CREATOR = new Creator<NowBean>() {
            @Override
            public NowBean createFromParcel(Parcel source) {
                return new NowBean(source);
            }

            @Override
            public NowBean[] newArray(int size) {
                return new NowBean[size];
            }
        };
    }

    public static class DailyBean {

        private String date;
        private String text_day;
        private String code_day;
        private String text_night;
        private String code_night;
        private String high;
        private String low;
        private String precip;
        private String wind_direction;
        private String wind_direction_degree;
        private String wind_speed;
        private String wind_scale;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getText_day() {
            return text_day;
        }

        public void setText_day(String text_day) {
            this.text_day = text_day;
        }

        public String getCode_day() {
            return code_day;
        }

        public void setCode_day(String code_day) {
            this.code_day = code_day;
        }

        public String getText_night() {
            return text_night;
        }

        public void setText_night(String text_night) {
            this.text_night = text_night;
        }

        public String getCode_night() {
            return code_night;
        }

        public void setCode_night(String code_night) {
            this.code_night = code_night;
        }

        public String getHigh() {
            return high;
        }

        public void setHigh(String high) {
            this.high = high;
        }

        public String getLow() {
            return low;
        }

        public void setLow(String low) {
            this.low = low;
        }

        public String getPrecip() {
            return precip;
        }

        public void setPrecip(String precip) {
            this.precip = precip;
        }

        public String getWind_direction() {
            return wind_direction;
        }

        public void setWind_direction(String wind_direction) {
            this.wind_direction = wind_direction;
        }

        public String getWind_direction_degree() {
            return wind_direction_degree;
        }

        public void setWind_direction_degree(String wind_direction_degree) {
            this.wind_direction_degree = wind_direction_degree;
        }

        public String getWind_speed() {
            return wind_speed;
        }

        public void setWind_speed(String wind_speed) {
            this.wind_speed = wind_speed;
        }

        public String getWind_scale() {
            return wind_scale;
        }

        public void setWind_scale(String wind_scale) {
            this.wind_scale = wind_scale;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.location, flags);
        dest.writeParcelable(this.now, flags);
        dest.writeString(this.last_update);
        dest.writeList(this.daily);
    }

    public Weather() {
    }

    protected Weather(Parcel in) {
        this.location = in.readParcelable(LocationBean.class.getClassLoader());
        this.now = in.readParcelable(NowBean.class.getClassLoader());
        this.last_update = in.readString();
        this.daily = new ArrayList<DailyBean>();
        in.readList(this.daily, DailyBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<Weather> CREATOR = new Parcelable.Creator<Weather>() {
        @Override
        public Weather createFromParcel(Parcel source) {
            return new Weather(source);
        }

        @Override
        public Weather[] newArray(int size) {
            return new Weather[size];
        }
    };
}
