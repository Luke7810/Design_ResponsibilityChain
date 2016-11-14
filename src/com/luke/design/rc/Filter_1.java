package com.luke.design.rc;

public class Filter_1 implements Filter {

	@Override
	public void doFilter(Request req, Response reps, FilterChain fc) {
		String strIn = req.getRequestStr();
		strIn = strIn.replace("<Script>", "")+"---Filter_1";
		req.setRequestStr(strIn);
		
		fc.doFilter(req, reps, fc); //������ص㣬��ʱ��fc�ٴ�ִ��doFilter����ʱindexָ���Ѿ���������ʼִ�еڶ���Filter���γɶ�ջ��
		
		//��ջ��ɺ�ʼ���������պ���ȳ���ԭ��ʼ����Response�ַ���
		reps.setResponseStr(reps.getResponseStr()+"---Filter_1");
		
	}

}
