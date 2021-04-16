<%--
  Created by IntelliJ IDEA.
  User: theanh
  Date: 4/15/2021
  Time: 11:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>update the row table information</h1>
<c:if test="${message != null}">
    <p>
            ${message}
    </p>
</c:if>
<form method="post">
    <table>
        <c var="product" items="${requestScope['product']}">
            <tr>
                <td>productName</td>
                <td><input type="text" name="name" value="${product.productName}"></td>
            </tr>
            <tr>
                <td>price</td>
                <td><input type="text" name="price" value="${product.price}"></td>
            </tr>
            <tr>
                <td>quantity</td>
                <td><input type="text" name="quantity" value="${product.quantity}"></td>
            </tr>
            <tr>
                <td>color</td>
                <td><input type="text" name="color" value="${product.color}"></td>
            </tr>
            <tr>
                <td>Category</td>
                <td><input type="text" name="typeID" value="${product.typeID}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update"></td>
            </tr>
        </c>
    </table>
</form>
</body>
</html>
