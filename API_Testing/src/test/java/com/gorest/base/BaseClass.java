package com.gorest.base;

import static io.restassured.RestAssured.given;
import com.fasterxml.jackson.databind.JsonNode;
import io.restassured.response.Response;

public class BaseClass {
//Get Method (returns the response and need 3 parameters )	
	
public Response getMethod(String token,String endpoint,Object id) {
	Response response = given()
			  .header("Authorization", token)
			  .header("Content-type", "application/json")
	          .and()
			  .get(endpoint+"/"+id);
	
	return response;
}

//Post Method (returns the response and need 3 parameters)

public Response postMethod(String token,String endpoint,JsonNode requestbody) {
	Response response = given()
			  .header("Authorization", token)
			  .header("Content-type", "application/json")
	          .and()
		      .body(requestbody)
			  .post(endpoint);
	
	return response;
}
//Post Method (returns response and need 4 parameters)

public Response putMethod(String token,String endpoint, Object id,JsonNode requestbody) {
	Response response = given()
			  .header("Authorization", token)
			  .header("Content-type", "application/json")
	          .and()
		      .body(requestbody)
			  .put(endpoint+"/"+id);
	return response;
}

//Delete Method (returns response add need 4 )
public Response deleteMethod(String token,String endpoint,Object id) {
	Response response = given()
			  .header("Authorization", token)
			  .header("Content-type", "application/json")
	          .delete(endpoint+"/"+id);
    return response;
}



}
