<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cr" value="${pageContext.request.contextPath }"/>
<link
	href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css" />
<script
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#myTable').DataTable({
			"pagingType" : "full_numbers",
			"lengthMenu" : [ [ 2, 5, 10, -1 ], [ 2, 5, 10, "All" ] ],
			"ordering" : true,
			"searching" : false,
		})
	});
</script>
<style>
.login-block {
	float: left;
	width: 100%;
	padding: 50px 0;
	
}

.mystyle10 {
border-radius: 10px;
	width: 40%;
}

.login-sec {
	padding: 50px 30px;
	position: relative;
}

.login-sec h2 {
	margin-bottom:30px;
	font-weight:800;
	font-size:30px;
	color:#0069c0;
}

.login-sec h2:after {
	content:" ";
	width: 100px;
	height: 5px;
	background: #6ec6ff;
	display: block;
	margin-top: 20px;
	border-radius: 3px;
	margin-left: auto;
	margin-right: auto
}

.btn-login {
	background: #0069c0;
	color: #fff;
	font-weight: 600;
	margin: 30px;
}

.custab {
	border: 1px solid #ccc;
	padding: 5px;
	margin: 5% 0;
	box-shadow: 3px 3px 2px #ccc;
	transition: 0.5s;
}

.custab:hover {
	box-shadow: 3px 3px 0px transparent;
	transition: 0.5s;
}
</style>
<div class="container mystyle">
	<c:if test="${haserror}">
		<div class="alert alert-danger alert-dismissable">
			<button type="button" class="close" data-dismiss="alert"
				aria-hidden="true">×</button>
			<strong>${error}</strong>
		</div>
	</c:if>
	<c:if test="${editmode}">
		<c:set var="url" value="${cr}/admin/updatecat"></c:set>

	</c:if>
	<c:if test="${!editmode}">
		<c:set var="url" value="${cr}/admin/addcategory"></c:set>
	</c:if>
	<div class="row ">
		<div class="col login-sec">
			<h2 class="text-center">Category</h2>
			<form:form class="login-form" modelAttribute="categorymodel"
				action="${url}" method="Post">
				<c:if test="${editmode}">
					<div class="form-group">
						<label for="exampleInputEmail1" class="text-uppercase">Category
							Id</label>
						<form:input type="text" class="form-control" placeholder=""
							path="categoryid" readonly="true" />
					</div>
				</c:if>
				<div class="form-group">
					<label for="exampleInputEmail1" class="text-uppercase">Category
						Name</label>
					<form:input type="text" class="form-control" placeholder=""
						path="categoryname" />
					<form:errors path="categoryname" cssStyle="color:Red" />
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1" class="text-uppercase">Description</label>

					<form:input type="textarea" class="form-control" placeholder=""
						path="categorydescription" />
					<form:errors path="categorydescription" cssStyle="color:Red" />
				</div>
				<div class="form-check">
					<center>
						<button type="submit" class="btn btn-login
float-right">Submit</button>
						<center>
				</div>
			</form:form>
		</div>
	</div>
	<div class="row">
		<table id="myTable" class="table table-striped custab">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Description</th>
					<th class="text-center">Action</th>
				</tr>
			</thead>
			<c:forEach items="${categorylist}" var="c">
				<tr>
					<td>${c.categoryid}</td>
					<td>${c.categoryname}</td>
					<td>${c.categorydescription}</td>
					<td class="text-center"><a class='btn btn-info btn-xs'
						href="${cr}/admin/editcat?catname=${c.categoryname}"><span
							class="glyphicon glyphicon-edit"></span> Edit</a> <a
						href="${cr}/admin/deletecat?catname=${c.categoryname}"
						class="btn btn-danger btn-xs"><span
							class="glyphicon glyphicon-remove"></span> Del</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>