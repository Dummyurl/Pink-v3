package com.anglll.pink.ui.songlist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.widget.RecyclerView;

import com.anglll.pink.R;
import com.anglll.pink.base.BaseActivity;
import com.anglll.pink.data.model.SongList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yuan on 2017/9/5 0005.
 */

public class SongListActivity extends BaseActivity implements SongListContract.View {
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    private SongListContract.Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songlist);
        ButterKnife.bind(this);
        new SongListPresenter(this);
        presenter.getSongList(getContentResolver(), 4380864);
    }

    @Override
    public void setPresenter(SongListContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void getSongList(SongList songList) {

    }

    @Override
    public void getSongListFail(@StringRes int stringRes) {

    }
}
