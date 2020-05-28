<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<title>查询用户</title>
</head>
<body>

	<%@ include file="../include/top.jsp"%>
	
	<form action="" method="post">
		<div class="input-group mb-3">
			<input type="text" class="form-control" placeholder="username"
				aria-label="Recipient's username" aria-describedby="basic-addon2">
			<div class="input-group-append">
				<input type="submit" class="btn btn-success" id="basic-addon2"
					value="查询用户">
			</div>
		</div>
	</form>

	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th scope="col">id</th>
				<th scope="col">用户名</th>
				<th scope="col">密码</th>
				<th scope="col">登录身份</th>
				<th scope="col">电话号码</th>
				<th scope="col">地址</th>
				<th scope="col">操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${queryuser}" var="user" varStatus="vs">  
			<tr>
				<th scope="row">${user.id}</th>
				<td>${user.usernameString}</td>
				<td>${user.passwordString}</td>
				<td>${user.identString}</td>
				<td>${user.telephoneString}</td>
				<td>${user.addressString}</td>
				<td><a herf="#" class="btn btn-danger">删除</a> <a herf="#"
					class="btn btn-primary">修改</a></td>
			</tr>
		</c:forEach>  
		</tbody>
	</table>



	<%@ include file="../include/footer.jsp"%>

</body>
</html>