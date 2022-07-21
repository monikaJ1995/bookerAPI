package com.booker.qa.assignment;

import org.json.simple.JSONObject;

public class CreateJsonPayload_withMainMeth {
	
public static void main(String[] args) {
	
	JSONObject bookingdates= new JSONObject();
	bookingdates.put("checkin","2022-05-25");
	bookingdates.put("checkout","2022-05-25");
	
	JSONObject payload= new JSONObject();

	payload.put("firstname","Yogitha");
	payload.put("lastname","Gogula");
	payload.put("totalprice",111);
	payload.put("depositpaid",true);
	payload.put("bookingdates",bookingdates);
//	payload.put("bookingdates.checkout","2022-05-25");
	payload.put("additionalneeds","Breakfast");
	
	System.out.println(payload.toString());
	
	
}
}
