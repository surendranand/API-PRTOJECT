package com.omrbranch.report;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.omrbranch.base.Baseclass;

import net.masterthought.cucumber.ReportBuilder;

public class Reporting extends Baseclass {
	public static void Jvmreport(String Jsonfile) throws FileNotFoundException,IOException {
	File file=new File(getprojectpath()+getpropertyfilevalue("jvmpath"));
net.masterthought.cucumber.Configuration configuration= new net.masterthought.cucumber.Configuration(file, "OMRBranchGroceryAPIAutomation");
	configuration.addClassifications("BROWSER","CHROME");
	configuration.addClassifications("BROWSERVERSION", "107");
	configuration.addClassifications("os", "WINDOWS11");
	configuration.addClassifications("sprint", "24");
	List<String>Jsonfiles= new ArrayList<String>();
	Jsonfiles.add(Jsonfile);
	ReportBuilder builder =new ReportBuilder(Jsonfiles, configuration);
	builder.generateReports();
	
	}

}
