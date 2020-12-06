<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Education Details</title>
</head>
<body>
	<div><h1>EDUCATION DETAILS</h1></div>
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
					<td>Highest Qualification : </td>
					<td>
						<form:select path="qualification">
							<form:option value="POST-GRADUATION">POST-GRADUATION</form:option>
							<form:option value="GRADUATION">GRADUATION</form:option>
							<form:option value="HSSC">HSSC</form:option>
							<form:option value="SSC">SSC</form:option>
						</form:select>
					</td>
				</tr>
				<tr>
					<td>Completed Year :</td>
					<td><form:input path="completedYear" /></td>
				</tr>
				<tr>
					<td>Grade : </td>
					<td>
						<form:select path="qualification">
							<form:option value="Pass Class">PASS CLASS</form:option>
							<form:option value="Second Class">SECOND CLASS</form:option>
							<form:option value="First Class">FIRST CLASS </form:option>
							<form:option value="Distinction">DISTINCTION</form:option>
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