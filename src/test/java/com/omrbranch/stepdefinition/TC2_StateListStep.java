package com.omrbranch.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.omrbranch.base.Baseclass;
import com.omrbranch.endpoints.EndPoints;
import com.omrbranch.pojo.statelist.Datum;
import com.omrbranch.pojo.statelist.Statelist_output_pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC2_StateListStep extends Baseclass implements EndPoints {
	 public Response response;
	public  String stateid;
	@Given("User add hearders for the statelist")
	public void user_add_hearders_for_the_statelist() {
		List<Header>listheader5= new ArrayList<>();
		Header h1=new Header("accept", "application/json");
		listheader5.add(h1);
		
		 
		 Headers headers3 =new Headers(listheader5);
		 addHeaders(headers3);
	}
	@When("User send {string} request for statelist endpoint")
	public void user_send_request_for_statelist_endpoint(String reqType) {
		 response = addReqType(reqType,EndPoints.STATELIST);
		int statusCode = getStatusCode(response);
		TC1_LoginStep.globaldata.setStatusCode(statusCode);
		
		
	}
	
	@Then("User should verify the statelist response message matches {string} and save state id")
	public void user_should_verify_the_statelist_response_message_matches_and_save_state_id(String excepted) {
		Statelist_output_pojo stateoutput=response.as(Statelist_output_pojo.class);
		ArrayList<Datum> stateList = stateoutput.getData();
		for (Datum datum : stateList) {
			
		
			String statename = datum.getName();
			if (statename.equals(excepted)) {
				String sname = datum.getName();
				 int stateidtext = datum.getId();
		    String stateid = String.valueOf(stateidtext);
		TC1_LoginStep.globaldata.setStateid(stateid);
		TC1_LoginStep.globaldata.setStateidtext(stateidtext);
			Assert.assertEquals("verify State id", excepted,sname);
				
				System.out.println(stateidtext);
				break;
			}
		}
	}



	
}
