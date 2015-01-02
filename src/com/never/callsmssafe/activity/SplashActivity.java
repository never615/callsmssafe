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

		// 获得屏幕的宽高
		int screenWidth = getWindowManager().getDefaultDisplay().getWidth();
		int screenHeight = getWindowManager().getDefaultDisplay().getHeight();
		// System.out.println("屏幕的高度："+screenHeight);
		// System.out.println("屏幕的宽度："+screenWidth);

		// 获得状态栏的高度
		Rect rect = new Rect();
		getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
		int statusBarHeight = rect.top;
		// System.out.println("状态栏的高度："+statusBarHeight);

		// 测量获得宽高
		int w = View.MeasureSpec.makeMeasureSpec(0,
				View.MeasureSpec.UNSPECIFIED);
		int h = View.MeasureSpec.makeMeasureSpec(0,
				View.MeasureSpec.UNSPECIFIED);
		iv_title.measure(w, h);
		int iv_title_height = iv_title.getMeasuredHeight();

		// System.out.println("标题的高度："+iv_title_height);

		//应该设置的gif的高度
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
	 * 进入主界面
	 */
	private void enterHome() {
		Intent intent = new Intent(this, CallSmsSafeActivity.class);
		startActivity(intent);
		finish(); // 退出当前界面
	}
}
