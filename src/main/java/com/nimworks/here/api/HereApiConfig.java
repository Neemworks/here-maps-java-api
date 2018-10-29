package com.nimworks.here.api;

public class HereApiConfig {
	
	private final String path;
	private String hostname = "https://places.cit.api.here.com/";

	public HereApiConfig(String path) {
		this.path = path;
	}
	
	public HereApiConfig host(String host) {
		this.hostname = host;
		return this;
	}
	
	public String apiUrl() {
		return this.hostname + this.path;
	}

}
