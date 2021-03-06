<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Product Inventory Page</h1>
            <p class="lead">This is the Product Inventory Page</p>
        </div>

        <table class="table table-stripped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Photo Thumb</th>
                <th>Category</th>
                <th>Product Name</th>
                <th>Condition</th>
                <th>Price</th>
                <th></th>
            </tr>
            </thead>
            <c:forEach items="${products}" var="product">
                <tr>
                    <td><img src="#" alt="image"/></td>
                    <td>${product.ProductCategory}</td>
                    <td>${product.ProductName}</td>
                    <td>${product.ProductCondition}</td>
                    <td>${product.ProductPrice} USD</td>
                    <td>
                        <a href="<spring:url value="/productList/viewProducts/${product.Id}"/>">
                            <span class="glyphicon glyphicon-info-sign"></span></a>
                        <a href="<spring:url value="/admin/productInventory/deleteProduct/${product.Id}"/>">
                            <span class="glyphicon glyphicon-remove"></span></a>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <a class="btn btn-primary" href="<c:url value="/admin/productInventory/addProduct"/>">Add Product</a>
        <%@include file="/WEB-INF/views/template/footer.jsp" %>
