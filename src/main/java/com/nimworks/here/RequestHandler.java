package com.nimworks.here;

import java.util.Map;

public interface RequestHandler {
	
	<T> T handleGet(String url, Class<T> response, Map<String, Object> headers);

}
