package com.omrbranch.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.omrbranch.base.Baseclass;
import com.omrbranch.endpoints.EndPoints;
import com.omrbranch.payloadaddress.AddressPayload;
import com.omrbranch.pojo.citylist.Citylist_input_pojo;
import com.omrbranch.pojo.citylist.Citylist_output_pojo;
import com.omrbranch.pojo.citylist.Datum;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC3_CityListStep extends Baseclass implements EndPoints{
	public Response response;
	AddressPayload citypayload =new AddressPayload();
	@Given("User add hearders for the city list")
	public void user_add_hearders_for_the_city_list() {

		List<Header>listheader3= new ArrayList<>();
		Header h1=new Header("accept", "application/json");
		
		Header h3=new Header("Content-Type", "application/json");
		 listheader3.add(h1);
		
		 listheader3.add(h3);
		 
		 Headers headers3 =new Headers(listheader3);
		 addHeaders(headers3);
	}


	@When("User add request body for add an object")
	public void user_add_request_body_for_add_an_object() {
		Citylist_input_pojo citylist2 = citypayload.citylist(TC1_LoginStep.globaldata.getStateid());
	Addbody(citylist2);
	}

	
	@When("User send {string} request for citylist endpoint")
	public void user_send_request_for_citylist_endpoint(String reqType) {
       response = addReqType(reqType,EndPoints.CITYLIST);
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
	
	TC1_LoginStep.globaldata.setStatusCode(statusCode);
	}
	
	


	
	@Then("User should verify the citylist response and message matches {string} and saved cityid")
	public void user_should_verify_the_citylist_response_and_message_matches_and_saved_cityid(String excepted) {
	Citylist_output_pojo cityout = response.as(Citylist_output_pojo.class);
		ArrayList<Datum>citynamelist= cityout.getData();
		for (Datum datum : citynamelist) {
			
		
		String cityname = datum.getName();
		
			if (datum.equals(excepted)) {
			 int cityid = datum.getId();
			 TC1_LoginStep.globaldata.setCityname(cityname);
			 
			 TC1_LoginStep.globaldata.setCityid(cityid);
		Assert.assertEquals("verify state", excepted,TC1_LoginStep.globaldata.getCityname());
		
			break;
			
			}
	}

	}
}


