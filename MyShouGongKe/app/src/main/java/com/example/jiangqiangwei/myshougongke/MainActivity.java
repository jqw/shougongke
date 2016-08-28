package com.example.jiangqiangwei.myshougongke;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import com.example.jiangqiangwei.myshougongke.fragment.HomePageFragment;
import com.example.jiangqiangwei.myshougongke.fragment.JIshiFragment;
import com.example.jiangqiangwei.myshougongke.fragment.JiaoChengFragment;
import com.example.jiangqiangwei.myshougongke.fragment.MineFragment;
import com.example.jiangqiangwei.myshougongke.fragment.ShouGongQuanFragment;
import com.example.jiangqiangwei.myshougongke.view.TabUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 分析项目原型（项目用mvc结构）分包实现 项目是有用户体系的有些界面需要做项目时候登录判断
 * 1.网络分析：用OKHttpUtils工具，图片下载工具使用Picasso
 * 2.数据层级：GsonFormat创建实体类，json解析使用fastjson,（数据库litepal做存储）
 * 3.View层：1.主框架底部导航进行切换（RadioGroup+Fragment切换（show,hide保存fragment状态））－－进行封装
 * 2.使用协调者布局创建fragment－－－－design
 * 3.项目界面封装BaseFragment,BaseActivity
 * 4.必要工具导入
 */
public class MainActivity extends AppCompatActivity {

    private TabUtils tabUtils;
    private HomePageFragment homePageFragment;
    private JiaoChengFragment jiaoChengFragment;
    private ShouGongQuanFragment shouGongQuanFragment;
    private JIshiFragment jIshiFragment;
    private MineFragment mineFragment;
    private List<Fragment> fragmentLists = new ArrayList<>();
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (homePageFragment == null) {
            homePageFragment = new HomePageFragment();
        }
        fragmentLists.add(homePageFragment);
        if (jiaoChengFragment == null) {
            jiaoChengFragment = new JiaoChengFragment();
        }
        fragmentLists.add(jiaoChengFragment);
        if (shouGongQuanFragment == null) {
            shouGongQuanFragment = new ShouGongQuanFragment();
        }
        fragmentLists.add(shouGongQuanFragment);
        if (jIshiFragment == null) {
            jIshiFragment = new JIshiFragment();
        }
        fragmentLists.add(jIshiFragment);
        if (mineFragment == null) {
            mineFragment = new MineFragment();
        }
        fragmentLists.add(mineFragment);

        radioGroup = (RadioGroup) findViewById(R.id.rg_main_buttonmenus);
        tabUtils = new TabUtils(getSupportFragmentManager(), fragmentLists, R.id.container_mainactivity, radioGroup);

    }
}
