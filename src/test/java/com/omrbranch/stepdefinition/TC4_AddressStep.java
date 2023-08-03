package com.omrbranch.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.omrbranch.base.Baseclass;
import com.omrbranch.endpoints.EndPoints;
import com.omrbranch.pojo.address.AddAddress_Output_pojo;
import com.omrbranch.pojo.address.AddAddress_input_pojo;
import com.omrbranch.pojo.address.DeleteAddress_Input_pojo;
import com.omrbranch.pojo.address.GetAllAddress_output_pojo;
import com.omrbranch.pojo.address.UpdateAddress_Input_pojo;
import com.omrbranch.pojo.address.UpdateAdress_output_pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC4_AddressStep extends Baseclass implements EndPoints  {

	
	public Response response;

	
	@Given("User add header and bearer authorization for accessing address endpoint")
	public void user_add_header_and_bearer_authorization_for_accessing_address_endpoint() {
		List<Header> listheader= new ArrayList<>();
		Header h1=new Header("accept", "application/json");
		Header h2=new Header("Authorization", "Bearer " + TC1_LoginStep.globaldata.getLogtoken());
		Header h3=new Header("Content-Type", "application/json");
		 listheader.add(h1);
		 listheader.add(h2);
		 listheader.add(h3);
		 Headers headers =new Headers(listheader);
		 addHeaders(headers);
		
		
	}
	@When("User add resquest body for add new address {string},{string},{string},{string},{int}, {int}, {int},{string},{string} and {string}")
	public void user_add_resquest_body_for_add_new_address_and(String first_name, String last_name, String mobile, String apartment, Integer state, Integer city, Integer country, String zipcode, String address, String address_type) {
		  AddAddress_input_pojo addaddress= new AddAddress_input_pojo(first_name, last_name, mobile, apartment, state, city, country, zipcode, address, address_type);
		  Addbody(addaddress);
		  System.out.println(first_name);
	}
	@When("User send {string} request for add user address endpoint")
	public void user_send_request_for_add_user_address_endpoint(String reqType) {
		  response = addReqType("POST",EndPoints.ADDADDRESS);
			 int statusCode = response.getStatusCode();
			 TC1_LoginStep.globaldata.setStatusCode(statusCode);
			 System.out.println(statusCode);

	}
	@Then("User should  verify the address response message matches {string} and save Address id")
	public void user_should_verify_the_address_response_message_matches_and_save_address_id(String expected) {
	  

		 AddAddress_Output_pojo addaddress = response.as(AddAddress_Output_pojo.class);
			 String message = addaddress.getMessage();
			 int addressid = addaddress.getAddress_id();
			 System.out.println(addressid);
			  String Stringaddress = String.valueOf(addressid);
			  TC1_LoginStep.globaldata.setStringaddress(Stringaddress);
			  Assert.assertEquals("verifymsg", expected,message);
	}

	
	@When("User add resquest body for update add address {string},{string},{string},{string},{string},{int}, {int}, {int},{string},{string} and {string}")
	public void user_add_resquest_body_for_update_add_address_and(String address_id, String first_name, String last_name, String mobile, String apartment, Integer state, Integer city, Integer country, String zipcode, String address, String address_type) {
	UpdateAddress_Input_pojo update=new UpdateAddress_Input_pojo(TC1_LoginStep.globaldata.getStringaddress(), first_name, last_name, mobile, apartment, state, city, country, zipcode, address, address_type);
	Addbody(update);
	}
	@When("User send {string} request for  update  user address endpoint")
	public void user_send_request_for_update_user_address_endpoint(String reqType) {
		 response = addReqType("PUT",TC1_LoginStep.UPDATEADDRESS);
		 int statusCode = getStatusCode(response);
		 System.out.println(statusCode);
		 TC1_LoginStep.globaldata.setStatusCode(statusCode);
	}
	@Then("User should verify the address response message matches {string}")
	public void user_should_verify_the_address_response_message_matches(String expected) {
		UpdateAdress_output_pojo updateadress = response.as(UpdateAdress_output_pojo.class);
		String message1 = updateadress.getMessage();
		 Assert.assertEquals("Address updated successfully",expected,message1);
	}
	
	

	@When("User send {string} request for getAllAddress endpoint")
	public void user_send_request_for_get_all_address_endpoint(String string) {
		  response = addReqType("GET","https://omrbranch.com/api/getUserAddress");
		 int statusCode = getStatusCode(response);
		 System.out.println(statusCode);
		 TC1_LoginStep.globaldata.setStatusCode(statusCode);

	}
	@Then("User should verify the getAllAddress response messagematches{string}")
	public void user_should_verify_the_get_all_address_response_message_matches(String expected) {
		GetAllAddress_output_pojo getalladress_output_pojo = response.as(GetAllAddress_output_pojo.class);
		String message1 = getalladress_output_pojo.getMessage();
		 Assert.assertEquals("Address updated successfully",expected,message1);
	}



	
	@When("User add resquest body for delete address  {string}")
	public void user_add_resquest_body_for_delete_address(String string) {
	DeleteAddress_Input_pojo deleteaddress =new DeleteAddress_Input_pojo(TC1_LoginStep.globaldata.getStringaddress());
	Addbody(deleteaddress);
	}
	@When("User send {string} request for delete paricular user address endpoint")
	public void user_send_request_for_delete_paricular_user_address_endpoint(String reqType) {
		response = addReqType(reqType,EndPoints.DELETEADDRESS);
		 int statusCode = getStatusCode(response);
		 System.out.println(statusCode); 
		 TC1_LoginStep.globaldata.setStatusCode(statusCode);
	}
	






























}