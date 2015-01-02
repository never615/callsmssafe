package com.never.callsmssafe.test;

import java.util.List;

import android.content.Context;
import android.test.AndroidTestCase;

import com.never.callsmssafe.db.dao.BlackNumberDao;
import com.never.callsmssafe.domain.BlackNumberInfo;

public class TestBlackNumberDao extends AndroidTestCase {

	private Context context;

	// ����ֱ�ӻ��getContext�������������⣬setUpʱ�ڣ��ſ���get��context
	@Override
	protected void setUp() throws Exception {
		context = getContext();
		super.setUp();
	}

	/**
	 * �������
	 * 
	 * @throws Exception
	 */
	public void testAdd() throws Exception {
		BlackNumberDao dao = new BlackNumberDao(context);
		// boolean result=dao.add("18888888888", "1");
		// assertEquals(true, result);

		// ���һ���������ڲ���
		for (long i = 1; i < 301; i++) {
			dao.add(18888888000l + i + "", "1");
		}
	}

	/**
	 * ����ɾ��
	 * 
	 * @throws Exception
	 */
	public void testDelete() throws Exception {
		BlackNumberDao dao = new BlackNumberDao(context);
		// boolean result = dao.delete("18888888888");
		// assertEquals(true, result);
		for (long i = 1; i < 301; i++) {
			dao.delete(18888888000l + i + "");
		}
	}

	/**
	 * �����޸�
	 * 
	 * @throws Exception
	 */
	public void testUpdate() throws Exception {
		BlackNumberDao dao = new BlackNumberDao(context);
		boolean result = dao.changeBlockMode("18888888888", "2");
		assertEquals(true, result);
	}

	/**
	 * ���Բ�ѯ
	 * 
	 * @throws Exception
	 */
	public void testFind() throws Exception {
		BlackNumberDao dao = new BlackNumberDao(context);
		String mode = dao.findBlockMode("99999999999");
		System.out.println("��ѯ����");
		System.out.println(mode);
	}

	/**
	 * ���Ժ����Ƿ����
	 * 
	 */
	public void testIsBlack() throws Exception {
		BlackNumberDao dao = new BlackNumberDao(context);
		boolean flag=dao.isBlockMode("18888888300");
		System.out.println("flag:"+flag);
		assertEquals(true, flag);
	}

	/**
	 * ���Բ�ѯȫ��
	 * 
	 * @throws Exception
	 */
	public void testFindAll() throws Exception {
		BlackNumberDao dao = new BlackNumberDao(context);
		List<BlackNumberInfo> infos = dao.findAll();
		for (BlackNumberInfo info : infos) {
			System.out.println(info.getNumber() + "---" + info.getMode());
		}
	}
}
