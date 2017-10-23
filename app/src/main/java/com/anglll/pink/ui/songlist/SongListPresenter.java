package com.anglll.pink.ui.songlist;

import com.anglll.pink.R;
import com.anglll.pink.data.model.SongList;
import com.anglll.pink.data.source.AppRepository;

import org.reactivestreams.Publisher;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
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

    /*
     * observeOn() 指定的是它之后的操作所在的线程。
     * 因此如果有多次切换线程的需求，只要在每个想要切换线程的位置调用一次 observeOn() 即可。
     * subscribeOn() 的位置放在哪里都可以，但它是只能调用一次的
     */
    @Override
    public void getSongList(final long id) {
        appRepository.getSongListByLocal(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(new Function<SongList, Publisher<SongList>>() {
                    @Override
                    public Publisher<SongList> apply(@NonNull SongList songList) throws Exception {
                        view.getSongList(songList);
                        return appRepository.getSongListByNet(id)
                                .subscribeOn(Schedulers.io());
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<SongList>() {
                    @Override
                    public void accept(@NonNull SongList songList) throws Exception {
                        view.getSongList(songList);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        view.getSongListFail(R.string.fail_get_song_list_detail);
                    }
                });
    }
}
