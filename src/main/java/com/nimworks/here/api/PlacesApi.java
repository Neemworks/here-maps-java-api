package com.nimworks.here.api;

import java.util.Map;

import com.nimworks.here.HereContext;
import com.nimworks.here.model.AutoSuggestionResponse;
import com.nimworks.here.model.PlaceSuggestionResponse;

public class PlacesApi extends HereApi {
	
	public PlacesApi(HereContext ctx) {
		super(ctx, "/places/v1/");
	}
	
	public PlaceSuggestionResponse suggest(String title, String at) {
		
		String baseUrl = getURL("suggest");
		baseUrl += "?at="+ at + "&q=" + title;
		Map<String, Object> headers = getHeaders();
		return ctx.getHandler().handleGet(baseUrl, PlaceSuggestionResponse.class, headers);
	}
	
	public AutoSuggestionResponse autoSuggest(String title, String at) {
		
		String baseUrl = getURL("autosuggest");
		baseUrl += "?at="+ at + "&q=" + title;
		Map<String, Object> headers = getHeaders();
		return ctx.getHandler().handleGet(baseUrl, AutoSuggestionResponse.class, headers);
	}

}
