package com.anglll.pink.core;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.anglll.pink.RxBus;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by yuan on 2017/9/19 0019.
 */

public class PinkService extends Service {
    private CompositeDisposable mCompositeDisposable;

    @Override
    public void onCreate() {
        super.onCreate();
        initRxBus();
        initView();
    }

    private void initView() {

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

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    public Context getContext() {
        return this;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mCompositeDisposable != null)
            mCompositeDisposable.clear();
    }

    private Consumer<Object> rxBusConsumer = new Consumer<Object>() {
        @Override
        public void accept(@NonNull Object o) throws Exception {

        }
    };
}
