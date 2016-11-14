package com.luke.design.rc;

public class Filter_1 implements Filter {

	@Override
	public String doFilter(String strIn) {
		// TODO Auto-generated method stub
		return strIn.replace("<Script>","");
	}

}
