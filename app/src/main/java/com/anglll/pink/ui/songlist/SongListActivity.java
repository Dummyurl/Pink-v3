package com.anglll.pink.ui.songlist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.anglll.pink.R;
import com.anglll.pink.RxBus;
import com.anglll.pink.base.BaseActivity;
import com.anglll.pink.data.model.Song;
import com.anglll.pink.data.model.SongList;
import com.anglll.pink.event.SongListEvent;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yuan on 2017/9/5 0005.
 */

public class SongListActivity extends BaseActivity implements SongListContract.View,
        SongListController.SongListCallback {
    public static final String SONG_LIST_ID = "songList_id";
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    private SongListContract.Presenter presenter;
    private SongListController controller;
    private long songListId;
    private SongList songList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songlist);
        ButterKnife.bind(this);
        controller = new SongListController(this);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(controller.getAdapter());
        new SongListPresenter(this);
        songListId = getIntent().getLongExtra(SONG_LIST_ID, 0);
        if (songListId > 0)
            presenter.getSongList(songListId);
    }


    @Override
    public void setPresenter(SongListContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void getSongList(SongList songList) {
        if (songList != null) {
            this.songList = songList;
            updateController();
        }
    }

    @Override
    public void getSongListFail(@StringRes int stringRes) {
        TT(stringRes);
    }

    private void updateController() {
        controller.setData(songList);
    }

    @Override
    public void onSongClick(Song song, int index) {
        songList.setPlayIndex(index);
        songList.setPlayingSong(song);
        RxBus.get().post(new SongListEvent(songList));
    }
}
