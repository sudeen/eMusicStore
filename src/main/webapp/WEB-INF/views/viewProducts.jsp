<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Product Detail</h1>
            <p class="lead">Detail information of the product</p>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <img src="#" alt="image" style="width: 100%; height: 300px"/>
                </div>
                <div class="col-md-6">
                    <c:forEach items="${product}" var="product">

                        <h3>${product.ProductName}</h3>
                        <p></p>
                        <p>
                            <strong>Manufacturer</strong> : ${product.ProductManufacturer}
                        </p>
                        <p>
                            <strong>Category</strong> : ${product.ProductCategory}
                        </p>
                        <p>
                            <strong>Condition</strong> : ${product.ProductCondition}
                        </p>
                        <h4> ${product.ProductPrice} USD</h4>

                        <br>
                    </c:forEach>
                </div>
            </div>
        </div>

        <%@include file="/WEB-INF/views/template/footer.jsp" %>
