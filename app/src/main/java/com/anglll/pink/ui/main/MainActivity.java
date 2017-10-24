package com.anglll.pink.ui.main;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.StringRes;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.anglll.pink.R;
import com.anglll.pink.RxBus;
import com.anglll.pink.base.BaseActivity;
import com.anglll.pink.core.PinkBinder;
import com.anglll.pink.core.PinkListener;
import com.anglll.pink.core.PinkService;
import com.anglll.pink.data.model.Creator;
import com.anglll.pink.data.model.SongList;
import com.anglll.pink.data.model.SuperModel;
import com.anglll.pink.data.model.Todo;
import com.anglll.pink.data.model.VideoMain;
import com.anglll.pink.data.model.Weather;
import com.anglll.pink.data.source.db.DaoMasterHelper;
import com.anglll.pink.event.SongListEvent;
import com.anglll.pink.player.PlaybackService;
import com.anglll.pink.ui.songlist.SongListActivity;
import com.jaeger.library.StatusBarUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener, MainContract.View,
        PinkListener {

    @BindView(R.id.app_bar_layout)
    AppBarLayout mAppBarLayout;
    @BindView(R.id.nav_view)
    NavigationView mNavView;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    public static final String SAVED_SUPER = "saved_super";
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.left_btn)
    ImageButton mLeftBtn;
    @BindView(R.id.title)
    TextView mTitle;
    @BindView(R.id.sub_title)
    TextView mSubTitle;
    @BindView(R.id.right_btn)
    ImageButton mRightBtn;
    @BindView(R.id.toolbar)
    LinearLayout mToolbar;
    private RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();
    private MainController controller = new MainController(null, recycledViewPool);
    private SuperModel superModel;
    private Handler handler = new Handler();
    private MainContract.Presenter presenter;
    private boolean musicServiceConnected;
    private boolean pinkServiceConnected;
    private PlaybackService musicPlayer;
    private PinkBinder pinkBinder;

    private SongList songList;
    private Intent musicServiceIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        StatusBarUtil.setTranslucentForDrawerLayout(this, mDrawerLayout, 0);
/*        setSupportActionBar(mToolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();*/
        mTitle.setText(R.string.home);
        mNavView.setNavigationItemSelectedListener(this);
        mNavView.getMenu().getItem(0).setChecked(true);

        recycledViewPool.setMaxRecycledViews(R.layout.video_item_v, Integer.MAX_VALUE);
        recycledViewPool.setMaxRecycledViews(R.layout.video_group, Integer.MAX_VALUE);
        recycledViewPool.setMaxRecycledViews(R.layout.video_fun_v, Integer.MAX_VALUE);
        recycledViewPool.setMaxRecycledViews(R.layout.video_rank, Integer.MAX_VALUE);
        superModel = new SuperModel(getContext());
        mRecyclerView.setRecycledViewPool(recycledViewPool);
        controller.setSpanCount(2);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        gridLayoutManager.setSpanSizeLookup(controller.getSpanSizeLookup());
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.addItemDecoration(superModel.getItemDecoration());
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(controller.getAdapter());
        mSwipeRefreshLayout.setEnabled(false);
        if (savedInstanceState != null) {
//            superModel = savedInstanceState.getParcelable(SAVED_SUPER);
            // TODO: 2017/8/22 0022 获取存储的诗句
        }
        updateController();
        new MainPresenter(this);
        Intent pinkIntent = new Intent(getContext(), PinkService.class);
        startService(pinkIntent);
        bindService(pinkIntent, pinkServiceConnection, Context.BIND_AUTO_CREATE);
        musicServiceIntent = new Intent(getContext(), PlaybackService.class);
        presenter.getOffSongList();
    }

    private void updateController() {
        controller.setData(superModel);
    }

    private void startRefresh() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(true);
            }
        });
    }

    private void stopRefresh() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    @OnClick(R.id.left_btn)
    void openDrawer() {
        if (!mDrawerLayout.isDrawerOpen(GravityCompat.START))
            mDrawerLayout.openDrawer(GravityCompat.START);
    }

    @Override
    protected Disposable subscribeEvents() {
        return RxBus.get()
                .toObservable()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(@NonNull Object event) throws Exception {
                        if (event instanceof SongListEvent) {
                            songList = ((SongListEvent) event).getSongList();
                            playMusic();
                        }
                    }
                });
    }

    private void playMusic() {
        if (musicServiceConnected) {
            musicPlayer.play(songList);
        } else {
            bindService(musicServiceIntent, musicServiceConnection, Context.BIND_AUTO_CREATE);
        }
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                if (superModel.getType() != SuperModel.TYPE_HOME) {
                    superModel.setType(SuperModel.TYPE_HOME);
                    updateController();
                }
                break;
            case R.id.nav_music:
                if (superModel.getType() != SuperModel.TYPE_MUSIC) {
                    superModel.setType(SuperModel.TYPE_MUSIC);
                    updateController();
                    presenter.getSongList(3361534);
                }
                break;
            case R.id.nav_video:
                if (superModel.getType() != SuperModel.TYPE_VIDEO) {
                    superModel.setType(SuperModel.TYPE_VIDEO);
                    updateController();
                    presenter.getVideoRecommend();
                }
                break;
            case R.id.nav_send:
                startActivity(new Intent(getContext(), SongListActivity.class));
                break;
        }
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
//        outState.putParcelable(SAVED_SUPER, (ArrayList<? extends Parcelable>) superModel);
        // TODO: 2017/8/22 0022 存储数据
        controller.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        controller.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void getSongList(List<SongList> songLists) {
        superModel.setSongLists(songLists);
        updateController();
    }

    @Override
    public void getSongListFail(@StringRes int stringRes) {
        TT(getString(stringRes));
    }

    @Override
    public void getVideoRecommendSuccess(List<VideoMain> videoMainList) {
        superModel.setVideoMainList(videoMainList);
        updateController();
    }

    @Override
    public void getVideoRecommendFail(@StringRes int stringRes) {
        TT(getString(stringRes));
    }

    @Override
    public void getOffSongList(SongList songList) {

    }

    private ServiceConnection musicServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            musicServiceConnected = true;
            musicPlayer = ((PlaybackService.PlayerBinder) iBinder).getService();
            superModel.setMusicPlayer(musicPlayer);
            musicPlayer.play(songList);
            updateController();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            musicServiceConnected = false;
            musicPlayer = null;
        }
    };

    private ServiceConnection pinkServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            pinkServiceConnected = true;
            pinkBinder = ((PinkBinder) iBinder);
            pinkBinder.addPinkListener(MainActivity.this);
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            pinkServiceConnected = false;
        }
    };

    @Override
    public void onTodoLoaded(boolean isSuccess, Todo todo, @StringRes int msgRes) {
        if (!isSuccess)
            return;
        superModel.setTodo(todo);
        updateController();
    }

    @Override
    public void onWeatherLoaded(boolean isSuccess, Weather weather, @StringRes int msgRes) {
        if (!isSuccess) {
            if (msgRes != 0)
                TT(getString(msgRes));
            return;
        }
        superModel.setWeather(weather);
        updateController();
    }
}
