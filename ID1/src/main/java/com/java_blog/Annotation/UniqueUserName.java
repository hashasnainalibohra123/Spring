package com.java_blog.Annotation;


import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Target({ FIELD })
//@Target({  FIELD })
@Retention(RUNTIME)

@Constraint(validatedBy = {UniqueUserNameValidator.class })
public @interface UniqueUserName {
	String message() ;

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };


}
