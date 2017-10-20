package com.anglll.pink.core;

import android.content.Context;
import android.util.Log;

import com.anglll.pink.R;
import com.anglll.pink.data.model.Todo;
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

    private final Context context;
    private AppRepository appRepository;
    private PinkContract.View view;
    private ListCompositeDisposable listCompositeDisposable;

    public PinkPresenter(Context context, PinkContract.View view) {
        this.context = context;
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
                        view.onWeatherLoaded(true, weather, null);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        view.onWeatherLoaded(false, null, context.getString(R.string.error_request));
                    }
                });
        listCompositeDisposable.add(disposable);
    }

    @Override
    public void getTodo() {
        Disposable disposable = appRepository.getTodo(context.getContentResolver())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Todo>() {
                    @Override
                    public void accept(@NonNull Todo todo) throws Exception {
                        view.onTodoLoaded(true, todo, null);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        view.onTodoLoaded(false, null, context.getString(R.string.error_request));
                    }
                });
        listCompositeDisposable.add(disposable);
    }
}
