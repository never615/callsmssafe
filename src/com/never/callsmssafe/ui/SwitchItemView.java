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
			System.out.println("�����û");
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
		//--�ؼ���ʵ����
		View view = View.inflate(context, R.layout.view_switch, null);
		//--��ʾ��������
		this.addView(view);
		//--�ҵ��ؼ��еĸ����ӿؼ�
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
	 * �޸�ѡ��״̬
	 * 
	 * @param b
	 */
	public void setChecked(boolean b) {
		cb_switch.setChecked(b);
	}

	/**
	 * �Ƿ�ѡ��
	 * 
	 * @return
	 */
	public boolean isChecked() {
		return cb_switch.isChecked();
	}
}
