<%@include file="/WEB-INF/views/template/header.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Admin Portal</h1>
            <p class="lend">This is Administrator Page</p>
        </div>
        <h3>
            <a href="<c:url value="/admin/productInventory"/>">Product Inventory</a>
        </h3>
        <p>Here you can View, Check and Modify he product Inventory!</p>

        <%@include file="/WEB-INF/views/template/footer.jsp" %>