<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Select Plan</title>
</head>
<body>
	<div><h1>SELECT PLAN</h1></div>
	<br><br>
	<div>
		<div>
			<span style="color: red">${failMsg}</span>
		</div>
		<form:form action="/selectPlan" methodParam="post" modelAttribute="casePlan" >
			<table>
				<tr>
					<td>Case-ID :</td>
					<td><form:input path="caseId" readonly="true"/></td>
				</tr>
				<tr>
					<td>First Name :</td>
					<td><form:input path="firstName"/></td>
				</tr>
				<tr>
					<td>Last Name : </td>
					<td><form:input path="lastName"/></td>
				</tr>
				<tr>
					<td>Select Plan :</td>
					<td><form:select path="planName"/>
						<form:select path="planName" >
							<form:option value="-" label="-- Select Plan --"/>
							<form:options items="${planNames}"/>
						</form:select>
					</td>
				</tr>
				<tr>
					<td align="center"><input type="reset" title="Reset"/></td>
					<td align="center"><input type="submit" title="Next"/></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>