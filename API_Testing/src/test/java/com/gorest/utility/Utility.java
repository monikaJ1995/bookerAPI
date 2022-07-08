package com.gorest.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;

public class Utility {
    //To fetch the data from Properties files
public static String getData(String key) throws IOException {
        
        FileInputStream myfile=new FileInputStream("C:\\Users\\ASUS\\WishupWorkspace\\API_Testing\\src\\test\\resources\\TestData.properties");
        Properties p=new Properties();
        p.load(myfile);
        String value = p.getProperty(key);
        return value;
        }
  //To Extract the Attributes from the HTTP Response
public static Object getExctractedData(Response response, Object Key) throws ParseException {
    JSONParser parser = new JSONParser();  
    JSONObject json = (JSONObject) parser.parse(response.asString());
    Object value= json.get(Key);
    return value;
}
  //To Fetch The JSONBODY From JSON FILE
public static JsonNode jsonFile(String path) throws JsonProcessingException, IOException {
        
        ObjectMapper mapper= new ObjectMapper();  
        JsonNode requestbody = mapper.readTree(new File(path));
        return requestbody;
        
        
    }
//To Extract the Attribute from JSONFILE  
public static Object getJsonFileAttributes(String path,String key) throws JsonProcessingException, IOException, ParseException {
    	
	    ObjectMapper mapper= new ObjectMapper(); 
		JsonNode requestbody = mapper.readTree(new File(path));
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(requestbody.toString());
		Object value= json.get(key);
		return value;
		
    }

}


	

