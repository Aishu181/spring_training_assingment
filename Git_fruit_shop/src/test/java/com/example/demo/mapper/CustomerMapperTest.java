package com.example.demo.mapper;

import org.junit.jupiter.api.Test;

import com.example.demo.domain.Customer;
import com.example.model.CustomerDTO;

import static org.junit.Assert.assertEquals;

public class CustomerMapperTest {

	 public static final String FIRSTNAME = "Jimmy";
	    public static final String LASTNAME = "Fallon";
	    CustomerMapper customerMapper = CustomerMapper.INSTANCE;

	    @Test
	    public void customerToCustomerDTO() throws Exception {
	        //given
	        Customer customer = new Customer();
	        customer.setFirstname(FIRSTNAME);
	        customer.setLastname(LASTNAME);

	        //when
	        CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);

	        //then
	        assertEquals(FIRSTNAME, customerDTO.getFirstname());
	        assertEquals(LASTNAME, customerDTO.getFirstname());

	    }

	}

