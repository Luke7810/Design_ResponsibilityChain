package com.luke.design.rc;

public interface Filter {
	public void doFilter(Request req, Response reps, FilterChain fc);
}
