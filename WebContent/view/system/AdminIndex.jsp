<%@page import="org.apache.jasper.tagplugins.jstl.core.Import"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
th, tr, td, table {
	border: 1px;
	solid: red;
}
</style>

</head>
<body>
	<h1>
		管理员登录
		<h1>

			<table>
				<th>name</th>
				<th>password</th>
				<th>email</th>
				<c:forEach items="${key_list}" var="usr" varStatus="idx">
					<tr>
						<td>${usr.name}</td>
						<td>${usr.password}</td>
						<td>${usr.password}</td>
					</tr>
				</c:forEach>

			</table>
</body>
</html>