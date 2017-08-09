package com.anglll.pink.ui.home;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.airbnb.epoxy.EpoxyModelWithHolder;
import com.anglll.pink.R;
import com.anglll.pink.base.BaseFragment;
import com.anglll.pink.data.model.Event;
import com.anglll.pink.data.model.HomeCard;
import com.anglll.pink.data.model.Todo;
import com.anglll.pink.utils.IDUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yuan on 2017/8/1 0001.
 */

public class HomeFragment extends BaseFragment {
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    private HomeController controller;
    private List<HomeCard> cardList = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recyclerview, container, false);
        ButterKnife.bind(this, view);
        initView();
        initData();
        return view;
    }

    private void initData() {
        updateController();
    }

    private void initView() {
        controller = new HomeController(null);
        controller.setSpanCount(2);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        gridLayoutManager.setSpanSizeLookup(controller.getSpanSizeLookup());
        mRecyclerView.setLayoutManager(gridLayoutManager);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(controller.getAdapter());
        cardList.add(new HomeCard(HomeCard.TYPE_WEATHER, IDUtils.generateID()));
        cardList.add(new HomeCard(HomeCard.TYPE_MUSIC, IDUtils.generateID()));
        HomeCard homeCard = new HomeCard(HomeCard.TYPE_EVENT, IDUtils.generateID());
        Todo todo = new Todo();
        List<Event> events = new ArrayList<>();
        events.add(new Event());
        events.add(new Event());
        events.add(new Event());
        todo.setEvents(events);
        homeCard.setTodo(todo);
        cardList.add(homeCard);
        updateController();
    }

    private void updateController() {
        controller.setData(cardList);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
