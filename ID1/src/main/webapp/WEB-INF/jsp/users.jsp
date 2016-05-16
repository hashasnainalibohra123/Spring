<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<table class="table table-bordered table-hover table-striped">

	<thead>
		<tr>
			<th>User Name</th>
			<th>Operations</th>
		</tr>
	</thead>

	<tbody>
		<c:forEach items="${users}" var="user">
			<tr>
				<td><a href='<spring:url value="/users/${user.id}.htm"/>'>
					<c:out value="${user.name}"></c:out></a></td>
					<td><a href='<spring:url value="/users/remove/${user.id}.htm"/>' class="btn btn-danger">remove</a>
					</td>
			</tr>
		</c:forEach>
	</tbody>
</table>