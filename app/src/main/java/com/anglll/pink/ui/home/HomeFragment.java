package com.anglll.pink.ui.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anglll.pink.R;
import com.anglll.pink.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yuan on 2017/8/1 0001.
 */

public class HomeFragment extends BaseFragment {
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recyclerview_with_refresh, container, false);
        ButterKnife.bind(this, view);
        initView();
        initData();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private void initData() {

    }

    private void initView() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
