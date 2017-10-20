package com.anglll.pink.core;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.anglll.pink.RxBus;
import com.anglll.pink.data.model.Todo;
import com.anglll.pink.data.model.Weather;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by yuan on 2017/9/19 0019.
 */

public class PinkService extends Service implements PinkContract.View {
    private CompositeDisposable mCompositeDisposable;
    private PinkContract.Presenter presenter;
    private PinkBinder pinkBinder = new PinkBinder();
    private List<PinkListener> pinkListeners = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        initRxBus();
        initView();
    }

    private void initView() {

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return pinkBinder;
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    public Context getContext() {
        return this;
    }


    private Consumer<Object> rxBusConsumer = new Consumer<Object>() {
        @Override
        public void accept(@NonNull Object o) throws Exception {

        }
    };

    @Override
    public void setPresenter(PinkContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onTodoLoaded(boolean isSuccess, Todo todo, String msg) {
        for (PinkListener listener : pinkListeners)
            listener.onTodoLoaded(isSuccess, todo, msg);
    }

    @Override
    public void onWeatherLoaded(boolean isSuccess, Weather weather, String msg) {
        for (PinkListener listener : pinkListeners)
            listener.onWeatherLoaded(isSuccess, weather, msg);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mCompositeDisposable != null)
            mCompositeDisposable.clear();
    }

    private void initRxBus() {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
            Disposable disposable = RxBus.get()
                    .toObservable()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(rxBusConsumer);
            mCompositeDisposable.add(disposable);
        }
    }

    public class PinkBinder extends Binder implements PinkContract.Presenter {

        public void addPinkListener(PinkListener listener) {
            pinkListeners.add(listener);
        }

        public void removeListener(PinkListener listener) {
            pinkListeners.remove(listener);
        }

        public void clearListener() {
            pinkListeners.clear();
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
}
