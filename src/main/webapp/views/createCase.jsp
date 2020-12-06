<%@page import="org.springframework.beans.BeanUtils"%>
<%@page import="com.jrtp.ies.dc.model.CaseDetail"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Case</title>
</head>
<body>
<div align="center"><h1>CREATE CASE</h1></div>
	<br><br>
	<div align="center">
		<div>
			<span style="color: red">${failMsg}</span>
		</div>
		<form action="/searchApplicant">
			<input type="text" name="applicantId">
			<input type="submit" value="Search">
		</form>
		
		<% if(null != request.getAttribute("case"))
			{ %>
		<form:form action="/createCase" method="post" modelAttribute="case">
			<table>
				<tr>
					<td>ApplicantID :</td>
					<td>${applicant.applicantId}</td>
				</tr>
				<tr>
					<td>First Name :</td>
					<td>${applicant.firstName}</td>
				</tr>
				<tr>
					<td>Last Name : </td>
					<td>${applicant.lastName}</td>
				</tr>
				<tr>
					<td>Email-ID :</td>
					<td>${applicant.emailId}</td>
				</tr>
				<tr>
					<td>Phone-No. : </td>
					<td>${applicant.phoneNo}</td>
				</tr>
				<tr>
					<td>DOB : </td>
					<td><form:input path="dateOfBirth" value="${applicant.dateOfBirth}"/></td>
				</tr>
				<tr>
					<td>Gender : </td>
					<td>${applicant.gender}</td>
				</tr>
				<tr>
					<td>SSN : </td>
					<td>${applicant.socialSecurityNo}</td>
				</tr>
				<tr>
					<td align="center"><input type="reset" title="Reset"/></td>
					<td align="center"><input type="submit" id="regBtn" value="Create Plan"/></td>
				</tr>
			</table>
			<form:hidden path="applicantId" value="${applicant.applicantId}"/>
			<form:hidden path="firstName" value="${applicant.firstName}"/>
			<form:hidden path="lastName" value="${applicant.lastName}"/>
			<form:hidden path="emailId" value="${applicant.emailId}"/>
			<form:hidden path="phoneNo" value="${applicant.phoneNo}"/>
			<%-- <form:hidden path="dateOfBirth" value="${applicant.dateOfBirth}"/> --%>
			<form:hidden path="gender" value="${applicant.gender}"/>
			<form:hidden path="socialSecurityNo" value="${applicant.socialSecurityNo}"/>
		</form:form>
		<%} %>
	</div>
</body>
</html>