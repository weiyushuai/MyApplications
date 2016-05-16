package com.example.wys.myapplication.util;

import android.content.Context;
import android.widget.Toast;

/**
 * ==========================================================
 *
 * 版 权 ： 北京世纪云联科技发展有限公司 （c） 2015
 *
 * 作 者 ：Growth
 *
 * 版 本 ：1.0
 *
 * 创建日期 ：2015-6-30 下午3:50:25
 *
 * 描 述 ：Toast工具类
 *
 *
 * 修订历史：
 *
 * ==========================================================
 **/
public class T {
	// Toast
	private static Toast toast;

	public static void s(Context context, CharSequence message) {
		if (null == toast) {
			toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
			// toast.setGravity(Gravity.CENTER, 0, 0);
		} else {
			toast.setText(message);
		}
		toast.show();
	}
	public static void s(Context context, int message) {
		if (null == toast) {
			toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
			// toast.setGravity(Gravity.CENTER, 0, 0);
		} else {
			toast.setText(message);
		}
		toast.show();
	}

	public static void showShort(Context context, CharSequence message) {
		if (null == toast) {
			toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
			// toast.setGravity(Gravity.CENTER, 0, 0);
		} else {
			toast.setText(message);
		}
		toast.show();
	}

	public static void showShort(Context context, int message) {
		if (null == toast) {
			toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
			// toast.setGravity(Gravity.CENTER, 0, 0);
		} else {
			toast.setText(message);
		}
		toast.show();
	}

	public static void showLong(Context context, CharSequence message) {
		if (null == toast) {
			toast = Toast.makeText(context, message, Toast.LENGTH_LONG);
			// toast.setGravity(Gravity.CENTER, 0, 0);
		} else {
			toast.setText(message);
		}
		toast.show();
	}

	public static void showLong(Context context, int message) {
		if (null == toast) {
			toast = Toast.makeText(context, message, Toast.LENGTH_LONG);
			// toast.setGravity(Gravity.CENTER, 0, 0);
		} else {
			toast.setText(message);
		}
		toast.show();
	}

	public static void show(Context context, CharSequence message, int duration) {
		if (null == toast) {
			toast = Toast.makeText(context, message, duration);
			// toast.setGravity(Gravity.CENTER, 0, 0);
		} else {
			toast.setText(message);
		}
		toast.show();
	}

	public static void show(Context context, int message, int duration) {
		if (null == toast) {
			toast = Toast.makeText(context, message, duration);
			// toast.setGravity(Gravity.CENTER, 0, 0);
		} else {
			toast.setText(message);
		}
		toast.show();
	}

	/** Hide the toast, if any. */
	public static void hideToast() {
		if (null != toast) {
			toast.cancel();
		}
	}
}
