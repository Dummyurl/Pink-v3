package com.yuan.lock.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by yuan on 2017/7/21 0021.
 */

public class BaseActivity extends AppCompatActivity {
    private CompositeDisposable mCompositeDisposable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addSubscription(subscribeEvents());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mCompositeDisposable != null)
            mCompositeDisposable.clear();
    }

    protected void addSubscription(Disposable subscription) {
        if (subscription == null)
            return;
        if (mCompositeDisposable == null)
            mCompositeDisposable = new CompositeDisposable();
        mCompositeDisposable.add(subscription);
    }

    protected Disposable subscribeEvents() {
        return null;
    }

    protected Context getContext(){
        return this;
    }
}
