package com.anglll.pink.ui.songlist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.widget.LinearLayoutManager;
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
    public static final String SONG_LIST_ID = "songList_id";
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    private SongListContract.Presenter presenter;
    private SongListController controller;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songlist);
        ButterKnife.bind(this);
        controller = new SongListController();
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(controller.getAdapter());
        new SongListPresenter(this);
        long songListId = getIntent().getLongExtra(SONG_LIST_ID, 0);
        if (songListId > 0)
            presenter.getSongList(songListId);
    }


    @Override
    public void setPresenter(SongListContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void getSongList(SongList songList) {
        controller.setData(songList);
    }

    @Override
    public void getSongListFail(@StringRes int stringRes) {

    }

    @Override
    public void getSongListNet(SongList songList) {

    }

    @Override
    public void getSongListNetFail(@StringRes int stringRes) {

    }
}
