package tests;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import static io.restassured.RestAssured.baseURI;
import static org.hamcrest.Matchers.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

public class SOAPxmlRequest {
	
	@Test
	public void validateXML () throws IOException {
		
	File file = new File("./SoapRequest/Add.xml");
	
	if (file.exists()) {
		  System.out.println("OK");
		} else {
			System.out.println("Fail");
		};
	
	FileInputStream fileInputStream = new FileInputStream(file);
	String requestBody = IOUtils.toString(fileInputStream, "UTF-8");
	baseURI = "http://www.dneonline.com/";
	given()
		.contentType("text/xml").accept(ContentType.XML)
	.body(requestBody)
	.when()
	.post("/calculator.asmx")
	.then().statusCode(200).log().all()
	.and()
	.body("//*:AddResult.text()",equalTo("5"));
		
		
		
		
	}
	

}
