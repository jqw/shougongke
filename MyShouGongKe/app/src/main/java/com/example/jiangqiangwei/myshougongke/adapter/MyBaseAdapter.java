/**
 * Title: MyBaseAdapter.java
 * Description:
 * Copyright: Copyright (c) 2007
 * Company: LTGames
 * @author linrz
 * @date 2015-1-28
 * @version 1.0
 */
package com.example.jiangqiangwei.myshougongke.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public abstract class MyBaseAdapter<T> extends BaseAdapter {
	
	public List<T> list;
	public Context context;
	public LayoutInflater layoutinflater;


	public MyBaseAdapter(List<T> list, Context context) {
		// super();
		this.list = list;
		this.context = context;
		layoutinflater = LayoutInflater.from(context);


	}

	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub

		return getItemView(position, convertView, parent);
	}

	public abstract View getItemView(int position, View convertView,
			ViewGroup parent);

}
