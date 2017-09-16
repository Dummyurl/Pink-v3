package com.anglll.pink.ui.songlist;

import android.content.ContentResolver;

import com.anglll.pink.data.model.Song;
import com.anglll.pink.data.model.SongList;
import com.anglll.pink.data.retrofit.RetrofitAPI;
import com.anglll.pink.data.source.AppRepository;
import com.anglll.pink.data.source.db.DaoMasterHelper;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.ListCompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by yuan on 2017/9/5 0005.
 */

public class SongListPresenter implements SongListContract.Presenter {

    private AppRepository appRepository;
    private SongListContract.View view;
    private ListCompositeDisposable listCompositeDisposable;

    public SongListPresenter(SongListContract.View view) {
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
    public void getSongList(ContentResolver cr, long id) {
/*        appRepository.getSongListByNet(cr, id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<SongList>() {
                    @Override
                    public void accept(@NonNull SongList songList) throws Exception {

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {

                    }
                });*/
appRepository.getSongListByLocal(id)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<SongList>() {
            @Override
            public void accept(@NonNull SongList songList) throws Exception {

            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {

            }
        });
/*        RetrofitAPI.getInstance()
                .getRemoteService()
                .getSongList(id)
                .doOnNext(new Consumer<SongList>() {
                    @Override
                    public void accept(@NonNull SongList songList) throws Exception {
                        for (int i = 0; i < songList.playList.size(); i++) {
//                            songList.playList.get(i).setIndex((long) i);
//                            songList.playList.get(i).setSongListId(songList.getId());
                        }
                        DaoMasterHelper.getDaoSession()
                                .getSongDao()
                                .insertOrReplaceInTx(songList.playList);
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<SongList>() {
                    @Override
                    public void accept(@NonNull SongList songList) throws Exception {

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {

                    }
                });*/
    }
}
