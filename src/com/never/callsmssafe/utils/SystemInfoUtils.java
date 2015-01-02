package com.never.callsmssafe.utils;

import java.util.List;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.Context;

public class SystemInfoUtils {
	/**
	 * 判断一个服务是否处于运行状态
	 * 
	 */
	public static boolean isServiceRunnning(Context context, String className) {
		ActivityManager am = (ActivityManager) context
				.getSystemService(Context.ACTIVITY_SERVICE);
		List<RunningServiceInfo> infos = am.getRunningServices(200); // 拿到正在运行的服务，参数设置能拿到的最大值
		for (RunningServiceInfo info : infos) {
			String serviceClassName = info.service.getClassName(); // 遍历拿到的服务，拿到服务对应的类名
			if (serviceClassName.equals(className)) {
				return true;
			}
		}
		return false;
	}
}
