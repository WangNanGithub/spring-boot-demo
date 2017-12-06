<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Admin page</title>
	</head>
	<body>
		<h1>Dear <strong>${user}</strong>, Welcome to Admin Page.</h1>
		<br /><br />

		<a href="/home">普通用户首页</a>
		<br /><br />

		<a href="<c:url value="/logout" />">退出登录</a>
	</body>
</html>