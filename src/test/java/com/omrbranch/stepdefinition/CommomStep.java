package com.omrbranch.stepdefinition;

import io.cucumber.java.en.Then;
import org.junit.Assert;

public class CommomStep {
	
		@Then("User verify status code is {int}")
		public void user_verify_status_code_is(int expected) {
		//System.out.println(TC1_LoginStep.globaldata.getStatusCode());
			Assert.assertEquals("verify status code", expected,TC1_LoginStep.globaldata.getStatusCode());
		
}
}
