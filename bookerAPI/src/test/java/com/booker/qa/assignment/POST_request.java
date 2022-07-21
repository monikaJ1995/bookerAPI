package com.booker.qa.assignment;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.booker.qa.testData.JSON_Payload;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class POST_request {
	Response response;
	JsonPath js;
	@BeforeClass
	public void testConfig()
	{
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		RequestSpecification httpRequest =RestAssured.given();
		JSONObject payload = JSON_Payload.requestPayload();
		response = httpRequest.header("Content-type","application/json")
				.header("Cookie","token=844d1865bde49ed")
				.body(payload.toString())
				.post("/booking");
		System.out.println(response.asPrettyString());
		//String strResp = response.asPrettyString();
		js = new JsonPath(response.asPrettyString());
		//System.out.println("js: " + js.getString("booking.firstname"));
	}
	
	@Test
	public void validateStatusCode()
	{
		Assert.assertEquals(response.getStatusCode(),200);
	}
	
	@Test
	public void validateName()
	{
		Assert.assertEquals(js.getString("booking.firstname"), "Yogitha1");
		Assert.assertEquals(js.getString("booking.lastname"), "Gogula1");
	}
	
	@Test
	public void validateTotalPrice()
	{
		Assert.assertEquals(js.getString("booking.totalprice"), "111");
		Assert.assertEquals(js.getString("booking.depositpaid"), "true");
	}
	
	@Test
	public void validateBookingDates()
	{
		Assert.assertEquals(js.getString("booking.bookingdates.checkin"), "2022-05-25");
		Assert.assertEquals(js.getString("booking.bookingdates.checkout"), "2022-05-25");
	}
	
	@Test
	public void validateAdditionalNeeds()
	{
		Assert.assertEquals(js.getString("booking.additionalneeds"), "Breakfast");
	}
	
	

}
