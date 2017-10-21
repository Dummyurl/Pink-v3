package com.anglll.pink.core;

import android.content.Context;
import android.os.Binder;

import java.util.ArrayList;
import java.util.List;

public class PinkBinder extends Binder implements PinkContract.Presenter {
    private final Context context;
    private List<PinkListener> pinkListeners = new ArrayList<>();
    private PinkContract.Presenter presenter;

    public PinkBinder(Context context, PinkContract.Presenter presenter) {
        this.context = context;
        this.presenter = presenter;
    }

    public List<PinkListener> getListeners() {
        return pinkListeners;
    }


    public void addPinkListener(PinkListener listener) {
        pinkListeners.add(listener);
        refreshData();
    }

    public void removeListener(PinkListener listener) {
        pinkListeners.remove(listener);
    }

    public void clearListener() {
        pinkListeners.clear();
    }

    private void refreshData() {
        presenter.getTodo();
        presenter.getWeatherInfo("ip");
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unSubscribe() {

    }

    @Override
    public void getWeatherInfo(String location) {
        presenter.getWeatherInfo(location);
    }

    @Override
    public void getTodo() {
        presenter.getTodo();
    }
}