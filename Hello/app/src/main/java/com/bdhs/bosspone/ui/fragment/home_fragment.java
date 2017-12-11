package com.bdhs.bosspone.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bdhs.bosspone.R;

/**
 * Created by 14487 on 2017/9/17.
 */

public class home_fragment extends Fragment {

    private View ContentView;
    private SwipeRefreshLayout mRefreshLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ContentView = inflater.inflate(R.layout.fragment_fpage,container,false);
        mRefreshLayout = (SwipeRefreshLayout) ContentView.findViewById(R.id.main_refresh_layout);
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
}
