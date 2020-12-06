<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Child</title>
</head>
<body>
	<div><h1>EDIT CHILD DETAILS</h1></div>
	<br><br>
	<div>
		<div>
			<span style="color: red">${failMsg}</span>
		</div>
		<form:form action="updateChild" methodParam="post" modelAttribute="childDet" >
			<table>
				<tr>
					<td>Child-ID :</td>
					<td><form:input path="caseId" readonly="true"/></td>
				</tr>
				<tr>
					<td>Individual's Name :</td>
					<td><form:input path="applicantName" readonly="true"/></td>
				</tr>
				<tr>
					<td>Child Name :</td>
					<td><form:input path="childName"/></td>
				</tr>
				<tr>
					<td>Child Gender :</td>
					<td>
						<form:radiobutton path="gender" value="Female" label="FEMALE"/>
						<form:radiobutton path="gender" value="Male" label="MALE"/>
					</td>
				</tr>
				<tr>
					<td>Child DOB :</td>
					<td><form:input path="childDob" /></td>
				</tr>
				<tr>
					<td>Child SSN :</td>
					<td><form:input path="childSsn" /></td>
				</tr>
				
				<tr>
					<td align="center"><input type="reset" title="Reset"/></td>
					<td align="center"><input type="submit" title="Update"/></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>