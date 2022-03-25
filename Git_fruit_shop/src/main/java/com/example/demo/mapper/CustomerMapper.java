package com.example.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.demo.domain.Customer;
import com.example.model.CustomerDTO;

@Mapper
public interface CustomerMapper {

	 CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

	    CustomerDTO customerToCustomerDTO(Customer customer);
}
