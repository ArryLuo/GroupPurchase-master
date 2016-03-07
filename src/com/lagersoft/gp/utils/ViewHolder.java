package com.lagersoft.gp.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

public class ViewHolder {
	
	private SparseArray<View> mViews;//SparseArrays map integers to Objects
	@SuppressWarnings("unused")
	private int mPosition;
	private View mConvertView; //复用视图
	@SuppressWarnings("unused")
	private Context mContext;
	
	public ViewHolder(Context context,ViewGroup parent, int layoutId, int position){
		this.mContext = context;
		this.mPosition = position;
		this.mViews = new SparseArray<View>();
		this.mConvertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
		this.mConvertView.setTag(this);
	}
	
	public static ViewHolder get(Context context,View convertView, ViewGroup parent, int layoutId, int position){
		if(convertView == null){
			return new ViewHolder(context, parent, layoutId, position);
		}else{
			ViewHolder val = (ViewHolder) convertView.getTag();
			val.setPosition(position);
			return val;
		}
	}

	public View getConvertView() {
		return mConvertView;
	}
	
	public void setPosition(int mPosition) {
		this.mPosition = mPosition;
	}

	/**
	 * 通过viewId获取控件
	 * 
	 * @param viewId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T extends View> T getView(int viewId){
		View view = mViews.get(viewId);
		if(view == null){
			view = mConvertView.findViewById(viewId);
			mViews.put(viewId, view);
			
		}
		
		return (T)view;
	}
	
	public ViewHolder setVisibility(int visiableState, int ...viewId){
		for(int i=0; i<viewId.length; i++){
			getView(viewId[i]).setVisibility(visiableState);
		}
		return this;
	}
	
	public ViewHolder setText(int viewId, String content){
		((TextView) getView(viewId)).setText(content);
		return this;
	}
	
	public ViewHolder setStyledText(int viewId, SpannableString spannableString){
		((TextView) getView(viewId)).setText(spannableString, TextView.BufferType.SPANNABLE);
		return this;
	}
	

	
	public ViewHolder setBackground(int viewId, int resId){
		getView(viewId).setBackgroundResource(resId);
		return this;
	}

	public ViewHolder setBackgroundDrawable(int viewId,Drawable drawable){
		getView(viewId).setBackgroundDrawable(drawable);
		return this;
	}
	
	public ViewHolder setIsSelected(int viewId,boolean isChecked) {
		CheckBox cbx = (CheckBox)getView(viewId);
		cbx.setChecked(isChecked);
		return this;
	}
	
	
}
