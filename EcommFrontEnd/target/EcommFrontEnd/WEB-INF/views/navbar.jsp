<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cr" value="${pageContext.request.contextPath }" />
<style>
.navbar {
	font-style: bold;
	background: linear-gradient(to left, #66ffcc 0%, #ffffcc 90%);
	height: 70px;
}

.navbar-nav>li>a {
	color: #000099;
	font-size: 20;
	padding-top: 30;
	font-family: comic sans ms;
}

.navbar-brand {
	margin-top: -20%
}
</style>
<nav class="navbar navbar">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="${cr}/home"><img
				src="${cr}/resources/images/CC.PNG" alt="CANINE CORNER" height=70px
				width=70px;></a>
			<button type="button" class="navbar-toggle collapsed  "
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false"></button>
		</div>
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<c:choose>
				<c:when test="${sessionScope.userlogin==true}">
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown"><a href="${cr}/viewallproducts"><span
								class="glyphicon glyphicon-info-sign"></span>ALL PRODUCT</a></li>

						<li class="dropdown"><a href="${cr}/cart"><span
								class="glyphicon glyphicon-user"></span> CART</a></li>
						<li class="dropdown"><a href="${cr}/logout"><span
								class="glyphicon  glyphicon-log-in"></span> LOGOUT</a></li>
					</ul>

				</c:when>
				<c:when test="${sessionScope.adminlogin==true}">
					<ul class="nav navbar-nav">
						<li class="dropdown"><a href="${cr}/admin/viewcategory"><span
								class="glyphicon glyphicon-info-sign"></span> CATEGORY</a></li>
						<li class="dropdown"><a href="${cr}/admin/viewproduct"><span
								class="glyphicon glyphicon-info-sign"></span> PRODUCT</a></li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown"><a href="${cr}/logout"><span
								class="glyphicon  glyphicon-log-in"></span> LOG OUT</a></li>
					</ul>

				</c:when>
				<c:otherwise>
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown"><a href="${cr}/viewallproducts"><span
								class="glyphicon glyphicon-info-sign"></span>ALL PRODUCT</a></li>

						<li class="dropdown"><a href="${cr}/signup"><span
								class="glyphicon glyphicon-user"></span> SIGN UP </a></li>
						<li class="dropdown"><a href="${cr}/login"><span
								class="glyphicon  glyphicon-log-in"></span> LOG IN</a></li>
					</ul>
				</c:otherwise>
			</c:choose>


		</div>
	</div>
</nav>