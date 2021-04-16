<%--
  Created by IntelliJ IDEA.
  User: theanh
  Date: 4/15/2021
  Time: 10:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/product?action=create" method="post">
    <table>
        <tr>
            <td>productName</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>price</td>
            <td><input type="text" name="price"></td>
        </tr>
        <tr>
            <td>quantity</td>
            <td><input type="text" name="quantity"></td>
        </tr>
        <tr>
            <td>color</td>
            <td><input type="text" name="color"></td>
        </tr>
        <tr>
            <td>typeID</td>
            <td><input type="text" name="typeID"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit"  vslue="Create"></td>
        </tr>
    </table>
</form>
</body>
</html>
