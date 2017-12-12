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
                <div class="col-md-6"><img src="#" alt="image"/>
                </div>
                <div class="col-md-6">
                    <h3 ${product.productName}></h3>
                    <p ${product.productDescription}></p>
                    <p>
                        <strong>Manufacturer</strong> : ${product.productManufacturer}
                    </p>
                    <p>
                        <strong>Category</strong> : ${product.productCategory}
                    </p>
                    <p>
                        <strong>Condition</strong> : ${product.productCondition}
                    </p>
                    <h4>${product.productPrice} USD</h4>

                    <br>
                </div>
            </div>
        </div>

        <%@include file="/WEB-INF/views/template/footer.jsp" %>
