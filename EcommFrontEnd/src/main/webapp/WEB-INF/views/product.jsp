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
		});
	});
</script>
<style>
.login-block {
	float: left;
	width: 100%;
	padding: 50px 0;
}

.mystyle {
	border-radius: 10px;
	width: 40%;
	height: 90%;
}

.login-sec {
	padding: 30px;
	position: relative;
}

.login-sec h2 {
	margin-bottom: 30px;
	font-weight: 800;
	font-size: 30px;
	color: #0069c0;
}

.login-sec h2:after {
	content: " ";
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
<div class="container">
	<c:if test="${haserror}">
		<div class="alert alert-danger alert-dismissable">
			<button type="button" class="close" data-dismiss="alert"
				aria-hidden="true">×</button>
			<strong>${error}</strong>
		</div>
	</c:if>
	<c:if test="${editmode}">
		<c:set var="url" value="${cr}/admin/updatepro"></c:set>

	</c:if>
	<c:if test="${!editmode}">
		<c:set var="url" value="${cr}/admin/addproduct"></c:set>
	</c:if>
	<div class="row ">
		<div class="col login-sec">
			<h2 class="text-center">Product</h2>
			<form:form class="login-form" modelAttribute="productmodel"
				action="${url}" method="Post" enctype="multipart/form-data">
				<c:if test="${editmode}">
					<div class="form-group">
						<label for="exampleInputEmail1" class="text-uppercase">Product
							Id</label>
						<form:input type="text" class="form-control" placeholder=""
							path="productid" name="pid" id="name" readonly="true" />
					</div>
				</c:if>
				<div class="form-group">
					<label for="exampleInputEmail1" class="text-uppercase">Product
						Name</label>
					<form:input type="text" class="form-control" placeholder=""
						path="productname" />
					<form:errors path="productname" cssStyle="color:Red" />
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1" class="text-uppercase">Description</label>

					<form:input type="textarea" class="form-control" placeholder=""
						path="productdescription" />
					<form:errors path="productdescription" cssStyle="color:Red" />
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1" class="text-uppercase">Quantity</label>

					<form:input type="text" class="form-control" placeholder=""
						path="quantity" />
					<form:errors path="quantity" cssStyle="color:Red" />
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1" class="text-uppercase">Price</label>
					<form:input type="text" class="form-control" placeholder=""
						path="price" />
					<form:errors path="price" cssStyle="color:Red" />
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1" class="text-uppercase">Category</label>
					<form:select path="category.categoryid" class="form-control">
						<c:forEach items="${categorylist}" var="c">
							<form:option value="${c.categoryid}">${c.categoryname}</form:option>
						</c:forEach>
					</form:select>
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1" class="text-uppercase">Image</label>
					<form:input type="file" class="form-control" placeholder=""
						path="productimage" />
				</div>
				<div class="form-check">
					<button type="submit" class="btn btn-login float-right">Submit</button>
				</div>
			</form:form>
		</div>
	</div>
	<div class="row custyle">
		<table id="myTable" class="table table-striped custab">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Description</th>
					<th>Quantity</th>
					<th>Price</th>
					<th>Category</th>
					<th>Image</th>
					<th class="text-center">Action</th>
				</tr>
			</thead>
			<c:forEach items="${productlist}" var="c">
				<tr>
					<td>${c.productid}</td>
					<td>${c.productname}</td>
					<td>${c.productdescription}</td>
					<td>${c.quantity}</td>
					<td>${c.price}</td>
					<td>${c.category.categoryname}</td>
					<td><img src="${cr}/resources/pimages/${c.productid}.jpg" height="70px" width="70px" />
					<td class="text-center"><a class='btn btn-info btn-xs'
						href="${cr}/admin/editpro?productname=${c.productname}"><span
							class="glyphicon glyphicon-edit"></span> Edit</a> <a
						href="${cr}/admin/deletepro?productname=${c.productname}"
						class="btn btn-d anger btn-xs"> <span
							class="glyphicon glyphicon-remove"></span> Del
					</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>