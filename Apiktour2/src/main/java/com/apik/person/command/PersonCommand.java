package com.apik.person.command;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class PersonCommand {
	@NotEmpty @Email
	private String id; // 회원의 Email
	
	@NotEmpty @Size(min=6, max=12)
	private String passwd;
	
	@NotEmpty
	private String name;
	
	private String gender; // 성별, M,W
	private int age; // 10 ~ 90

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	
}
