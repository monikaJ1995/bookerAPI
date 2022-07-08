package com.gorest.tests;

import java.io.IOException;
import java.text.ParseException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.gorest.base.BaseClass;
import com.gorest.utility.Utility;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class PutTests extends BaseClass {
	  String token;
	  String endpoint;
	  Object actualid;
	  Object actualname;
	  Object actualemail;
	  Object actualgender;
	  Object actualstatus;
	  String path2;
	  JsonNode requestbody1;
	  JsonNode requestbody2;
	  Object expectedname ;
	  Object expectedemail ;
	  Object expectedgender ;
	  Object expectedstatus;
	  Object expectedid;

	  @BeforeClass
	  public void TestConfig() throws IOException, ParseException, org.json.simple.parser.ParseException {
	      token=Utility.getData("Token");
	      endpoint=Utility.getData("EndPoint");
	      path2=Utility.getData("path2");
	      requestbody1=Utility.jsonFile(path2); 
	      expectedid = Utility.getJsonFileAttributes(path2, "id");
	      expectedname = Utility.getJsonFileAttributes(path2, "name");
	      expectedemail =Utility.getJsonFileAttributes(path2, "email");
	      expectedgender =Utility.getJsonFileAttributes(path2, "gender");
	      expectedstatus =Utility.getJsonFileAttributes(path2, "status");
	      
	  }
	  @BeforeMethod
	  public void lauchBaseURI() {
	      RestAssured.baseURI="https://gorest.co.in";
	  }
	
@Test(priority = -1)
public void statusCodeValidationForPut() throws ParseException, org.json.simple.parser.ParseException
{
	Response response = putMethod(token, endpoint,"3786",requestbody1);
	  actualid     = Utility.getExctractedData(response, "id");
	  actualname   = Utility.getExctractedData(response, "name");
	  actualemail  = Utility.getExctractedData(response, "email");
	  actualgender = Utility.getExctractedData(response, "gender");
	  actualstatus = Utility.getExctractedData(response, "status");
	  
	  Assert.assertEquals(200, response.getStatusCode());
}
@Test
public void validateName() throws ParseException, JsonProcessingException, IOException
{
	
Assert.assertEquals(actualname, expectedname);
}
@Test
public void validateEmail() throws ParseException, JsonProcessingException, IOException
{
	
Assert.assertEquals(actualemail, expectedemail);
}
@Test
public void validateGender() throws ParseException, JsonProcessingException, IOException
{
	
Assert.assertEquals(actualgender, expectedgender);
}
@Test
public void validateStatus() throws ParseException, JsonProcessingException, IOException
{
	
Assert.assertEquals(actualstatus, expectedstatus);
}

}

