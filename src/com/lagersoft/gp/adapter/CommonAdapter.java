package com.lagersoft.gp.adapter;

import java.util.List;

import com.lagersoft.gp.utils.ViewHolder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
/**
 * 万能是适配器
 * @author xiaoping
 * 泛型为需适配的实体类对象
 * @param <T>
 */
public abstract class CommonAdapter<T> extends BaseAdapter{
	
	private Context mContext;
	private List<T> mList;
	private int itemLayoutId;
	
	public CommonAdapter(Context context, List<T> list, int layoutId){
		this.mContext = context;
		this.mList = list;
		this.itemLayoutId = layoutId;
	}
	
	@Override
	public int getCount() {
		return mList.size();
	}

	@Override
	public T getItem(int position) {
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent){
		ViewHolder vh = ViewHolder.get(mContext, convertView, parent, itemLayoutId, position);
		convert(vh, mList.get(position));
		vh.getConvertView().setTag(vh);
		return vh.getConvertView();
	} 
	
	public abstract void convert(ViewHolder vh, T t);

}
