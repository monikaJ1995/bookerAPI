package com.gorest.tests;

import com.gorest.base.BaseClass;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.JsonNode;
import com.gorest.utility.Utility;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteTests extends BaseClass {

	  String token;
	  String endpoint;
	  Object actualid;
	  Object actualname;
	  Object actualemail;
	  Object actualgender;
	  Object actualstatus;
	  String path3;
	  JsonNode requestbody1;
	  JsonNode requestbody2;
	  Object expectedname ;
	  Object expectedemail ;
	  Object expectedgender ;
	  Object expectedstatus;
	  Object expectedid;

	  
	  
@BeforeClass
public void TestConfig() throws IOException, ParseException {
	 token=Utility.getData("Token");
	 endpoint=Utility.getData("EndPoint");
	       
	  }
	  @BeforeMethod
	  public void lauchBaseURI() {
	      RestAssured.baseURI="https://gorest.co.in";
	  }
	
@Test(priority = -1)
public void statusCodeValidationForGet() throws ParseException
{
	Response response = deleteMethod(token, endpoint, "3786");  
	Assert.assertEquals(204, response.getStatusCode());
}
	
}
