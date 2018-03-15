<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>index</h1>
	<h3>MemberController</h3>
	<form action="member/findMemberByKey" method="POST">
		<table border="1">
			<tr>
				<th colspan="2">findMemberByKey</th>
			</tr>
			<tr>
				<td>id</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"></td>
			</tr>
		</table>
	</form>
	<hr>
	<h3>MemberRestController</h3>
	<a href="memberRest/restfulExample1?id=1">restfulExample1</a><br>
	<a href="memberRest/restfulExample2">restfulExample2</a><br>
	<a href="memberRest/pathVariableExample/2">pathVariableExample</a><br>
	<a href="memberRest/restfulGetImageExample">restfulGetImageExample</a>
	<hr>
	<h3>ExtraController</h3>
	<a href="extra/getImageExample">getImageExample</a><br>
	<a href="extra/redirectExmaple1">redirectExmaple1</a><br>
	<a href="extra/redirectExample2">redirectExample2</a><br>
	<a href="extra/forwardExample">forwardExample</a><br>
	<a href="extra/modelAndViewExample">modelAndViewExample</a><br>
	<form action="extra/autoBoxingExample" method="POST">
		<table border="1">
			<tr>
				<th colspan="2">autoBoxingExample</th>
			</tr>
			<tr>
				<td>id</td>
				<td><input type="text" name="id" value="1"></td>
			</tr>
			<tr>
				<td>account</td>
				<td><input type="text" name="account" value="ACCOUNT@gmail.com"></td>
			</tr>
			<tr>
				<td>password</td>
				<td><input type="text" name="password" value="PASSWORD"></td>
			</tr>
			<tr>
				<td>nickname</td>
				<td><input type="text" name="nickname" value="NICKNAME"></td>
			</tr>
			<tr>
				<td>createTime</td>
				<td><input type="text" name="createTime" value="2016-04-26 09:00:00"></td>
			</tr>
			<tr>
				<td>pass</td>
				<td><input type="text" name="pass" value="false"></td>
			</tr>
			<tr>
				<td>sessionId</td>
				<td><input type="text" name="sessionId" value="SESSION_ID"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"></td>
			</tr>
		</table>
	</form>
	<a href="extra/sendParameterByMapType">sendParameterByMapType</a><br>
	
	<form action="extra/uploadFileExample" method="POST" enctype="multipart/form-data">
		<table border="1">
			<tr>
				<th>uploadFileExample</th>
			</tr>
			<tr>
				<td><input type="file" name="files"></td>
			</tr>
			<tr>
				<td><input type="file" name="files"></td>
			</tr>
			<tr>
				<td><input type="submit"></td>
			</tr>
		</table>
	</form>
	<a href="extra/exceptionTest">exceptionTest</a><br>
	<a href="extra/log4jExample">log4jExample</a><br>
</body>
</html>