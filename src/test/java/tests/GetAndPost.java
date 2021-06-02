package tests;

import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class GetAndPost {

	//@Test
	public void testGet() {
		
		baseURI = "https://reqres.in/api";
		given().
		get("users?page=2").
	then().
		statusCode(200).
	body("data[4].first_name", equalTo("George")).
	body("data.first_name", hasItems("George", "Rachel"));
};
	
@Test
public void testPost() {
		
	Map<String, Object> map = new HashMap <String, Object>();
	JSONObject request = new JSONObject();
	request.put("name", "Andrzej");
	request.put("job", "Tester");
	
	System.out.println(request);
	
	baseURI = "https://reqres.in/api";
	given().
	contentType(ContentType.JSON).
	accept(ContentType.JSON).
	body(request.toJSONString()).
	when().
		post("/users").
	then().
		statusCode(201).log().all();
	
	
};
	
}