package com.example.jiangqiangwei.myshougongke.ui.fragment.homefragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jiangqiangwei.myshougongke.R;
import com.example.jiangqiangwei.myshougongke.adapter.MyRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * 购物的fragment
 * RecyclerView+多布局
 */
public class ShopFragment extends Fragment {


    @BindView(R.id.recyclerview_fragmentshop_show)
    RecyclerView recyclerviewFragmentshopShow;
    @BindView(R.id.swiperefresh_fragmentshop)
    SwipeRefreshLayout swiperefreshFragmentshop;
    private List<String> list;
    private MyRecyclerViewAdapter adapter;
    private LinearLayoutManager linearLayoutManager;

    public ShopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_shop, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        //设置刷新的颜色
        swiperefreshFragmentshop.setColorSchemeColors(Color.BLACK);
        list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("item" + i);
        }
        linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerviewFragmentshopShow.setLayoutManager(linearLayoutManager);
        adapter = new MyRecyclerViewAdapter(getActivity(), list);
        recyclerviewFragmentshopShow.setAdapter(adapter);
    }

}
