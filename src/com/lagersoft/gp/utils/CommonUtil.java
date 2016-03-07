package com.lagersoft.gp.utils;

import java.io.File;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.os.StatFs;
import android.view.Window;
import android.view.WindowManager;

/**
 * 公共工具类
 * @author bear
 *
 */
public class CommonUtil {

	private static CommonUtil INSTANCE = null;
	public static int MAIN_FRAGMENT_TAG_INDEX = 0;

	private CommonUtil() {
		// do nothing
	}

	

	public static boolean checkNet(Context context) {
		// 获取手机所有连接管理对象（包括对wi-fi,net等连接的管理）
		ConnectivityManager connectivityManager = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		// 获取NetworkInfo对象
		NetworkInfo[] networkInfo = connectivityManager.getAllNetworkInfo();
		for (int i = 0; i < networkInfo.length; i++) {
			if (networkInfo[i].getState() == NetworkInfo.State.CONNECTED) {
				return true;
			}
		}
		return false;
	}


	public static CommonUtil getInstance() {
		synchronized (INSTANCE) {
			if (INSTANCE == null) {
				INSTANCE = new CommonUtil();
			}
		}
		return INSTANCE;
	}


	public void setNoTitleBar(Activity activity) {
		activity.requestWindowFeature(Window.FEATURE_NO_TITLE);
	}

	public void setFullScreen(Activity activity) {
		activity.getWindow().setFlags(
				WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
	}


	public static void cancelFullScreen(Activity activity) {
		activity.getWindow().clearFlags(
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
	}

	public boolean isSDCardAvailable() {
		String status = Environment.getExternalStorageState();
		if (Environment.MEDIA_MOUNTED.equals(status)) {
			return true;
		} else {
			return false;
		}
	}

	public long getRealSizeOfSDCard() {
		File path = new File(Environment.getExternalStorageDirectory()
				.getAbsolutePath());
		StatFs stat = new StatFs(path.getPath());
		long blockSize = stat.getBlockSize();
		long availableBlocks = stat.getAvailableBlocks();
		return availableBlocks * blockSize;
	}

	public long getRealSizeOnPhone() {
		File path = Environment.getDataDirectory();
		StatFs stat = new StatFs(path.getPath());
		long blockSize = stat.getBlockSize();
		long availableBlocks = stat.getAvailableBlocks();
		long realSize = blockSize * availableBlocks;
		return realSize;
	}

	public boolean isEnoughSpaceOfSDCard(long needSize) {
		return needSize < getRealSizeOfSDCard();
	}

	public int dip2px(Context context, float dpValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);
	}

}
