<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<form:form commandName="user" cssClass="form-horizontal registrationForm">
<c:if test=" ${param.success eq true} ">
<div class="alert alert-success">Registration Successfull</div>

</c:if>
<div class="form-group	">
<label for="name" class="col-sm-2 control-label">Name:</label>
 <div class="col-sm-10">
     <form:input path="name" cssClass="form-control" />
     <form:errors path="name"> </form:errors>
    </div>
</div>

<div class="form-group	">
<label for="email" class="col-sm-2 control-label">Email</label>
 <div class="col-sm-10">
     <form:input path="email" cssClass="form-control" />
   <form:errors path="email"> </form:errors>
     </div>
</div>

<div class="form-group	">
<label for="pass" class="col-sm-2 control-label">Password</label>
 <div class="col-sm-10">
     <form:password path="pass" cssClass="form-control" />
   <form:errors path="pass"> </form:errors>
     </div>
</div>
<div class="form-group	">
<label for="pass" class="col-sm-2 control-label">Password Again</label>
 <div class="col-sm-10">
 <input type="password" name="pass_again" id="pass_again" class="form-control"/>
   <form:errors path="pass"> </form:errors>
     </div>
</div>


<div class="form-group	">
 <div class="col-sm-10">
     <input type="submit" value='Save' class="btn btn-lg btm-primary" />
    </div>
</div>

</form:form>
<script type="text/javascript">
$(document).ready(function() {
	
	$(".registrationForm").validate(
		{
			rules: {
				name: {
					required : true,
					minlength : 3,
					/* remote : {
						url: "<spring:url value='/register/available.html' />",
						type: "get",
						data: {
							username: function() {
								return $("#name").val();
							}
						}
					} */
				},
				email: {
					required : true,
					email: true
				},
				password: {
					required : true,
					minlength : 1
				},
				pass_again: {
					required : true,
					minlength : 1,
					equalTo: "#pass"
				}
			},
			highlight: function(element) {
				$(element).closest('.form-group').removeClass('has-success').addClass('has-error');
			},
			unhighlight: function(element) {
				$(element).closest('.form-group').removeClass('has-error').addClass('has-success');
			},
			messages: {
				name: {
					remote: "Such username already exists!"
				}
			}
		}
	);
});</script>