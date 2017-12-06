<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Welcome page</title>
	</head>
	<body>
		<h1>Dear <strong>${user}</strong>, Welcome to Home Page.</h1>
		<br /><br />

		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<a href="/admin">管理员首页</a>
			<br /><br />
		</sec:authorize>

		<sec:authorize access="!hasRole('ROLE_ADMIN')">
			<a href="/admin">管理员首页 (权限不足)</a>
			<br /><br />
		</sec:authorize>


		<a href="<c:url value="/logout" />">退出登录</a>
	</body>
</html>