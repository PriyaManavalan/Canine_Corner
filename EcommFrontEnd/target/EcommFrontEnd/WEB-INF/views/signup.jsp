<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
#login-name {
	font-size: 65px;
	font-family: arabic typesetting;
	border-bottom-style: ridge;
	color: white;
}

#login {
	background-color: rgba(13, 13, 13, 0.2);
	min-height: 500px;
	padding: 40px 80px 40px 80px;
	box-shadow: -10px -10px 9px #33cc33;
}

.user {
	font-size: 29px;
	font-family: arabic typesetting;
	color: white;
}

#iconn {
	background-color: #5cb85c;
	border-color: #4cae4c;
	color: white;
}

#iconn1 {
	background-color: #5cb85c;
	border-color: #4cae4c;
	color: white;
}

#text1 {
	border-radius: 0;
	height: 40px;
}

#text2 {
	border-radius: 0;
	height: 40px;
}

.btn {
	width: 100%;
	float: left;
	height: 40px;
	font-size: 18px;
}
</style>
<div class="container mystyle">
          
	<c:if test="${haserror}">
			<div class="alert alert-danger">
				<strong>${error}</strong>
			</div>
		</c:if>
		<c:if test="${showmess}">
			<div class="alert alert-success">
				<strong>${message}</strong>
			</div>
		</c:if>
		<c:if test="${edit}">
		<c:set var="url" value="updateUser"></c:set>
	</c:if>
	.
	<c:if test="${!edit}">
		<c:set var="url" value="createUser"></c:set>
	</c:if>
	

	<div class="row ">
		<div class="col login-sec">
			<h2 class="text-center">Sign Up</h2>
			<form:form class="login-form" modelAttribute="usermodel"
				action="createUser" method="Post">
<!-- 				<div class="form-group"> -->
<!-- 					<label for="exampleInputEmail1" class="text-uppercase"> -->
<!-- 						Id</label> -->
<%-- 					<form:input type="text" class="form-control" placeholder="" --%>
<%-- 						path="userId" /> --%>
<%-- 					<form:errors path="userId" cssStyle="color:Red" /> --%>
<!-- 				</div> -->
				<div class="form-group">
					<label for="exampleInputEmail1" class="text-uppercase">
						Name</label>
					<form:input type="text" class="form-control" placeholder=""
						path="userName" />
					<form:errors path="userName" cssStyle="color:Red" />
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1" class="text-uppercase">Email
						Id</label>
					<form:input type="email" class="form-control" placeholder=""
						path="useremailId" />
					<form:errors path="useremailId" cssStyle="color:Red" />
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1" class="text-uppercase">Phn
						No</label>
					<form:input type="tel" class="form-control" placeholder=""
						path="userPhno" />
					<form:errors path="userPhno" cssStyle="color:Red" />
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1" class="text-uppercase">Password</label>

					<form:input type="password" class="form-control" placeholder=""
						path="userPassword" />
					<form:errors path="userPassword" cssStyle="color:Red" />
				</div>
				<div class="form-check">
					<center>
						<button type="submit" class="btn btn-login float-right">Submit</button>
						<center>
				</div>
			</form:form>
		</div>
	</div>

</div>