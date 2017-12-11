package com.bdhs.bosspone.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.bdhs.bosspone.R;
import com.bdhs.bosspone.ui.view.BottomScrollView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 14487 on 2017/9/17.
 */

public class home_fragment extends Fragment {

    @BindView(R.id.gridView)
    GridView gridView;
    @BindView(R.id.main_scroll_view)
    BottomScrollView mainScrollView;
    @BindView(R.id.main_refresh_layout)
    SwipeRefreshLayout mRefreshLayout;
    Unbinder unbinder;
    private View ContentView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ContentView = inflater.inflate(R.layout.fragment_fpage, container, false);
        unbinder = ButterKnife.bind(this, ContentView);
        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mRefreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mRefreshLayout.setRefreshing(false);
                    }
                }, 500);
            }
        });

        return ContentView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
