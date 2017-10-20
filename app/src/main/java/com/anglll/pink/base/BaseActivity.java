package com.anglll.pink.base;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

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

    protected Context getContext() {
        return this;
    }

    public void TT(@StringRes int stringRes) {
        Toast.makeText(getContext(), getString(stringRes), Toast.LENGTH_SHORT).show();
    }

    public void TT(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    public int getStatusBarHeight() {
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        return getResources().getDimensionPixelSize(resourceId);
    }

    public int getNavigationBarHeight() {
        int resourceId = getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        return getResources().getDimensionPixelSize(resourceId);
    }
}
