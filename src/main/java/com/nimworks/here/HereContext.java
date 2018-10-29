package com.nimworks.here;

public class HereContext {
	
	private final String appId;
	private final String appCode;
	private RequestHandler handler;

	HereContext(String appId, String appCode, RequestHandler handler) {
		this.appId = appId;
		this.appCode = appCode;
	}
	
	public String getAppId() {
		return appId;
	}
	
	public String getAppCode() {
		return appCode;
	}
	
	public RequestHandler getHandler() {
		return handler;
	}
	
	public static class Builder {
		
		private String appId;
		private String appCode;
		
		private RequestHandler handler;
		
		public Builder() {
			this.handler = new JaxRsRequestHandler();
		}
		
		public Builder(RequestHandler handler) {
			this.handler = handler;
		}
		
		
		Builder baseUrl(String baseUrl) {
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
			return new HereContext(this.appId, this.appCode, this.handler);
		}
		
	}

}
