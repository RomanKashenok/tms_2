<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
  <title>Developer</title>
</head>
<body>

<h2>Enter user information</h2>
<form:form method="post" modelAttribute="userOb" action="/result" >
  <table>
    <tr>
      <td><form:label path="id">Id</form:label></td>
      <td><form:input path="id" /></td>
    </tr>
    <tr>
      <td><form:label path="name">Name</form:label></td>
      <td><form:input path="name" /></td>
    </tr>
    <tr>
      <td><form:label path="surname">Surname</form:label></td>
      <td><form:input path="surname" /></td>
    </tr>
    <tr>
      <td colspan="2">
        <input type="submit" value="Submit"/>
      </td>
    </tr>
  </table>
</form:form>
</body>
</html>