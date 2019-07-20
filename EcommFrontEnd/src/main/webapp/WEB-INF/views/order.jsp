<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="cr" value="${pageContext.request.contextPath}" />

<style>
.bg-orange {
	background: #d8622b;
	color: #fff !important;
}

body {
	background: #fff;
}

.simg1 {
	width: 100%;
	max-height: 560px;
}

a {
	color: #696969;
}
</style>
<div class="container">

	<c:if test="${empty(orderlist)}">
		<div class="jumbotron">
			<h1>Order List</h1>
			<p>No Items</p>


		</div>
	</c:if>
	<c:if test="${!empty(orderlist)}">
		<c:forEach items="${orderlist}" var="order">


			<div class="col-md-12">
				<div class="row mb-3">
					<div class="col-md-12">
						<div class="thumbnail">
							<div class="thumbnail-body">
								<div class="row">
									<div class="col-md-3">
										<img class="simg1" src="${cr}/resources/pimages/${order.product.productid}.jpg"
											style="width: 172px; height: 172px;">
									</div>
									<div class="col-md-7">
										<h3>${order.orderId}</h3>
										<h4>${order.product.productname}</h4>
										<small>${order.orderDate}</small>
									</div>
									<div class="col-md-2" style="margin-top: 3%">
										<a href="${cr}/user/receipt?myorderId=${order.orderId}"
											class="btn btn-outline bg-orange">View Receipt </a>

									</div>
								</div>

							</div>
						</div>
					</div>
				</div>
			</div>

		</c:forEach>
	</c:if>
</div>