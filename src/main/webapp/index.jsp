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

</head>
<body>
<div style="color: red"><h1>Creat Product</h1></div>
<table>
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
    <td><a href="">Edit</a>
      <a href="">Delete</a>
    </td>
  </tr>
  </tbody>
  </c:forEach>
</table>
</body>
</html>
