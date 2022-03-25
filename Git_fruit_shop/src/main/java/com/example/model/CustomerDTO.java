package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

    private String firstname;
    private String lastname;
    private String customerUrl;
	public void setCustomerUrl(String string) {
		// TODO Auto-generated method stub
		
	}
	public Object getFirstname() {
		// TODO Auto-generated method stub
		return null;
	}
}
