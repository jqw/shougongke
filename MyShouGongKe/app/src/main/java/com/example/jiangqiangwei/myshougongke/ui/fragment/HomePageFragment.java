package com.example.jiangqiangwei.myshougongke.ui.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jiangqiangwei.myshougongke.R;
import com.example.jiangqiangwei.myshougongke.adapter.CommonFragmentPagerAdapter;
import com.example.jiangqiangwei.myshougongke.ui.fragment.homefragment.DaJiaPDFragment;
import com.example.jiangqiangwei.myshougongke.ui.fragment.homefragment.DianPuDQFragment;
import com.example.jiangqiangwei.myshougongke.ui.fragment.homefragment.LiWuJXFragment;
import com.example.jiangqiangwei.myshougongke.ui.fragment.homefragment.NewsSPFragment;
import com.example.jiangqiangwei.myshougongke.ui.fragment.homefragment.ReMenHDFragment;
import com.example.jiangqiangwei.myshougongke.ui.fragment.homefragment.ShopFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * 首页界面
 * mvp结构书写
 * 可折叠布局CoordinatorLayout
 * ButterKnife查找控件
 */
public class HomePageFragment extends Fragment {


    @BindView(R.id.toolbar_fragmenthome_topmenu)
    Toolbar toolbarFragmenthomeTopmenu;
    @BindView(R.id.tablayout_fragmenthome_tabs)
    TabLayout tablayoutFragmenthomeTabs;
    @BindView(R.id.viewpager_fragmenthome_show)
    ViewPager viewpagrFragmenthomeShow;
    private List<String> titles;
    private List<Fragment> fragments;

    private ShopFragment shopFragment;
    private LiWuJXFragment liWuJXFragment;
    private DaJiaPDFragment daJiaPDFragment;
    private NewsSPFragment newsSPFragment;
    private DianPuDQFragment dianPuDQFragment;
    private ReMenHDFragment reMenHDFragment;
    private CommonFragmentPagerAdapter commonFragmentPagerAdapter;

    public HomePageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_page, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        initView();
    }

    private void initView() {
        titles = new ArrayList<>();
        titles.add("购物");
        titles.add("礼物精选");
        titles.add("大家频道");
        titles.add("最新商品");
        titles.add("店铺大全");
        titles.add("热门活动");
        //初始化Tabs
        for (int i = 0; i < titles.size(); i++) {
            tablayoutFragmenthomeTabs.addTab(tablayoutFragmenthomeTabs.newTab().setText(titles.get(i)));
        }
        fragments = new ArrayList<>();
        if (shopFragment == null) {
            shopFragment = new ShopFragment();
        }
        fragments.add(shopFragment);
        if (liWuJXFragment == null) {
            liWuJXFragment = new LiWuJXFragment();
        }
        fragments.add(liWuJXFragment);
        if (daJiaPDFragment == null) {
            daJiaPDFragment = new DaJiaPDFragment();
        }
        fragments.add(daJiaPDFragment);
        if (newsSPFragment == null) {
            newsSPFragment = new NewsSPFragment();
        }
        fragments.add(newsSPFragment);
        if (dianPuDQFragment == null) {
            dianPuDQFragment = new DianPuDQFragment();
        }
        fragments.add(dianPuDQFragment);
        if (reMenHDFragment == null) {
            reMenHDFragment = new ReMenHDFragment();
        }
        fragments.add(reMenHDFragment);
        commonFragmentPagerAdapter=new CommonFragmentPagerAdapter(getChildFragmentManager(),fragments);
        commonFragmentPagerAdapter.setTitles(titles);
        viewpagrFragmenthomeShow.setAdapter(commonFragmentPagerAdapter);
        //关联2者
        tablayoutFragmenthomeTabs.setupWithViewPager(viewpagrFragmenthomeShow);

    }

}
