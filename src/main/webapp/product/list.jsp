<%--
  Created by IntelliJ IDEA.
  User: theanh
  Date: 4/15/2021
  Time: 9:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Management Application</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <style>
        tr{border: black 1px}
        th{ border: black 1px}

    </style>
</head>
<body>
<div class="row"></div>
<div class="col-lg-6" style="color: red"><h5><a href="/product?action=create">Creat Product</a></h5></div>
<form class="d-flex col-sm-4" style="margin-left: auto; margin-top: 10px; margin-bottom: 10px"
      action="product?action=searchMenu" method="post">
    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search"
           name="search">
    <button class="btn btn-outline-success" type="submit"
            style=" background: aliceblue;margin-right: 10px; color: black">Search
    </button>
</form>
<table style="color: black; border: black solid 1px " class="table">
    <tr>
        <th >#</th>
        <th >Product Name</th>
        <th >Price</th>
        <th >Quantity</th>
        <th >Color</th>
        <th >Category</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="product" items="${requestScope['listP']}">
    <tr>
        <th><c:out value="${product.productId}"></c:out></th>
        <td><c:out value="${product.productName}"></c:out></td>
        <td><c:out value="${product.price}"></c:out></td>
        <td><c:out value="${product.quantity}"></c:out></td>
        <td><c:out value="${product.color}"></c:out></td>
        <td><c:out value="${product.typeProduct}"></c:out></td>
        <td><a href="/product?action=edit&productId=${product.productId}">Edit</a>
            <a href="/product?action=delete&productId=${product.productId}">Delete</a>
        </td>
    </tr>
    </tbody>
    </c:forEach>
</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
</body>
</html>
