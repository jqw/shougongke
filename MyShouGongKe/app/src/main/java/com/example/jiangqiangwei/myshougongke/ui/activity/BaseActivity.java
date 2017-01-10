package com.example.jiangqiangwei.myshougongke.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import com.example.jiangqiangwei.myshougongke.ui.fragment.BaseFragment;

/**
 * 思考全局的activity有哪些共有的东西
 * 进行提取抽象成一个共有的activity
 * 1.需不需要进行替换显示fragment
 * 2.有没有对话框进度提示框
 * 3.有没有单例的工具类
 * 4.有没有共有的逻辑比如分享，登录判断。。。
 * 5.有没有activity之间的跳转动画
 * 6.返回键的事件
 * 。。。。。。具体的根据项目情况在进行添加
 *
 */
public abstract class BaseActivity extends AppCompatActivity{

	//布局文件ID
	protected abstract int getContentViewId();

	//布局中Fragment的ID
	protected abstract int getFragmentContentId();

	//添加fragment
	public void addFragment(BaseFragment fragment) {
		if (fragment != null) {
			getSupportFragmentManager().beginTransaction()
					.replace(getFragmentContentId(), fragment, fragment.getClass().getSimpleName())
					.addToBackStack(fragment.getClass().getSimpleName())
					.commitAllowingStateLoss();
		}
	}

	//移除fragment
	public void removeFragment() {
		if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
			getSupportFragmentManager().popBackStack();
		} else {
			finish();
		}
	}

	//返回键返回事件
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (KeyEvent.KEYCODE_BACK == keyCode) {
			if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
				finish();
				return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
}
