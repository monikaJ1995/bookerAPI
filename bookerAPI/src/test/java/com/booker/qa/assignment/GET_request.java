package com.booker.qa.assignment;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GET_request {
	Response response;
	JsonPath js;
	@BeforeClass
	public void testConfig()
	{
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		RequestSpecification httpRequest =RestAssured.given();
		response = httpRequest.header("Content-type","application/json")
		.header("Cookie","token=844d1865bde49ed").get("/booking/3000");
		js = new JsonPath(response.asString());
		
	}
	
	@Test
	public void validateStatusCode()
	{
		Assert.assertEquals(response.getStatusCode(),200);
	}
	
	@Test
	public void validateName()
	{
		Assert.assertEquals(js.getString("firstname"), "Sanket");
		Assert.assertEquals(js.getString("lastname"), "Pidurkar");
	}
	
	@Test
	public void validateTotalPrice()
	{
		Assert.assertEquals(js.getString("totalprice"), "111");
		Assert.assertEquals(js.getString("depositpaid"), "true");
	}
	
	@Test
	public void validateBookingDates()
	{
		Assert.assertEquals(js.getString("bookingdates.checkin"), "2018-01-01");
		Assert.assertEquals(js.getString("bookingdates.checkout"), "2019-01-01");
	}
	
	@Test
	public void validateAdditionalNeeds()
	{
		Assert.assertEquals(js.getString("additionalneeds"), "Breakfast");
	}
	

}
