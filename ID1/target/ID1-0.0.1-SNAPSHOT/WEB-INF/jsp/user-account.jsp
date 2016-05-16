<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script
	src='//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js'></script>

<jsp:include page="../layout/taglib.jsp"></jsp:include>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Button trigger modal -->
<button type="button" class="btn btn-primary btn-lg" data-toggle="modal"
	data-target="#myModal">New Blog</button>

<form:form commandName="blog" cssClass="form-horizontal blogForm">
	<!-- Modal -->

	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">New blog</h4>
			</div>
			<div class="modal-body">

				<div class="form-group">
					<label for="name" class="col-sm-2 control-label">Name:</label>
					<div class="col-sm-10">
						<form:input path="name" cssClass="form-control" />
						<form:errors path="name" />
					</div>
				</div>
				<div class="form-group">
					<label for="name" class="col-sm-2 control-label">URL:</label>
					<div class="col-sm-10">
						<form:input path="url" cssClass="form-control" />
						<form:errors path="url" />
					</div>
				</div>

			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<input type="submit" class="btn btn-primary" value="Save" />
			</div>
		</div>
	</div>

</form:form>

<script type="text/javascript">

$(document).ready(function()
		{
	$('.nav-tabs a:first').tab('show');
/* 	$('.triggerRemove').click(function(e){
		e.preventDefault();
		$("#modelRemove .removeBtn").attr("href",$(this).Attr("href"));
	}); */
		});
</script>
<div>

	<!-- Nav tabs -->
	<ul class="nav nav-tabs" role="tablist">
		<c:forEach items="${user.blogs}" var="blog">
			<li role="presentation"><a href="#blog_${blog.id}" data-toggle="tab">${blog.name }</a></li>

		</c:forEach>
		
	</ul>

	<!-- Tab panes -->
	<div class="tab-content">
	<c:forEach items="${user.blogs}" var="blog">
		<div role="tabpanel" class="tab-pane active" id="blog_${blog.id}">
		
		<h1>${blog.name }</h1>
	<p>
	
	<a href='<spring:url value="/blog/remove/${blog.id}.html" />' class="btn btn-danger triggerRemove">remove blog</a>
	
	<c:out value="${blog.url}" /></p>


	<table class="table table-bordered table-hover table-striped">

		<thead>
			<tr>
				<th>Title</th>
				<th>Link</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${blog.items}" var="item">
				<tr>
					<td>${item.name}</td>
					<td>${item.link}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
		
		
		</div>
		</c:forEach>
	</div>

</div>
<br />
<br />


<!-- Modal -->
<div class="modal fade" id="modelRemove" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Remove Blog</h4>
      </div>
      <div class="modal-body">
        Really Remove
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
        	<a href="" class="btn btn-danger removeBtn">Remove</a>
      </div>
    </div>
  </div>
</div>

