package com.omrbranch.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.omrbranch.base.Baseclass;
import com.omrbranch.endpoints.EndPoints;
import com.omrbranch.pojo.searchproduct.SearchProduct_Output_pojo;
import com.omrbranch.pojo.searchproduct.Searchproduct_input_pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC5_SearchProductStep extends Baseclass{
	
	public Response response;

	@Given("User add hearders for the search product list")
	public void user_add_hearders_for_the_search_product_list() {
		List<Header>listheader3= new ArrayList<>();
		Header h1=new Header("accept", "application/json");
		Header h2=new Header("Content-Type", "application/json");
		 listheader3.add(h1);
		 listheader3.add(h2);
		 Headers headers3 =new Headers(listheader3);
		 addHeaders(headers3);
	}
	@When("user add request body for search product {string}")
	public void user_add_request_body_for_search_product(String text) {
	   Searchproduct_input_pojo search= new Searchproduct_input_pojo(text);
	   Addbody(search);
	}
	@When("User send {string} request for search product endpoint")
	public void user_send_request_for_search_product_endpoint(String reqType) {
		 response = addReqType(reqType,EndPoints.SEARCHPRODUCT);
		 int statusCode = getStatusCode(response);
		 System.out.println(statusCode);
		 TC1_LoginStep.globaldata.setStatusCode(statusCode);
	}
	@Then("User should verify the search product response and message {string}")
	public void user_should_verify_the_search_product_response_and_message(String expected) {
	SearchProduct_Output_pojo searchout=response.as(SearchProduct_Output_pojo.class);
	String message = searchout.getMessage();
	Assert.assertEquals("verifymsg", expected,message);
	
	
	}






}
