package com.java.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;
@Entity
public class Blog {
	@Id
	@GeneratedValue
	private Integer id;
	@Size(min=3,message="Name must be atleast 3 charaters")
	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@URL
	private String url;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User_u user;
	@OneToMany(mappedBy="blog",cascade=CascadeType.REMOVE)
	private List<Item> items;


	public User_u getUser() {
		return user;
	}
	
	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public void setUser(User_u user) {
		this.user = user;
	}

	public List<Item> getItem() {
		return items;
	}
	public void setItem(List<Item> item) {
		this.items = item;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
