package com.booker.qa.testData;

import org.json.simple.JSONObject;

public class JSON_Payload {

	public static JSONObject requestPayload()
	{
		JSONObject bookingdates= new JSONObject();
		bookingdates.put("checkin","2022-05-25");
		bookingdates.put("checkout","2022-05-25");
		
		JSONObject payload= new JSONObject();

		payload.put("firstname","Yogitha1");
		payload.put("lastname","Gogula1");
		payload.put("totalprice",111);
		payload.put("depositpaid",true);
		payload.put("bookingdates",bookingdates);
		payload.put("additionalneeds","Breakfast");
		
		return payload;
	}
}
