package com.anglll.pink.ui.main;

import com.anglll.pink.R;
import com.anglll.pink.data.model.SongList;
import com.anglll.pink.data.model.VideoMain;
import com.anglll.pink.data.source.AppRepository;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.ListCompositeDisposable;
import io.reactivex.schedulers.Schedulers;

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
    public void getSongList(long uid) {
        Disposable disposable = appRepository.getSongLists(uid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<SongList>>() {
                    @Override
                    public void accept(@NonNull List<SongList> songLists) throws Exception {
                        view.getSongListSuccess(songLists);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        view.getSongListFail(R.string.error_request);
                    }
                });
        listCompositeDisposable.add(disposable);
    }

    @Override
    public void getVideoRecommend() {
        Disposable disposable = appRepository.getRecommendVideo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<VideoMain>>() {
                    @Override
                    public void accept(@NonNull List<VideoMain> videoMains) throws Exception {
                        view.getVideoRecommendSuccess(videoMains);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        view.getVideoRecommendFail(R.string.error_request);
                    }
                });
        listCompositeDisposable.add(disposable);
    }

    @Override
    public void unSubscribe() {
        if (!listCompositeDisposable.isDisposed()) {
            listCompositeDisposable.clear();
        }
        this.view = null;
    }
}
