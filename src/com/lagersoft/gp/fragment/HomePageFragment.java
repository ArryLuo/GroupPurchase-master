package com.lagersoft.gp.fragment;

import com.lagersoft.gp.base.BaseFragment;
import com.lagersoft.grouppurchase.R;
import com.lagersoft.grouppurchase.SearchActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.TextView;

/**
 * 首页
 * 
 * @author xiaoping
 * 
 */
public class HomePageFragment extends BaseFragment implements OnClickListener {
	private View view;
	private TextView btnSearch;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		view = inflater.inflate(R.layout.fragment_home_page, null);
		initTitleBar(inflater, view);
		setupView();
		return view;
	}

	/**
	 * 初始化控件
	 */
	private void setupView() {
		btnSearch = (TextView) view.findViewById(R.id.btn_search);
		btnSearch.setOnClickListener(this);

	}

	private void initTitleBar(LayoutInflater inflater, View view2) {
		setTitleView(inflater, view);
		setTitleViewVisibility(View.GONE, R.id.title);
		setTitleViewVisibility(View.VISIBLE, R.id.left_location,
				R.id.btn_search);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_search:
			showShortToast("在这儿跳转搜索页");
			openActivity(SearchActivity.class);
			break;

		default:
			break;
		}
	}
}
