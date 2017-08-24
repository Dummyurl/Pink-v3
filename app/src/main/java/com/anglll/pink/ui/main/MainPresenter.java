package com.anglll.pink.ui.main;

import com.anglll.pink.data.source.AppRepository;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.ListCompositeDisposable;

/**
 * Created by yuan on 2017/8/22 0022.
 */

public class MainPresenter implements MainContract.Presenter {


    private AppRepository appRepository;
    private MainContract.View view;
    private ListCompositeDisposable listCompositeDisposable;

    public MainPresenter(MainContract.View view) {
        this.view = view;
        this.listCompositeDisposable = new ListCompositeDisposable();
        this.appRepository = AppRepository.getInstance();
        this.view.setPresenter(this);
    }

    @Override
    public void subscribe() {

    }


    @Override
    public void getWeatherInfo(String location) {
    }

    @Override
    public void getSongList(String uid) {

    }

    @Override
    public void getVideoRecommend() {

    }

    @Override
    public void unSubscribe() {
        if (!listCompositeDisposable.isDisposed()) {
            listCompositeDisposable.clear();
        }
        this.view = null;
    }
}
