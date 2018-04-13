package com.jaikant.unittesting.unittesting.spike;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {
	
	String actualResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
	
	@Test
	public void jsonAssert_StrictTrue_ExactMatch_ExceptWhiteSpaces() throws JSONException {
		String expectedResponse = "{\"id\": 1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, false);
	}
	
	@Test
	public void jsonAssert_StrictFalse() throws JSONException {
		String expectedResponse = "{\"id\":1,\"name\":\"Ball\"}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, false);
	}
	
	@Test
	public void jsonAssert_WithoutEscapeCharacters() throws JSONException {
		String expectedResponse = "{id:1,name:Ball}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, false);
	}
	
	@Test
	public void jsonAssert_USeEscapeCharacters_When_String_Has_Space() throws JSONException {
		String actualResponse = "{\"id\":1,\"name\":\"Ball 2\",\"price\":10,\"quantity\":100}";
		
		String expectedResponse = "{id:1,name:\"Ball 2\"}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, false);
	}

}
