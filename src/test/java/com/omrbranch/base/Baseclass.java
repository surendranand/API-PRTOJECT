package com.omrbranch.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Baseclass {
	RequestSpecification reqspec;
	Response response;
	
        public static String getprojectpath() 
        {
 return System.getProperty("user.dir");
		}    
        
        
        
public static String getpropertyfilevalue(String key) throws FileNotFoundException, IOException
	{
Properties property= new Properties();
property.load(new FileInputStream(getprojectpath() +"\\Config\\Config.properties"));
String value = (String)property.getProperty(key);
return value;

	}
	public void addHeader(String key,String value) {
		
reqspec=RestAssured.given().header(key,value);
}
	public void addHeaders(Headers headers) {
	reqspec=RestAssured.given().headers(headers);

	}
	public void addPathParam(String key,String value) {
		reqspec=reqspec.pathParam(key,value);
	}

	public void addQueryParam(String key,String value) {
		reqspec.queryParam(key, value);

	}
	public void addBody(String body) {
reqspec	=reqspec.body(body);

	}
	public void Addbody(Object body) {
reqspec=reqspec.body(body);
	}
	
	public Response addReqType(String reqType,String endPoint) {
		switch (reqType) {
		case "GET":
			response=reqspec.log().all().get(endPoint);
			break;
		case "POST":
			response=reqspec.log().all().post(endPoint);
			break;
		case "PUT":
			response=reqspec.log().all().put(endPoint);
			break;
		case "PATCH":
			response=reqspec.log().all().patch(endPoint);
			break;
		case "DELETE":
			response=reqspec.log().all().delete(endPoint);
			break;

		default:
			break;
		}
	return response;	

	}
	public int getStatusCode(Response addReqType) {
		int statusCode = response.getStatusCode();
		return statusCode;

	}
	public String getresBodyAsString(Response addReqType) {
	String asString = response.asString();
	return asString;

	}
	
	public String getResBodyAsPrettyString(Response addReqType) {
		String asPrettyString = response.asPrettyString();
		return asPrettyString;

	}
	public void AddBasicAuth(String username,String password) {
		reqspec=reqspec.auth().preemptive().basic(username, password);
		
		
		
		
		
		
		
		

	}
	
	
	
	
	
}
