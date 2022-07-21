package com.booker.qa.assignment;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GET_request_mainMethod {
	public static void main(String[] args) {
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		RequestSpecification httpRequest =RestAssured.given();
		Response response = httpRequest.header("ContentType","application/json")
		.header("Cookie","token=844d1865bde49ed").get("/booking/3000");
		String strResponse = response.asPrettyString();
		
		System.out.println(strResponse);
		System.out.println(response.getStatusCode());
		
		JsonPath js = new JsonPath(strResponse);
		String firstName = js.getString("firstname");
		
		Assert.assertEquals(firstName, "Sanket");
		System.out.println("Guruji: "+firstName);
		
		/*Fetching child node data*/
		
		String checkIn = js.getString("bookingdates.checkin");
		String checkOut = js.getString("bookingdates.checkout");
		
		System.out.println("CheckIn date: " +checkIn + "\n" + "CheckOut date: "+ checkOut);
	}

}
