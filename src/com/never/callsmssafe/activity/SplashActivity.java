package com.never.callsmssafe.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.ant.liao.GifView;
import com.ant.liao.GifView.GifImageType;
import com.never.callsmssafe.R;

public class SplashActivity extends Activity {
	private GifView gf1;
	private RelativeLayout rl;
	private ImageView iv_title;

	/**
	 * handler
	 */
	Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			enterHome();
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_splash);
		rl = (RelativeLayout) findViewById(R.id.rl);
		iv_title = (ImageView) findViewById(R.id.iv_title);
		gf1 = (GifView) findViewById(R.id.gif1);

		// �����Ļ�Ŀ��
		int screenWidth = getWindowManager().getDefaultDisplay().getWidth();
		int screenHeight = getWindowManager().getDefaultDisplay().getHeight();
		// System.out.println("��Ļ�ĸ߶ȣ�"+screenHeight);
		// System.out.println("��Ļ�Ŀ�ȣ�"+screenWidth);

		// ���״̬���ĸ߶�
		Rect rect = new Rect();
		getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
		int statusBarHeight = rect.top;
		// System.out.println("״̬���ĸ߶ȣ�"+statusBarHeight);

		// ������ÿ��
		int w = View.MeasureSpec.makeMeasureSpec(0,
				View.MeasureSpec.UNSPECIFIED);
		int h = View.MeasureSpec.makeMeasureSpec(0,
				View.MeasureSpec.UNSPECIFIED);
		iv_title.measure(w, h);
		int iv_title_height = iv_title.getMeasuredHeight();

		// System.out.println("����ĸ߶ȣ�"+iv_title_height);

		//Ӧ�����õ�gif�ĸ߶�
		int gif_height = screenHeight - iv_title_height - statusBarHeight;

		gf1.setGifImageType(GifImageType.COVER);
		gf1.setShowDimension(screenWidth, gif_height);// 400*3, 571*3 1080 1920
		gf1.setGifImage(R.drawable.gif_1);

		new Thread() {
			public void run() {
				SystemClock.sleep(2000);
				handler.sendEmptyMessage(0);
			};
		}.start();
	}

	/**
	 * ����������
	 */
	private void enterHome() {
		Intent intent = new Intent(this, CallSmsSafeActivity.class);
		startActivity(intent);
		finish(); // �˳���ǰ����
	}
}
