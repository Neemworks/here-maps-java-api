package com.nimworks.here.api;

import java.util.HashMap;
import java.util.Map;

import com.nimworks.here.HereContext;

abstract class HereApi {
	
	String path;
	HereContext ctx;

	public HereApi(HereContext ctx, String path) {
		this.ctx = ctx;
		this.path = path;
	}
	
	public String getURL() {
		return ctx.getBaseURL() + this.path;
	}
	
	public String getURL(String resourcePath) {
		return ctx.getBaseURL() + this.path + resourcePath;
	}
	
	public Map<String, Object> getHeaders() {
		Map<String, Object> headers = new HashMap<>();
		headers.put("Authorization", ctx.getAuthorizationHeader());
		
		return headers;
	}

}
