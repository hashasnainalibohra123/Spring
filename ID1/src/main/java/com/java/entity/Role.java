package com.java.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Role {
	@Id
	@GeneratedValue
	private Integer id;
	@ManyToMany(mappedBy="roles")
private List< User_u> User_us;
	public List<User_u> getUser_us() {
		return User_us;
	}

	public void setUser_us(List<User_u> User_us) {
		this.User_us= User_us;
	}

	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
