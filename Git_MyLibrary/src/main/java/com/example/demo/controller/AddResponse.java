package com.example.demo.controller;

import org.springframework.stereotype.Component;

@Component
public class AddResponse {

	private String Msg;
	public String getMsg() {
		return Msg;
	}
	public void setMsg(String msg) {
		Msg = msg;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	private String Id;
}
