<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Income Details</title>
</head>
<body>
	<div><h1>INCOME DETAILS</h1></div>
	<br><br>
	<div>
		<div>
			<span style="color: red">${failMsg}</span>
		</div>
		<form:form action="saveKtWorkDetails" methodParam="post" modelAttribute="educationDet" >
			<table>
				<tr>
					<td>Case-ID :</td>
					<td><form:input path="caseId" readonly="true"/></td>
				</tr>
				<tr>
					<td>Individual's Name :</td>
					<td><form:input path="applicantName"/></td>
				</tr>
				<tr>
					<td>Is Working Employee : </td>
					<td><form:input path="otherIncome" /></td>
				</tr>
				<tr>
					<td>Other Income :</td>
					<td><form:input path="otherIncome" /></td>
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