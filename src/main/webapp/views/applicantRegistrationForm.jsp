<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css"/>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript">
 $(function(){
  $("#datepicker").datepicker({
  	showOn:"both",
  	dateFormat:"dd/mm/yy"
  });
 });
</script>
<meta charset="ISO-8859-1">
<title>Applicant Registration</title>
</head>
<body>
<div><h1>APPLICANT REGISTRATION</h1></div>
	<br><br>
	<div>
		<div>
			<span style="color: green">${succMsg}</span>
			<span style="color: red">${failMsg}</span>
		</div>
		<form:form action="/registerApplicant" method="post" modelAttribute="applicant">
			<table>
				<tr>
					<td>First Name :</td>
					<td><form:input path="firstName"/></td>
				</tr>
				<tr>
					<td>Last Name : </td>
					<td><form:input path="lastName"/></td>
				</tr>
				<tr>
					<td>Email-ID :</td>
					<td><form:input path="emailId" id="email_id"/>
					<span id="emailErrMsg" style="color: red;"></span>
					</td>
				</tr>
				<tr>
					<td>Phone-No. :</td>
					<td><form:input path="phoneNo"/></td>
				</tr>
				<tr>
					<td>DOB :</td>
					<td><form:input path="dateOfBirth" id="datepicker"/></td>
				</tr>
				<tr>
					<td>Gender :</td>
					<td>
						<form:radiobutton path="gender" value="Female" label="FEMALE"/>
						<form:radiobutton path="gender" value="Male" label="MALE"/>
					</td>
				</tr>
				<tr>
					<td>SSN :</td>
					<td><form:input path="socialSecurityNo" /></td>
				</tr>
				<tr>
					<td align="center"><input type="reset" title="Reset"/></td>
					<td align="center"><input type="submit" id="regBtn" title="Register"/></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>