<%--
  Created by IntelliJ IDEA.
  User: tranchung
  Date: 18/04/2019
  Time: 08:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Delete Customer</title>
</head>
<body>
<h3>Do you want delete it?</h3>
<a href="/customers">Back to list</a>
<form method="post">
    <table>
        <tr>
            <td>Name :</td>
            <td>${requestScope['customer'].getName()}></td>
        </tr>
        <tr>
            <td>Email :</td>
            <td>${requestScope['customer'].getEmail()}></td>
        </tr>
        <tr>
            <td>Address :</td>
            <td>${requestScope['customer'].getAddress()}></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Delete"></td>
        </tr>
    </table>
</form>
</body>
</html>
