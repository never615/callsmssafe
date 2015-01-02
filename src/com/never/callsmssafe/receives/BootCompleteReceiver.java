package com.never.callsmssafe.receives;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.util.Log;

import com.never.callsmssafe.services.CallSmsSafeService;

public class BootCompleteReceiver extends BroadcastReceiver {
	private SharedPreferences sp;

	@Override
	public void onReceive(Context context, Intent intent) {
		sp=context.getSharedPreferences("config", context.MODE_PRIVATE);
		boolean flag=sp.getBoolean("blackserver", false);
		System.out.println("开机启动黑名单拦截服务"+flag);
		Intent callSmsSafeIntent = new Intent(context, CallSmsSafeService.class);
		
		if(flag){
			// 开机启动黑名单拦截
			context.startService(callSmsSafeIntent);
		}
	}

}
