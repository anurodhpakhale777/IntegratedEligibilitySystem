<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Determine Eligibility</title>
</head>
<body>
	<div><h1>ELIGIBILITY DETERMINATION</h1></div>
	<br><br>
	<div>
		<div>
			<span style="color: red">${failMsg}</span>
		</div>
		<form:form action="determineEligibility" method="post">
			<table>
				<tr>
					<td>Case-ID :</td>
					<td><form:input path="caseId" readonly="true"/></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" title="Determine Eligibility"/></td>
				</tr>
			</table>
		</form:form>
	</div>
	<div>
		<% if(null != request.getAttribute("planInfo"))
			{ %>
			<table>
				<tr>
					<td>Plan Name :</td>
					<td>${planInfo.planName}</td>
				</tr>
				<tr>
					<td>Plan Status :</td>
					<td>${planInfo.planStatus}</td>
				</tr>
				<tr>
					<td>Plan Start Date : </td>
					<td>${planInfo.planStartDate}</td>
				</tr>
				<tr>
					<td>Plan End Date :</td>
					<td>${planInfo.planEndDate}</td>
				</tr>
				<tr>
					<td>Benefit Amount : </td>
					<td>${planInfo.benefitAmt}</td>
				</tr>
				<tr>
					<td>Denial Reason : </td>
					<td>${applicant.denialReason}</td>
				</tr>
			</table>
		<%} %>
	</div>
</body>
</html>