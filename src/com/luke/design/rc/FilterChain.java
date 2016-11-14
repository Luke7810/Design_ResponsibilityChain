package com.luke.design.rc;
import java.util.ArrayList;
import java.util.List;


public class FilterChain implements Filter {
	
	List<Filter> filters = new ArrayList<Filter>();
	private int index = 0;
	
	//向链条中添加各种过滤器。
	public FilterChain addFilter(Filter fc){
		this.filters.add(fc);
		return this;
	}
	
	@Override
	//让各种添加进来的过滤器运行起来。
	public void doFilter(Request req, Response reps, FilterChain fc) {
		if(index == filters.size()) return;
		
		Filter f = filters.get(index);
		index++;
		f.doFilter(req, reps, fc);
	}

}

