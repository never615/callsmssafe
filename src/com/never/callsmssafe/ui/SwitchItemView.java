package com.never.callsmssafe.ui;


import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.never.callsmssafe.R;

public class SwitchItemView extends LinearLayout {

	private static final String ATTRS = "http://schemas.android.com/apk/res/com.never.callsmssafe";
	private static final int BACKGROUNG = android.R.color.transparent;
	private ImageView iv_icon;
	private TextView tv_key;
	private CheckBox cb_switch;
	private View item_translucent;
	
	
	public SwitchItemView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(context);
	}

	public SwitchItemView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
		
		int icon = attrs.getAttributeResourceValue(ATTRS, "icon", BACKGROUNG);
		if(icon != BACKGROUNG)
		{
			this.setIcon(icon);
		}
		String key = attrs.getAttributeValue(ATTRS, "key");
		if(!TextUtils.isEmpty(key))
		{
			System.out.println("输出了没");
			this.setKeyText(key);
		}
		//String value = attrs.getAttributeValue(ATTRS, "value");
		int buttonbackground = attrs.getAttributeResourceValue(ATTRS, "buttonbackground", BACKGROUNG);
		if(buttonbackground != BACKGROUNG)
		{
			this.setButtonBackgroundResource(buttonbackground);
		}
		int itembackground = attrs.getAttributeResourceValue(ATTRS, "itembackground", BACKGROUNG);
		if(itembackground != BACKGROUNG)
		{
			this.setButtonBackgroundResource(itembackground);
		}
	}

	public SwitchItemView(Context context) {
		super(context);
		init(context);
	}

	private void init(Context context)
	{
		//--控件的实例化
		View view = View.inflate(context, R.layout.view_switch, null);
		//--显示到本身上
		this.addView(view);
		//--找到控件中的各个子控件
		iv_icon = (ImageView) view.findViewById(R.id.iv_icon);
		tv_key = (TextView) view.findViewById(R.id.tv_key);
		cb_switch = (CheckBox) view.findViewById(R.id.cb_switch);
		item_translucent = view.findViewById(R.id.item_translucent);
	}
	
	public void setIcon(int resid)
	{
		iv_icon.setBackgroundResource(resid);
	}
	
	public void setKeyText(String text)
	{
		tv_key.setText(text);
	}
	
	
	public void setButtonBackgroundResource(int resid)
	{
		cb_switch.setBackgroundResource(resid);
	}
	
	public void setItemBackgroudResource(int resid )
	{
		item_translucent.setBackgroundResource(resid);
	}
	
	@Override
	public void setEnabled(boolean enabled) {
		super.setEnabled(enabled);
		cb_switch.setEnabled(enabled);
		if(enabled)
		{
			item_translucent.setVisibility(View.INVISIBLE);
		}
		else
		{
			item_translucent.setVisibility(View.VISIBLE);
		}
	}

	/**
	 * 修改选中状态
	 * 
	 * @param b
	 */
	public void setChecked(boolean b) {
		cb_switch.setChecked(b);
	}

	/**
	 * 是否被选中
	 * 
	 * @return
	 */
	public boolean isChecked() {
		return cb_switch.isChecked();
	}
}
