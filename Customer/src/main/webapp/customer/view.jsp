<%--
  Created by IntelliJ IDEA.
  User: tranchung
  Date: 18/04/2019
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>View Customer</title>
</head>
<body>
<form method="get">
    <h1>View Customer :<span>${requestScope["customer"].getName()}</span></h1>
    <a href="/customers">Back to list customer</a>
    <fieldset>
        <legend>View customer</legend>
        <table>
            <tr>
                <td>Name :</td>
                <td>${requestScope["customer"].getName()}</td>
            </tr>
            <tr>
                <td>Email :</td>
                <td>${requestScope["customer"].getEmail()}</td>
            </tr>
            <tr>
                <td>Address :</td>
                <td>${requestScope["customer"].getAddress()}</td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
