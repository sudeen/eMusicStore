<%--
  Created by IntelliJ IDEA.
  User: s-k-ii-p-s
  Date: 10/19/17
  Time: 9:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>Product Name</th>
        <th>Category</th>
        <th>Condition</th>
        <th>Price</th>
    </tr>
    </thead>
    <tr>
        <td>${product.productName}</td>
        <td>${product.productCatgory}</td>
        <td>${product.productCondition}</td>
        <td>${product.productPrice}</td>
    </tr>
</table>
</body>
</html>
