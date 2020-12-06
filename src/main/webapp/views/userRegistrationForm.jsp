<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script>
	/* $(document).ready(function() {
	    // check email availability on focus lost
	    $("#email_id").blur(function() {
	    	$("#emailErrMsg").text("");
	    	$.ajax({
	    		type: "GET",
		        url: "/checkemail?emailId="+$("#email_id").val(),
		        success: function(response){
		        	if(response == "DUPLICATE"){
		        		$("#emailErrMsg").text("Email-Id already taken");
		        		$("#regBtn").prop("disabled", true);
		        	}
		        	else{
		        		$("#regBtn").prop("disabled", false);
		        	}
		        }
	    	});
	    });
	}); */
</script>
</head>
<body>
	<div><h1>USER REGISTRATION</h1></div>
	<br><br>
	<div>
		<div>
			<span style="color: green">${succMsg}</span>
			<span style="color: red">${failMsg}</span>
		</div>
		<form:form action="/registerUser" method="post" modelAttribute="userAcc">
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
					<td><form:input path="dateOfBirth" /></td>
				</tr>
				<tr>
					<td>Gender :</td>
					<td>
						<form:radiobutton path="gender" value="Female" label="FEMALE"/>
						<form:radiobutton path="gender" value="Male" label="MALE"/>
					</td>
				</tr>
				<tr>
					<td>Password :</td>
					<td><form:password path="password" /></td>
				</tr>
				<tr>
					<td>Role :</td>
					<td>
						<form:select path="role">
							<form:option value="-" label="-- Select Role --"/>
							<form:option value="Case-Worker" label="Case-Worker"/>
							<form:option value="Admin" label="Admin"/>
						</form:select>	
					</td>
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