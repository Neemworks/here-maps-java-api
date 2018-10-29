package com.nimworks.here.api;

import java.util.HashMap;

import com.nimworks.here.HereContext;
import com.nimworks.here.model.PlaceSuggestionResponse;

public class PlacesApi {
	
	private HereApiConfig config;
	private HereContext ctx;

	public PlacesApi(HereContext ctx) {
		this.ctx = ctx;
	}

	public static void main(String[] args) {
		HereContext ctx = new HereContext.Builder()
			.appId("wAb2RJLKmNyvq2Slgfit")
			.appCode("QRNC5ol4GZ0hsoB60o7t4w")
			.build();
		
		PlacesApi api = new PlacesApi(ctx);
		System.out.println(api.suggest("berlin"));
	}
	
	public PlaceSuggestionResponse suggest(String title) {
		
		String baseUrl = "https://places.cit.api.here.com/places/v1/autosuggest?q=" + title;
		baseUrl += "&appId=" + ctx.getAppId();
		baseUrl += "&appCode=" + ctx.getAppCode();
		return ctx.getHandler().handleGet(baseUrl, PlaceSuggestionResponse.class, new HashMap<String, Object>());
	}

}
