package com.omrbranch.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;

import com.omrbranch.base.Baseclass;
import com.omrbranch.endpoints.EndPoints;
import com.omrbranch.pojo.login.Login_output_pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class TC1_LoginStep extends Baseclass implements EndPoints  {
	
	public Response response;

 static GlobalData globaldata=new GlobalData();	

	@Given("User add header")
	public void user_add_header() {
		addHeader("accept","application/json");
	}
	@When("User add basic authentication for login")
	public void user_add_basic_authentication_for_login() throws FileNotFoundException, IOException {
		AddBasicAuth(getpropertyfilevalue("Username"),getpropertyfilevalue("password"));
	}
	@When("User send {string} request for login in endpoint")
	public void user_send_request_for_login_in_endpoint(String reqType) {
		response = addReqType(reqType, EndPoints.POSTMANLOGIN);
	 int statusCode = getStatusCode(response);
	globaldata.setStatusCode(statusCode);
	}
	
	@Then("User verify the login response body FirstName present as {string} and get the logtoken saved")
	public void user_verify_the_login_response_body_first_name_present_as_and_get_the_logtoken_saved(String expected) {
		Login_output_pojo login_Output_pojo = response.as(Login_output_pojo.class);
		String first_name = login_Output_pojo.getData().getFirst_name();
		System.out.println(first_name);
		Assert.assertEquals("verifyfirstname",expected,first_name);
	 String logtoken = login_Output_pojo.getData().getLogtoken();
	 globaldata.setLogtoken(logtoken);
	}



}
