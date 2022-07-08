package com.gorest.tests;

import java.io.IOException;
import java.text.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.gorest.base.BaseClass;
import com.gorest.utility.Utility;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetTests extends BaseClass {
	  String token;
	  String URI;
	  String InvalidURI;
	  String invalidtoken;
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
  public void TestConfig() throws IOException, ParseException, org.json.simple.parser.ParseException {
	      
		  token=Utility.getData("Token");
		  URI=Utility.getData("URI");
		  InvalidURI=Utility.getData("InvalideURI");
		  invalidtoken=Utility.getData("invalidtoken");
	      endpoint=Utility.getData("EndPoint");
	      path3=Utility.getData("path3");
	      requestbody1=Utility.jsonFile(path3); 
	      expectedid = Utility.getJsonFileAttributes(path3, "id");
	      expectedname = Utility.getJsonFileAttributes(path3, "name");
	      expectedemail =Utility.getJsonFileAttributes(path3, "email");
	      expectedgender =Utility.getJsonFileAttributes(path3, "gender");
	      expectedstatus =Utility.getJsonFileAttributes(path3, "status");
	      
	  }
	
@Test(priority = -1)
 public void validateStatusCode() throws ParseException, org.json.simple.parser.ParseException
{    RestAssured.baseURI=URI;
Response response =getMethod(token,endpoint,"20");
	  actualid     = Utility.getExctractedData(response, "id");
	  actualname   = Utility.getExctractedData(response, "name");
	  actualemail  = Utility.getExctractedData(response, "email");
	  actualgender = Utility.getExctractedData(response, "gender");
	  actualstatus = Utility.getExctractedData(response, "status");
	  Assert.assertEquals(200, response.getStatusCode());
	  
}

@Test
 public void validateId() throws ParseException, JsonProcessingException, IOException
{	
 Assert.assertEquals(actualid, expectedid);
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
@Test
 void validateInvalideToken() {
	 RestAssured.baseURI=URI;
	Response response =getMethod(invalidtoken,endpoint,"20");
	  Assert.assertEquals(200, response.getStatusCode());
	  //No need of token if we are using publi api for get method
}

@Test
 void validateInvalideURL() {
	 RestAssured.baseURI=URI;
	 Response response =getMethod(token,"/public/v2/user","20");
	  Assert.assertEquals(404, response.getStatusCode());
	  
}


}