package com.lagersoft.gp.base;

import com.lagersoft.grouppurchase.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
/**
 * 项目中的Fragment从BaseFragment继承
 * @author xiaoping
 *
 */
public class BaseFragment extends Fragment {
	
protected View titleView;
	
	protected void setTitleView(View rootView){
		this.titleView = rootView.findViewById(R.id.title_bar);
	}
	
	protected void setTitleView(LayoutInflater inflater,View rootView){
		this.titleView = rootView.findViewById(R.id.title_bar);
	}
	
	@SuppressWarnings("unchecked")
	public <T extends View> T getTitleChildView(int viewId){
		return (T)titleView.findViewById(viewId);
	}
	
	public BaseFragment setTitleViewVisibility(int visibleState, int ...viewId) {
		for(int i=0; i<viewId.length; i++){
			titleView.findViewById(viewId[i]).setVisibility(visibleState);
		}
		return this;
	}
	
	public BaseFragment setTitleViewText(int viewId, String content) {
		((TextView)titleView.findViewById(viewId)).setText(content);
		return this;
	}
	
	public BaseFragment setTitleViewText(int viewId, int contentId) {
		((TextView)titleView.findViewById(viewId)).setText(contentId);
		return this;
	}
	
	public BaseFragment setTitleViewBackground(int viewId, int resId){
		titleView.findViewById(viewId).setBackgroundResource(resId);
		return this;
	}
	

	/**
	 * 跳转到另外一个Activity
	 * 
	 * @param tClass 目标Activity
	 */
	protected void openActivity(Class<?> tClass){
		openActivity(tClass, null);
	}
	
	protected void openActivity(Class<?> tClass, Bundle bundle){
		Intent intent = new Intent(getActivity(),tClass);
		if(bundle != null){
			intent.putExtras(bundle);
		}
		startActivity(intent);
	}
	
	protected void showShortToast(String text){
		Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT).show();
	}
	
}
