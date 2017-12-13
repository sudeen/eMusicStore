<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>
<%--<link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">--%>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>All Products</h1>

            <p class="lead">Checkout all the awesome products available now!</p>
        </div>

        <div class="table-responsive">
            <table class="table table-striped table-hover">
                <tr class="bg-success">
                    <th>Photo Thumb</th>
                    <th>Product Name</th>
                    <th>Category</th>
                    <th>Condition</th>
                    <th>Price</th>
                    <th>Description</th>
                    <th>Manufacturer</th>
                    <th>Status</th>
                    <th>UnitStock</th>
                    <th>Operation</th>
                </tr>

                <%--<tbody>--%>
                <c:forEach items="${products}" var="product">
                    <tr>
                        <td><img src="#"/></td>
                        <td>${product.ProductName}</td>
                        <td>${product.ProductCategory}</td>
                        <td>${product.ProductCondition}</td>
                        <td>${product.ProductPrice} USD</td>
                        <td>${product.ProductDescription}</td>
                        <td>${product.ProductManufacturer}</td>
                        <td>${product.ProductStatus}</td>
                        <td>${product.UnitStock}</td>
                        <td><a href="<c:url value="/productList/viewProducts/${product.Id}"/>"><span class="glyphicon glyphicon-info-sign"></span></a></td>
                    </tr>
                </c:forEach>
                <%--</tbody>--%>
            </table>
        </div>

        <%@include file="/WEB-INF/views/template/footer.jsp" %>

    </div>


