<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Plan</title>
</head>
<body>
<div><h1>PLAN REGISTRATION</h1></div>
	<br><br>
	<div>
		<div>
			<span style="color: green">${succMsg}</span>
			<span style="color: red">${failMsg}</span>
		</div>
		<form:form action="/savePlan" method="post" modelAttribute="plan">
			<table>
				<tr>
					<td>Plan Name :</td>
					<td><form:input path="planName"/></td>
				</tr>
				<tr>
					<td>Plan Description : </td>
					<td><form:input path="planDesc"/></td>
				</tr>
				<tr>
					<td>Plan Start Date :</td>
					<td><form:input path="planStartDate"/></td>
				</tr>
				<tr>
					<td>Plan End Date :</td>
					<td><form:input path="planEndDate"/></td>
				</tr>
				<tr>
					<td align="center"><input type="reset" title="Reset"/></td>
					<td align="center"><input type="submit" id="regBtn" title="Create Plan"/></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>