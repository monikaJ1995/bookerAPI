package com.booker.qa.assignment;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;

public class Test1 {
	public static void main(String[]args)
	{
	System.out.println("******Post Method******");
	RestAssured.baseURI = "https://restful-booker.herokuapp.com";
	String requestbody=" {\r\n"
			+ "    \"firstname\": \"Sheetal\",\r\n"
			+ "    \"lastname\": \"Yadav\",\r\n"
			+ "    \"totalprice\": 1213,\r\n"
			+ "    \"depositpaid\": true,\r\n"
			+ "    \"bookingdates\": {\r\n"
			+ "        \"checkin\": \"2018-12-13\",\r\n"
			+ "        \"checkout\": \"2019-12-13\"\r\n"
			+ "    },\r\n"
			+ "    \"additionalneeds\": \"Breakfast\"\r\n"
			+ "}";

	Response response = given()
			.header("Cookie", "token=8a7c077c62a603c")
			.header("Content-type", "application/json")
			.and()
			.body(requestbody)
			.post("/booking");
	String name=response.asPrettyString(); 
	System.out.println(name);
	System.out.println("Status Code="+response.getStatusCode());
	}
}
