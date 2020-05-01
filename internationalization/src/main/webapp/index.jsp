<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="m" uri="/WEB-INF/mytag.tld" %>
<c:set var="language" value="${request.language}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="message" />

<c:set var="loginMsg" value="TEEEEST" />

<!DOCTYPE html>
<html>
<head>
    <title>JSP/JSTL i18n demo</title>
</head>
<body>
<nav>
    <a href="/login?lang=es">ES |</a>
    <a href="/login?lang=it">IT</a>
</nav>

<h2><fmt:message key="msg.hello" /></h2>

<p><fmt:message key="msg.login.text" /></p>
<br>
<p>${QWE}</p>
<br>

<form method="post" action="/login">
    <label for="username"><fmt:message key="msg.login" />:</label>
    <input type="text" id="username" name="username">
    <br>
    <label for="password"><fmt:message key="msg.password" />:</label>
    <input type="password" id="password" name="password">
    <br>

    <button type="submit">ОТПРАВИТЬ</button>
</form>

<br>
<br>
<p>${loginMsg}</p>
<br>
<br>
<m:copy />
<m:test >name</m:test>
<br>
<p>${FILTER}</p>

</body>
</html>