package com.luke.design.rc;

public class Filter_2 implements Filter {

	@Override
	public void doFilter(Request req, Response reps, FilterChain fc) {
		String strIn = req.getRequestStr();
		strIn = strIn.replace("敏感字","")+"---Filter_2";
		req.setRequestStr(strIn);
		fc.doFilter(req, reps, fc);
		reps.setResponseStr(reps.getResponseStr()+"---Filter_2");
		
	}

}
