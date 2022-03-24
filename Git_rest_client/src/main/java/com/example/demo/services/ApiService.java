package com.example.demo.services;

import java.util.List;

import com.example.demo.model.User;

public interface ApiService {

	List<User> getUsers(Integer limit);
}
