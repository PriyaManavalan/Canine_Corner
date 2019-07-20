<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<style>
*{
    box-sizing: border-box;    
}

.thumbnail
{
min-height: 400px;
}
</style>

<div class="container">
    <div class="row">
        <c:forEach items="${productlist}" var="p">
            <div class="col-sm-4 col-md-4 col-">
                <div class="thumbnail w3-container w3-center w3-animate-bottom">
                    <h4 class="text-center">
                        <span class="label label-info">${p.productname}</span>
                    </h4>
                    <img class="zoom" src="resources/pimages/${p.productid}.jpg" style="max-height: 200%";
                        width="200" />
                    <div class="row">
                        <div class="text-center">
                            <h3>Rs. ${p.price}</h3>
                        </div>
                        <div class="col-xs-12 col-md-4">
                        <a class="btn btn-success" href="viewoneproduct?name=${p.productname}">View</a>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>