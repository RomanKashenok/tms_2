<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>User Info</title>
</head>
<body>
<%@include file="../../index.jsp"%>

<h1>${message}</h1>

<h2>Employees Information: </h2>

<c:forEach var="user" items="${users}">
    <table>
        <tr>
            <td>Id</td>
            <td>${user.id}</td>
        </tr>
        <tr>
        <tr>
            <td>Name</td>
            <td>${user.name}</td>
        </tr>
        <tr>
            <td>Surname</td>
            <td>${user.surname}</td>
        </tr>
        <tr>
            <td>username</td>
            <td>${user.username}</td>
        </tr>
        <tr>
            <td>Password</td>
            <td>${user.password}</td>
        </tr>
    </table>
    <br>
</c:forEach>


</body>
</html>