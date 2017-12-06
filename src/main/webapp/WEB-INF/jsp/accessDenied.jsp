<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>AccessDenied page</title>
	</head>
	<body>
		<h1>Dear <strong>${user}</strong>, You are not authorized to access this page</h1>
		<h3>您好 : <strong>${user}</strong>, 没有 <strong>${url}</strong> 页面的访问权限</h3>
		<br /><br />

		<a href="${url}">跳回原访问地址</a>
		<br /><br />

		<a href="<c:url value="/logout" />">退出登录</a>
	</body>
</html>