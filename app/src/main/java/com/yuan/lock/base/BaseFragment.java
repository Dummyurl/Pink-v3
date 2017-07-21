package com.yuan.lock.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by yuan on 2017/7/21 0021.
 */

public class BaseFragment extends Fragment {
    private CompositeDisposable mCompositeDisposable;
    protected boolean isVisible;
    public boolean isPrepared;
    public boolean isFirstInit = true;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addSubscription(subscribeEvents());
    }

    public Context getContext() {
        return getActivity();
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

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInVisible();
        }
    }

    protected void onVisible() {
        loadData();
    }

    protected void onInVisible() {

    }

    protected void loadData() {
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mCompositeDisposable != null)
            mCompositeDisposable.clear();
    }
}
