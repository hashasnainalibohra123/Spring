package com.java.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import com.java_blog.Annotation.UniqueUserName;

@Entity
public class User_u {
@Id
@GeneratedValue
private Integer id;
@Size(min=3,message="Name must be atleast 3 charaters")
@Column(unique=true)
@UniqueUserName(message="such user already exists!")
private String name;
@ManyToMany
@JoinTable
private List< Role> roles ;

@OneToMany(mappedBy="user",fetch=FetchType.LAZY,cascade=CascadeType.REMOVE)
private List<Blog> blogs;

public List<Role> getRoles() {
	return roles;
}

public void setRoles(List<Role> roles) {
	this.roles = roles;
}
@Size(min=1,message="Pass must be atleast 3 charaters")
private String pass;
@Size(min=1,message="Email must be atleast 3 charaters")
@org.hibernate.validator.constraints.Email(message="Email must be atleast 3 charaters")
private String Email;
private boolean enabled ;

public boolean isEnabled() {
	return enabled;
}

public void setEnabled(boolean enabled) {
	this.enabled = enabled;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getPass() {
	return pass;
}

public void setPass(String pass) {
	this.pass = pass;
}

public List<Blog> getBlogs() {
	return blogs;
}

public void setBlogs(List<Blog> blogs) {
	this.blogs = blogs;
}

public String getEmail() {
	return Email;
}

public void setEmail(String email) {
	Email = email;
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}
}
