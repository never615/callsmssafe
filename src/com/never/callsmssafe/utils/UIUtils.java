package com.never.callsmssafe.utils;

import android.app.Activity;
import android.widget.Toast;

/**
 * ���������߳��е���toast
 * @author rong
 *
 */
public class UIUtils {
	public static void showToast(final Activity context,final String msg){
		if("main".equals(Thread.currentThread().getName())){
			Toast.makeText(context, msg, 1).show();
		}else{
				context.runOnUiThread(new Runnable() {
					
					@Override
					public void run() {
						Toast.makeText(context, msg, 1).show();
					}
				});
		}
	}
}