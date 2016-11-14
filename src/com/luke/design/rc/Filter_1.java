package com.luke.design.rc;

public class Filter_1 implements Filter {

	@Override
	public void doFilter(Request req, Response reps, FilterChain fc) {
		String strIn = req.getRequestStr();
		strIn = strIn.replace("<Script>", "")+"---Filter_1";
		req.setRequestStr(strIn);
		
		fc.doFilter(req, reps, fc); //这句是重点，这时让fc再次执行doFilter，这时index指针已经下跳，开始执行第二个Filter，形成堆栈。
		
		//堆栈完成后开始弹出，按照后进先出的原则开始处理Response字符串
		reps.setResponseStr(reps.getResponseStr()+"---Filter_1");
		
	}

}
