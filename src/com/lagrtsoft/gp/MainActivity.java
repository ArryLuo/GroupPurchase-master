package com.lagrtsoft.gp;

import com.lagersoft.gp.fragment.DisFragment;
import com.lagersoft.gp.fragment.HomePageFragment;
import com.lagersoft.gp.fragment.MeFragment;
import com.lagersoft.gp.fragment.SerFragment;
import com.lagersoft.gp.utils.CommonUtil;
import com.lagersoft.grouppurchase.R;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * FragmentTabHost 实现的Tab页卡界面
 * @author xiaoping
 *
 */
public class MainActivity extends FragmentActivity {


	private static final String TAB_ACTION_CENTER = "home_page"; //  首页
	private static final String TAB_SER = "ser_page"; // 服务
	private static final String TAB_ME = "me_page"; //我
	private static final String TAB_DIS = "dis_page"; //配送

	private static final float TAB_TEXT_SIZE = 12;

	private FragmentTabHost mFragmentTabHost = null;
	
	//四个页面的图片资源Id
	private int[] iconResIDs = { 
			R.drawable.selector_tab_homepage,
			R.drawable.selector_tab_ser,
			R.drawable.selector_tab_dis,
			R.drawable.selector_tab_me};
	//四个页面的名称Id
	private int[] textResIDs = { R.string.tab_home_page_text,
			R.string.tab_ser_text,R.string.tab_dis_text , R.string.tab_me_text};
	//四个页面代表字符串
	public String[] tabSpecs = { 
			TAB_ACTION_CENTER, 
			TAB_SER,
			TAB_DIS,
			TAB_ME };
	//四个页面对应的Fragment对应的类类型(Class type)
	private Class<?>[] fragmentClasses = { HomePageFragment.class,
			SerFragment.class,DisFragment.class, MeFragment.class };
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initFragmentTabHost();
	}
	
	@Override
	protected void onResume() {
		System.out.println("mainactivity onresume");
		if(CommonUtil.MAIN_FRAGMENT_TAG_INDEX != 0){
			mFragmentTabHost.setCurrentTab(CommonUtil.MAIN_FRAGMENT_TAG_INDEX);
			CommonUtil.MAIN_FRAGMENT_TAG_INDEX = 0;
		}
		super.onResume();
	}
	
	@Override
	protected void onResumeFragments() {
		// TODO Auto-generated method stub
		System.out.println("mainactivity onresume fragments");
		super.onResumeFragments();
	}

	//加载FragmentTabHost
	private void initFragmentTabHost() {
		//获取到FragmentTabHost对象
		mFragmentTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
		mFragmentTabHost.setup(this, getSupportFragmentManager(),
				android.R.id.tabcontent);
		for(int i=0; i<iconResIDs.length; i++){
			View view = LayoutInflater.from(this).inflate(R.layout.tab_indicator,
					null);
			ImageView iv = (ImageView) view.findViewById(R.id.tabIV);
			TextView tv = (TextView) view.findViewById(R.id.tabText);
			tv.setTextSize(TAB_TEXT_SIZE);
			iv.setImageResource(iconResIDs[i]);
			tv.setText(getResources().getString(textResIDs[i]));
			mFragmentTabHost.addTab(mFragmentTabHost.newTabSpec(tabSpecs[i])
					.setIndicator(view), fragmentClasses[i], null);
		}
		
	}
}
