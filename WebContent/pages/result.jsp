<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Result</title>
</head>
<body>
	<h1>result</h1>
	<h3>${message}</h3>
	<hr>
	<c:if test="${not empty member}">
		<table border="1">
			<tr>
				<th>id</th>
				<th>account</th>
				<th>password</th>
				<th>nickname</th>
				<th>createTime</th>
				<th>pass</th>
				<th>sessionId</th>
			</tr>
			<tr>
				<td>${member.id}</td>
				<td>${member.account}</td>
				<td>${member.password}</td>
				<td>${member.nickname}</td>
				<td>${member.createTime}</td>
				<td>${member.pass}</td>
				<td>${member.sessionId}</td>
			</tr>
		</table>
	</c:if>
</body>
</html>