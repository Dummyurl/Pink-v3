package com.anglll.pink.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.StringRes;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.anglll.pink.R;
import com.anglll.pink.RxBus;
import com.anglll.pink.base.BaseActivity;
import com.anglll.pink.data.model.SongList;
import com.anglll.pink.data.model.SuperModel;
import com.anglll.pink.data.model.VideoMain;
import com.anglll.pink.data.model.Weather;
import com.anglll.pink.ui.TestActivity;
import com.jaeger.library.StatusBarUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener, MainContract.View {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
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
    private RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();
    private MainController controller = new MainController(null, recycledViewPool);
    private SuperModel superModel = new SuperModel();
    private Handler handler = new Handler();
    private MainContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        StatusBarUtil.setTranslucentForDrawerLayout(this, mDrawerLayout, 0);
        setSupportActionBar(mToolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        mNavView.setNavigationItemSelectedListener(this);
        mNavView.getMenu().getItem(0).setChecked(true);

        recycledViewPool.setMaxRecycledViews(R.layout.video_item_v, Integer.MAX_VALUE);
        recycledViewPool.setMaxRecycledViews(R.layout.video_group, Integer.MAX_VALUE);
        recycledViewPool.setMaxRecycledViews(R.layout.video_fun_v, Integer.MAX_VALUE);

        mRecyclerView.setRecycledViewPool(recycledViewPool);
        controller.setSpanCount(2);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        gridLayoutManager.setSpanSizeLookup(controller.getSpanSizeLookup());
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(controller.getAdapter());
        if (savedInstanceState != null) {
//            superModel = savedInstanceState.getParcelable(SAVED_SUPER);
            // TODO: 2017/8/22 0022 获取存储的诗句
        }
        updateController();
        new MainPresenter(this);
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

    @Override
    protected Disposable subscribeEvents() {
        return RxBus.get()
                .toObservable()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(@NonNull Object o) throws Exception {

                    }
                });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
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
                    presenter.getWeatherInfo("ip");
                }
                break;
            case R.id.nav_music:
                if (superModel.getType() != SuperModel.TYPE_MUSIC) {
                    superModel.setType(SuperModel.TYPE_MUSIC);
                    updateController();
                    presenter.getSongList("3361534");
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
                startActivity(new Intent(getContext(), TestActivity.class));
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
    public void getWeatherSuccess(Weather weather) {
        superModel.setWeather(weather);
        updateController();
    }

    @Override
    public void getWeatherFail(@StringRes int stringRes) {

    }

    @Override
    public void getSongListSuccess(List<SongList> songLists) {
        superModel.setSongLists(songLists);
        updateController();
    }

    @Override
    public void getSongListFail(@StringRes int stringRes) {

    }

    @Override
    public void getVideoRecommendSuccess(List<VideoMain> videoMainList) {
        superModel.setVideoMainList(videoMainList);
        updateController();
    }

    @Override
    public void getVideoRecommendFail(@StringRes int stringRes) {

    }
}
