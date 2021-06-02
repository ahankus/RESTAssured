package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;


public class LocalAPITests {

	//@Test
		public void viewUsers() {
			
			baseURI = "http://localhost:3000/";
			given().
			get("/users").
		then().
			statusCode(200).log().all();
		
	};
	
	//@Test
	public void addUser() {
		
		JSONObject request = new JSONObject();
		request.put("fistName", "Andrzej");
		request.put("lastName", "Hankus");
		request.put("subjectId", 1);
		
		
		baseURI = "http://localhost:3000/";
		given().contentType(ContentType.JSON).
			accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		post("/users").
		then().
			statusCode(201).log().all();
};

	//@Test
	public void updateUser() {
	
	JSONObject request = new JSONObject();
	request.put("fistName", "Test");
	request.put("lastName", "Automation");
	request.put("subjectId", 1);
	
	
	baseURI = "http://localhost:3000/";
	given().contentType(ContentType.JSON).
		accept(ContentType.JSON).
	body(request.toJSONString()).
	when().
	put("/users/3").
	then().
		statusCode(200).log().all();
};

	//@Test
	public void updateFrstName() {

	JSONObject request = new JSONObject();
	request.put("firstName", "Miszcz");

	baseURI = "http://localhost:3000/";
	given().contentType(ContentType.JSON).
		accept(ContentType.JSON).
	body(request.toJSONString()).
	when().
	patch("/users/5").
	then().
		statusCode(200).log().all();


}
	@Test
	public void deleteUser() {

	baseURI = "http://localhost:3000/";
	when().
	delete("/users/5").
	then().
		statusCode(200).log().all();

};

}
