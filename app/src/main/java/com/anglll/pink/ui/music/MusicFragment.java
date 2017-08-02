package com.anglll.pink.ui.music;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anglll.pink.R;
import com.anglll.pink.base.BaseFragment;

import butterknife.ButterKnife;

/**
 * Created by yuan on 2017/8/1 0001.
 */

public class MusicFragment extends BaseFragment {
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
}
