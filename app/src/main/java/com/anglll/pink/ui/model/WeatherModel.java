package com.anglll.pink.ui.model;

import android.support.v7.widget.AppCompatImageView;
import android.view.View;
import android.widget.TextView;

import com.airbnb.epoxy.EpoxyAttribute;
import com.airbnb.epoxy.EpoxyHolder;
import com.airbnb.epoxy.EpoxyModelClass;
import com.airbnb.epoxy.EpoxyModelWithHolder;
import com.anglll.pink.R;
import com.anglll.pink.data.model.Weather;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.airbnb.epoxy.EpoxyAttribute.Option.DoNotHash;

/**
 * Created by yuan on 2017/8/2 0002.
 */
@EpoxyModelClass(layout = R.layout.home_weather_model)
public abstract class WeatherModel extends EpoxyModelWithHolder<WeatherModel.WeatherHolder> {
    @EpoxyAttribute
    Weather weather;
    @EpoxyAttribute(DoNotHash)
    View.OnClickListener clickListener;

    @Override
    public void bind(WeatherHolder holder) {
        holder.itemView.setOnClickListener(clickListener);
        holder.bindData(weather);
    }

    @Override
    public void unbind(WeatherHolder holder) {
        holder.itemView.setOnClickListener(null);
    }

    @Override
    public int getSpanSize(int totalSpanCount, int position, int itemCount) {
        return totalSpanCount;
    }

    public static class WeatherHolder extends EpoxyHolder {
        @BindView(R.id.simpleDraweeView)
        SimpleDraweeView mSimpleDraweeView;
        @BindView(R.id.weather_temp)
        TextView mWeatherTemp;
        @BindView(R.id.weather_info)
        TextView mWeatherInfo;
        @BindView(R.id.update_time)
        TextView mUpdateTime;
        @BindView(R.id.address_parent)
        TextView mAddressParent;
        @BindView(R.id.address_child)
        TextView mAddressChild;
        @BindView(R.id.weather_icon)
        AppCompatImageView mWeatherIcon;
        View itemView;

        @Override
        protected void bindView(View itemView) {
            ButterKnife.bind(this, itemView);
            this.itemView = itemView;
        }

        public void bindData(Weather weather) {
            if (weather == null)
                return;
            mWeatherTemp.setText(String.valueOf(weather.getNow().getTemperature()
                    + itemView.getContext().getString(R.string.temperature_unit)));
            mWeatherInfo.setText(String.valueOf(weather.getNow().getText()));
            mAddressParent.setText(String.valueOf(weather.getLocation().getCountry()));
            mAddressChild.setText(weather.getLocation().getName());
        }
    }
}
