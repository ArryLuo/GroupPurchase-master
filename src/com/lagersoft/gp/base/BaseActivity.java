package com.lagersoft.gp.base;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.lagersoft.grouppurchase.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 自定义的Activity,项目中Activity从BaseActivity继承
 * @author xiaoping
 *
 */
public class BaseActivity extends Activity{
	
	//标题栏的设置
	/****************************************************************************/
	protected View titleView;
	
	protected void setTitleView(View rootView){
		this.titleView = rootView.findViewById(R.id.title_bar);
	}
	
	@SuppressWarnings("unchecked")
	public <T extends View> T getTitleChildView(int viewId){
		return (T)titleView.findViewById(viewId);
	}
	
	public BaseActivity setTitleViewVisibility(int visibleState, int ...viewId) {
		for(int i=0; i<viewId.length; i++){
			titleView.findViewById(viewId[i]).setVisibility(visibleState);
		}
		return this;
	}
	
	public BaseActivity setTitleViewText(int viewId, String content) {
		((TextView)titleView.findViewById(viewId)).setText(content);
		return this;
	}
	
	public BaseActivity setTitleViewText(int viewId, int contentId) {
		((TextView)titleView.findViewById(viewId)).setText(contentId);
		return this;
	}
	
	public BaseActivity setTitleViewBackground(int viewId, int resId){
		titleView.findViewById(viewId).setBackgroundResource(resId);
		return this;
	}
	/****************************************************************************/
	
	/**
	 * 跳转到另外一个Activity
	 * 
	 * @param tClass 目标Activity
	 */
	protected void openActivity(Class<?> tClass){
		openActivity(tClass, null);
	}
	
	protected void openActivity(Class<?> tClass, Bundle bundle){
		Intent intent = new Intent(this,tClass);
		if(bundle != null){
			intent.putExtras(bundle);
		}
		startActivity(intent);
	}
	
	/**
	 * 播放Activity跳转动画
	 */
	protected void finishWithRightAnim(){
		this.finish();
		overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
	}
	
	/**
	 * 播放Activity跳转动画
	 */
	protected void finishWithLeftAnim(){
		this.finish();
		overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
	}
	
	/**
	 * 打印Toast
	 * @param text
	 */
	protected void showShortToast(String text){
		Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
	}
	
	/**
	 * MIUI设置沉浸式状态栏方法
	 * @param rootView
	 */
	protected void setImmerseStatusBar(View rootView){
		boolean sIsMiuiV6 = false;
		try {
            Class<?> sysClass = Class.forName("android.os.SystemProperties");
            Method getStringMethod = sysClass.getDeclaredMethod("get", String.class);
            sIsMiuiV6 = "V6".equals((String) getStringMethod.invoke(sysClass, "ro.miui.ui.version.name")) || "V7".equals((String) getStringMethod.invoke(sysClass, "ro.miui.ui.version.name"));
        } catch (Exception e) {
            e.printStackTrace();
        }
		if(sIsMiuiV6){
			Window window = getWindow();
			Class clazz = window.getClass(); 
			try {
				int tranceFlag = 0; int darkModeFlag = 0; 
				Class layoutParams = Class.forName("android.view.MiuiWindowManager$LayoutParams");
				Field field = layoutParams.getField("EXTRA_FLAG_STATUS_BAR_TRANSPARENT"); 
				tranceFlag = field.getInt(layoutParams);
				field = layoutParams.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE"); darkModeFlag = field.getInt(layoutParams);
				Method extraFlagField = clazz.getMethod("setExtraFlags", int.class, int.class);  //只需要状态栏透明 
				extraFlagField.invoke(window, tranceFlag, tranceFlag); //状态栏透明且黑色字体 
				extraFlagField.invoke(window, tranceFlag | darkModeFlag, tranceFlag | darkModeFlag);//清除黑色字体
				extraFlagField.invoke(window, 0, darkModeFlag); }
			catch (NoSuchMethodException e) { 
				e.printStackTrace(); }
			catch (ClassNotFoundException e) { 
				e.printStackTrace(); } 
			catch (NoSuchFieldException e) { 
				e.printStackTrace(); }
			catch (IllegalAccessException e) { 
				e.printStackTrace(); } 
			catch (IllegalArgumentException e) { 
				e.printStackTrace(); }
			catch (InvocationTargetException e) { 
				e.printStackTrace(); }

			RelativeLayout title = (RelativeLayout)rootView.findViewById(R.id.title_bar);
			LayoutParams params = new LayoutParams(
			        LayoutParams.MATCH_PARENT,      
			        LayoutParams.WRAP_CONTENT
			);
			WindowManager wm = (WindowManager) this
                    .getSystemService(Context.WINDOW_SERVICE);
			int width = wm.getDefaultDisplay().getWidth();
			int height = wm.getDefaultDisplay().getHeight();
			params.height = (int) (height*0.09);
			title.setLayoutParams(params);
			title.setGravity(Gravity.BOTTOM);
			title.setPadding(0, (int) (height*0.016), 0, 0);
		}
	}
	
	
}
