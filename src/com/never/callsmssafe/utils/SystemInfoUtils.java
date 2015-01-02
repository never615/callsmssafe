package com.never.callsmssafe.utils;

import java.util.List;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.Context;

public class SystemInfoUtils {
	/**
	 * �ж�һ�������Ƿ�������״̬
	 * 
	 */
	public static boolean isServiceRunnning(Context context, String className) {
		ActivityManager am = (ActivityManager) context
				.getSystemService(Context.ACTIVITY_SERVICE);
		List<RunningServiceInfo> infos = am.getRunningServices(200); // �õ��������еķ��񣬲����������õ������ֵ
		for (RunningServiceInfo info : infos) {
			String serviceClassName = info.service.getClassName(); // �����õ��ķ����õ������Ӧ������
			if (serviceClassName.equals(className)) {
				return true;
			}
		}
		return false;
	}
}
