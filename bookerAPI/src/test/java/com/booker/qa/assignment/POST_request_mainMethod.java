package com.booker.qa.assignment;

import org.json.simple.JSONObject;
import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class POST_request_mainMethod {
	public static void main(String[] args) {
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		RequestSpecification httpRequest =RestAssured.given();
		
		JSONObject bookingdates= new JSONObject();
		bookingdates.put("checkin","2022-05-25");
		bookingdates.put("checkout","2022-05-25");
		
		JSONObject payload= new JSONObject();

		payload.put("firstname","Yogitha");
		payload.put("lastname","Gogula");
		payload.put("totalprice",111);
		payload.put("depositpaid",true);
		payload.put("bookingdates",bookingdates);
//		payload.put("bookingdates.checkout","2022-05-25");
		payload.put("additionalneeds","Breakfast");
		
		Response response = httpRequest.header("Content-type","application/json")
		.header("Cookie","token=844d1865bde49ed")
		.body(payload.toString())
		.post("/booking");
		
		System.out.println("Created Record: " +response.asPrettyString());
		System.out.println("Status Code: "+ response.getStatusCode());
		
	}

}
