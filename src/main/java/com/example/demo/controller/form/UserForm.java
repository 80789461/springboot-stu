package com.example.demo.controller.form;

import javax.validation.constraints.NotNull;

public class UserForm {
	
	@NotNull(message="1001")
	private String id;
	@NotNull(message="1002")
	private String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
