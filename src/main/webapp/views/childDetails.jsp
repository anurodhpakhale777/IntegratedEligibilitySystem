<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Child Details</title>
</head>
<body>
	<div><h1>ENTER CHILD DETAILS</h1></div>
	<br><br>
	<div>
		<div>
			<span style="color: red">${failMsg}</span>
		</div>
		<form:form action="saveCcapDetails" methodParam="post" modelAttribute="childDet" >
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
					<td align="center"><input type="submit" title="ADD"/></td>
				</tr>
			</table>
		</form:form>
	</div>
	<br><br>
	<div align="center">
        <table border="1">
            <caption>View Child Details</caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Gender</th>
                <th>DOB</th>
                <th>SSN</th>
                <th>Action</th>
            </tr>
            <c:forEach var="child" items="${childList}">
                <tr>
                    <td><c:out value="${child.id}" /></td>
                    <td><c:out value="${child.childName}" /></td>
                    <td><c:out value="${child.childGender}" /></td>
                    <td><c:out value="${child.childDob}" /></td>
                    <td><c:out value="${child.childSsn}" /></td>
                    <td>
                    	<a href="/editChild?id=${child.id}">Edit</a> 
                    	<a href="/deleteChild?id=${child.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <a href="next"><button>NEXT</button></a>
	</div>
</body>
</html>