package com.never.callsmssafe.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.never.callsmssafe.services.CallSmsSafeService;
import com.never.callsmssafe.ui.SwitchItemView;
import com.never.callsmssafe.utils.SystemInfoUtils;
import com.never.callsmssafe.R;

public class SettingActivity extends Activity {

	/**
	 * ������
	 */
	@ViewInject(R.id.sv_setting_callsmssafe)
	private SwitchItemView sv_setting_callsmssafe;
	private Intent callSmsSafeIntent;

	private SharedPreferences sp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_setting);
		ViewUtils.inject(this);
		sp = getSharedPreferences("config", MODE_PRIVATE);

		/**
		 * ������
		 */
		// �����Ƿ������������صļ����¼�
		callSmsSafeIntent = new Intent(this, CallSmsSafeService.class);
		sv_setting_callsmssafe.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (sv_setting_callsmssafe.isChecked()) {
					// �رպ��������ط���
					sv_setting_callsmssafe.setChecked(false);
					stopService(callSmsSafeIntent);
					Editor editor = sp.edit();
					editor.putBoolean("blackserver", false);
					editor.commit();
				} else {
					// �������������ط���
					sv_setting_callsmssafe.setChecked(true);
					startService(callSmsSafeIntent);
					Editor editor = sp.edit();
					editor.putBoolean("blackserver", true);
					editor.commit();
				}
			}
		});

	}

	/**
	 * ���ذ�ť����¼�
	 */
	public void setting_back(View view) {
		finish();
	}

	@Override
	protected void onStart() {
		super.onStart();
		/**
		 * ������������״̬����
		 */
		Intent intent = new Intent(this, CallSmsSafeService.class);
		boolean flag = sp.getBoolean("blackserver", false);
		boolean running = SystemInfoUtils.isServiceRunnning(this,
				"com.never.callsmssafe.services.CallSmsSafeService");
		if (flag) {
			if (running) {
				sv_setting_callsmssafe.setChecked(true);
			} else {
				sv_setting_callsmssafe.setChecked(true);
				startService(intent);
			}
		} else {
			sv_setting_callsmssafe.setChecked(false);

		}

		/*if (running) {
			sv_setting_callsmssafe.setChecked(true);
		} else {
			sv_setting_callsmssafe.setChecked(false);
		}*/
	}
}
