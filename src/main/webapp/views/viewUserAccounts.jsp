<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Accounts</title>
</head>
<body>

	<div align="center">
        <table border="1">
            <caption>View Accounts</caption>
            <tr>
                <th>ID</th>
                <th>FirstName</th>
                <th>LastName</th>
                <th>Email</th>
                <th>Role</th>
                <th>Action</th>
            </tr>
            <c:forEach var="userAcc" items="${userAccList}">
                <tr>
                    <td><c:out value="${userAcc.id}" /></td>
                    <td><c:out value="${userAcc.firstName}" /></td>
                    <td><c:out value="${userAcc.lastName}" /></td>
                    <td><c:out value="${userAcc.emailId}" /></td>
                    <td><c:out value="${userAcc.role}" /></td>
                    <td>
                    	<a href="/editAccount?id=${userAcc.id}">Edit</a> 
                    	<a href="/deleteAccount?id=${userAcc.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>