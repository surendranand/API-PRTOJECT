package com.omrbranch.payloadaddress;

import com.omrbranch.pojo.address.AddAddress_input_pojo;
import com.omrbranch.pojo.address.DeleteAddress_Input_pojo;
import com.omrbranch.pojo.address.UpdateAddress_Input_pojo;
import com.omrbranch.pojo.citylist.Citylist_input_pojo;

public class AddressPayload {
	
public AddAddress_input_pojo AddAddress_input_pojo(String first_name, String last_name, String mobile, String apartment, int state,
		int city, int country, String zipcode, String address, String address_type) {
	AddAddress_input_pojo Addaddress = new AddAddress_input_pojo(first_name, last_name, mobile, apartment, state, city, country, zipcode, address, address_type);
	return Addaddress;
	
}

public UpdateAddress_Input_pojo UpdateAddress_Input_pojo(String address_id, String first_name, String last_name, String mobile,
		String apartment, int state, int city, int country, String zipcode, String address, String address_type) {
	
UpdateAddress_Input_pojo updateaddress =new UpdateAddress_Input_pojo(address_id, first_name, last_name, mobile, apartment, state, city, country, zipcode, address, address_type);
return updateaddress;
}

public DeleteAddress_Input_pojo DeleteAddress(String address_id ) {
	DeleteAddress_Input_pojo deleteAddress= new DeleteAddress_Input_pojo(address_id);
	return deleteAddress;
}
public Citylist_input_pojo citylist(String state_id) {
Citylist_input_pojo cityinput= new Citylist_input_pojo(state_id);
return cityinput;
}
}
 