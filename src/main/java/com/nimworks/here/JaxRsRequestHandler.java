package com.nimworks.here;

import java.util.Map;
import java.util.Map.Entry;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;

public class JaxRsRequestHandler implements RequestHandler {
	
	private Client client;
	
	public JaxRsRequestHandler() {
		client = ClientBuilder.newClient();
	}

	@Override
	public <T> T handleGet(String url, Class<T> responseType, Map<String, Object> headers) {
		
		MultivaluedMap<String, Object> headerMap = new MultivaluedHashMap<String, Object>();
		for (Entry<String, Object> header : headers.entrySet()) {
			headerMap.add(header.getKey(), header.getValue());
		}
		
		T response = client.target(url)
				.request()
				.headers(headerMap)
				.accept(MediaType.APPLICATION_JSON)
				.get(responseType);
		return response;
	}

}
