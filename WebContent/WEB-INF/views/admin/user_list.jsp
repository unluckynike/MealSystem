<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<title>用户管理</title>
<style>
.mybtn14_3 {
	line-height: 32px;
	height: 32px;
}

.mybtn14_3 a {
	color: #fff;
}
</style>
</head>
<body>

	<%@ include file="../include/top.jsp"%>

	<div class="container">
		<div class="row">
			<div class="col-sm">

				<form action="${pageContext.request.contextPath}/UserListQuery.do"
					method="post">
					<div class="input-group mb-3">
						<input type="text" name="searchuser" class="form-control"
							placeholder="username" aria-label="Recipient's username"
							aria-describedby="basic-addon2">
						<div class="input-group-append">
							<input type="submit" class="btn btn-success" id="basic-addon2"
								value="查询用户">
						</div>
					</div>
				</form>

			</div>
			<div class="col-sm">
				<div class="mybtn14_3" style="float:left">
					<a href="${pageContext.request.contextPath}/UserListAdd.do" class="btn btn-success" style="">添加新用户</a>
				</div>
				<div class="mybtn14_3" style="float:left;margin-left:10px;">
					<a href="${pageContext.request.contextPath}/BackAdminIndex.do" class="btn btn-success" style="">回到首页</a>
				</div>
				
			</div>
		          <div class="alert alert-danger" role="alert">
                                                  每次进行完管理操作（添加新用戶、修改、删除）请点击查询用户按钮以确认
                 </div>
		</div>
	</div>

<div class="container-fluid">
	<table class="table table-bordered ">
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
					<td>
						<form
							action="${pageContext.request.contextPath}/UserListDelete.do"
							method="post">
							<input type=hidden name=id value="${user.id}"> <input
								type="submit" class="btn btn-danger" value="删除">
						</form>

						<form action="${pageContext.request.contextPath}/UserListUpdate.do"
						      method="post" style="margin-top: 10px;">
							<input type=hidden name=id value="${user.id}"> <input
								type="submit" class="btn btn-primary" value="修改">
						</form>
					</td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>	
	<!--  
	<c:if test="${(sessionScope.ID > 0 )}">
		<script>
			alert("删除成功");
		</script>
	</c:if>
-->
	<%@ include file="../include/footer.jsp"%>

</body>
</html>