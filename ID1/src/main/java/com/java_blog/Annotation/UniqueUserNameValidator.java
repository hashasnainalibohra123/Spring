package com.java_blog.Annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.java_blog.repository.UserRepository;

public class UniqueUserNameValidator implements ConstraintValidator<UniqueUserName, String>{

	@Autowired 
	UserRepository userRepository;
	public void initialize(UniqueUserName constraintAnnotation) {

	}
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(userRepository==null)
		{
			return true;
		}
		return userRepository.findByName(value)==null;
	}

}
