<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1"/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="navbar.jsp" />
	<div style="min-height: 475px;">
		<c:if test="${sliderpage}">
		<jsp:include page="carousel.jsp"></jsp:include> 
		</c:if>
		<c:if test="${aboutuspage}">
			<jsp:include page="abtus.jsp"></jsp:include>
		</c:if>
		<c:if test="${contactuspage}">
			<jsp:include page="contactus.jsp"></jsp:include>
		</c:if>
		<c:if test="${registerpage}">
			<jsp:include page="signup.jsp"></jsp:include>
		</c:if>
		<c:if test="${loginpage}">
			<jsp:include page="login.jsp"></jsp:include>
		</c:if>
		<c:if test="${categorypage}">
			<jsp:include page="category.jsp"></jsp:include>
		</c:if>
		<c:if test="${productpage}">
			<jsp:include page="product.jsp"></jsp:include>
		</c:if>
		<c:if test="${viewallproducts}">
			<jsp:include page="viewallproduct.jsp"></jsp:include>
		</c:if>
		<c:if test="${viewoneproduct}">
			<jsp:include page="viewoneproduct.jsp"></jsp:include>
		</c:if>
		<c:if test="${cartpage}">
			<jsp:include page="cart.jsp"></jsp:include>
		</c:if>
		<c:if test="${addresspage}">
			<jsp:include page="address.jsp"></jsp:include>
		</c:if>
		<c:if test="${orderpage}">
		 	<jsp:include page="order.jsp"/>
		</c:if>
		<c:if test="${receiptpage}">
			<jsp:include page="receipt.jsp"/>
		</c:if>
	</div>
<jsp:include page="footer.jsp" />
</body>
</html>