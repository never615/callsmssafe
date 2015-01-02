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
		System.out.println("�����������������ط���"+flag);
		Intent callSmsSafeIntent = new Intent(context, CallSmsSafeService.class);
		
		if(flag){
			// ������������������
			context.startService(callSmsSafeIntent);
		}
	}

}
