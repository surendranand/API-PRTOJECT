package com.omrbranch.stepdefinition;

public class GlobalData {
	

		private  int statusCode ;
		private  String logtoken;
		private String stateid;
		private int stateidtext;
		private String cityname;
		private int cityid;
	    private String Stringaddress;
		 
		public String getStringaddress() {
			return Stringaddress;
		}
		public void setStringaddress(String stringaddress) {
			Stringaddress = stringaddress;
		}
		public int getCityid() {
			return cityid;
		}
		public void setCityid(int cityid) {
			this.cityid = cityid;
		}
		public String getCityname() {
			return cityname;
		}
		public void setCityname(String cityname) {
			this.cityname = cityname;
		}
		public String getStateid() {
			return stateid;
		}
		public void setStateid(String stateid) {
			this.stateid = stateid;
		}
		public int getStateidtext() {
			return stateidtext;
		}
		public void setStateidtext(int stateidtext) {
			this.stateidtext = stateidtext;
		}
		
		public  int getStatusCode() {
			return statusCode;
		}
		public void setStatusCode(int statusCode) {
			this.statusCode = statusCode;
		}
		public  String getLogtoken() {
			return logtoken;
		}
		public  void setLogtoken(String logtoken) {
			this.logtoken = logtoken;
		}
		

	}


