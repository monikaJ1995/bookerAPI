package com.gorest.tests;

import java.io.IOException;
import java.text.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.gorest.base.BaseClass;
import com.gorest.utility.Utility;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import ro.skyah.comparator.JSONCompare;

public class PostTests extends BaseClass{
	  String token;
	  String endpoint;
	  Object actualid;
	  Object actualname;
	  Object actualemail;
	  Object actualgender;
	  Object actualstatus;
	  String path1;
	  String path2;
	  JsonNode requestbody1;
	  JsonNode requestbody2;
	  Response response ;
	  Object expectedname ;
	  Object expectedemail ;
	  Object expectedgender ;
	  Object expectedstatus;
	  
	  @BeforeClass
	  public void TestConfig() throws IOException, ParseException, org.json.simple.parser.ParseException {
	      token=Utility.getData("Token");
	      endpoint=Utility.getData("EndPoint");
	      path1=Utility.getData("path1");
	      path2=Utility.getData("path2");
	      requestbody1=Utility.jsonFile(path1);
	      requestbody2=Utility.jsonFile(path2);
	      expectedname = Utility.getJsonFileAttributes(path1, "name");
	      expectedemail =Utility.getJsonFileAttributes(path1, "email");
	      expectedgender =Utility.getJsonFileAttributes(path1, "gender");
	      expectedstatus =Utility.getJsonFileAttributes(path1, "status");
	      
	  }
	  
	  
	  @BeforeMethod
	  public void lauchBaseURI() {
	      RestAssured.baseURI="https://gorest.co.in";
	  }

	  
	  @Test(priority =-1)
	    public void validateStatusCodeForPost() throws ParseException, org.json.simple.parser.ParseException {
	  response = postMethod(token, endpoint, requestbody1);
	  JSONCompare.assertEquals(requestbody1.toString(),response.asString());
	  actualid     = Utility.getExctractedData(response, "id");
	  actualname   = Utility.getExctractedData(response, "name");
	  actualemail  = Utility.getExctractedData(response, "email");
	  actualgender = Utility.getExctractedData(response, "gender");
	  actualstatus = Utility.getExctractedData(response, "status");
	  Assert.assertEquals(201,response.getStatusCode());
	  System.out.println(actualid);
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