package com.nimworks.here;

import java.util.Base64;

public class HereContext {
	
	private final String appId;
	private final String appCode;
	private RequestHandler handler;
	private String apiURL;

	HereContext(String appId, String appCode, String apiURL, RequestHandler handler) {
		this.appId = appId;
		this.apiURL = apiURL;
		this.handler = handler;
		this.appCode = appCode;
	}
	
	public String getAppId() {
		return appId;
	}
	
	public String getAppCode() {
		return appCode;
	}
	
	public String getAuthorizationHeader() {
		String auth = this.appId + ":" + this.appCode;
		return "Basic " + Base64.getEncoder().encodeToString(auth.getBytes());
	}
	
	public String getBaseURL() {
		return this.apiURL;
	}
	
	public RequestHandler getHandler() {
		return handler;
	}
	
	public static class Builder {
		
		private String appId;
		private String appCode;
		private String hereApiURL = "https://places.api.here.com";
		
		private RequestHandler handler;
		
		public Builder() {
			this.handler = new JaxRsRequestHandler();
		}
		
		public Builder(RequestHandler handler) {
			this.handler = handler;
		}
		
		
		Builder cit() {
			this.hereApiURL = "https://places.cit.api.here.com";
			return this;
		}
		
		public Builder appId(String appId) {
			this.appId = appId;
			return this;
		}
		
		public Builder appCode(String appCode) {
			
			this.appCode = appCode;
			return this;
		}
		
		public HereContext build() {
			return new HereContext(this.appId, this.appCode, this.hereApiURL, this.handler);
		}
		
	}

}
