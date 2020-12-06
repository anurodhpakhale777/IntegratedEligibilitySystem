<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Applicants</title>
</head>
<body>
	<div align="center">
        <table border="1">
            <caption>VIEW APPLICANTS</caption>
            <tr>
                <th>ApplicantID</th>
                <th>FirstName</th>
                <th>LastName</th>
                <th>DOB</th>
                <th>SSN</th>
                <th>Action</th>
            </tr>
            <c:forEach var="applicant" items="${applicantList}">
                <tr>
                    <td><c:out value="${applicant.applicantId}" /></td>
                    <td><c:out value="${applicant.firstName}" /></td>
                    <td><c:out value="${applicant.lastName}" /></td>
                    <td><c:out value="${applicant.dateOfBirth}" /></td>
                    <td><c:out value="${applicant.socialSecurityNo}" /></td>
                    <td>
                    	<a href="/editApplicant?applicantId=${applicant.applicantId}">Edit</a> 
                    	<a href="/deleteApplicant?applicantId=${applicant.applicantId}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>