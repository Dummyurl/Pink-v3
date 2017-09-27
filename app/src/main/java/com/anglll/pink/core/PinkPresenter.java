package com.anglll.pink.core;

import com.anglll.pink.R;
import com.anglll.pink.data.model.Weather;
import com.anglll.pink.data.source.AppRepository;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.ListCompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by yuan on 2017/9/27 0027.
 */

public class PinkPresenter implements PinkContract.Presenter {

    private AppRepository appRepository;
    private PinkContract.View view;
    private ListCompositeDisposable listCompositeDisposable;

    public PinkPresenter(PinkContract.View view) {
        this.view = view;
        this.listCompositeDisposable = new ListCompositeDisposable();
        this.appRepository = AppRepository.getInstance();
        this.view.setPresenter(this);
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unSubscribe() {
        if (!listCompositeDisposable.isDisposed()) {
            listCompositeDisposable.clear();
        }
        this.view = null;
    }

    @Override
    public void getWeatherInfo(String location) {
        Disposable disposable = appRepository.getWeather(location)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Weather>() {
                    @Override
                    public void accept(@NonNull Weather weather) throws Exception {
                        view.getWeatherSuccess(weather);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                    }
                });
        listCompositeDisposable.add(disposable);
    }

    @Override
    public void getTodo() {

    }
}
