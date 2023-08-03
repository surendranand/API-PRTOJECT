package com.omrbranch.pojo.citylist;

import java.util.ArrayList;

public class Citylist_output_pojo {
	private int status;
	private String message;
	private ArrayList<Datum> data;
	

	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ArrayList<Datum> getData() {
		return data;
	}
	public void setData(ArrayList<Datum> data) {
		this.data = data;
	}
	
}
