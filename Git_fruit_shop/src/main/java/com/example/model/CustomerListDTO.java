package com.example.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by jt on 9/27/17.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerListDTO {
    public CustomerListDTO(List<CustomerDTO> allCustomers) {
		// TODO Auto-generated constructor stub
	}

	List<CustomerDTO> customers;
}

