package com.omrbranch.runner;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.omrbranch.base.Baseclass;
import com.omrbranch.report.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(tags ="@login or @state or @city or @address or @search",dryRun=false,plugin = {"json:target\\index.json"},glue="com.omrbranch.stepdefinition",features="src\\test\\resources")
public class TestRunnerClass extends Baseclass {
@AfterClass
	public static void jvmreport() throws FileNotFoundException, IOException {
	Reporting.Jvmreport(getprojectpath()+getpropertyfilevalue("jsonpath"));
	
}
}
