<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Plans</title>
</head>
<body>
	<div align="center">
        <table border="1">
            <caption>View Plans</caption>
            <tr>
                <th>ID</th>
                <th>Plan-Name</th>
                <th>Plan-Description</th>
                <th>Plan Start Date</th>
                <th>Plan End Date</th>
                <th>Action</th>
            </tr>
            <c:forEach var="plan" items="${planList}">
                <tr>
                    <td><c:out value="${plan.planId}" /></td>
                    <td><c:out value="${plan.planName}" /></td>
                    <td><c:out value="${plan.planDesc}" /></td>
                    <td><c:out value="${plan.planStartDate}" /></td>
                    <td><c:out value="${plan.planEndDate}" /></td>
                    <td>
                    	<a href="/editPlan?planId=${plan.planId}">Edit</a>
                    	<a href="/deletePlan?planId=${plan.planId}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>