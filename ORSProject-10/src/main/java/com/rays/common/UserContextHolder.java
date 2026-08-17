package com.rays.common;

public class UserContextHolder {
	
	private static final ThreadLocal< UserContext> threadlocal = new ThreadLocal<UserContext>();
	
	public static void setContext(UserContext usercontext) {
		threadlocal.set(usercontext);
		
		
	}
	
	public static UserContext getContext() {
		return threadlocal.get();
			
	}
	
	public static void clean() {
		threadlocal.remove();
	}

}
