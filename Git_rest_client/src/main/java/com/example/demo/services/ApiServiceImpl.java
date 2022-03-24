package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.model.UserData;
import org.springframework.web.client.RestTemplate;


@Service
public class ApiServiceImpl implements  ApiService {

	@Autowired
	private RestTemplate restTemplate;

//    public ApiServiceImpl(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }
     
    @Override
    public List<User> getUsers(Integer limit) {

       
        UserData userData = restTemplate.getForObject("http://apifaketory.com/api/user?limit=" + limit, UserData.class);
        return userData.getData();
    }
    
    
}
