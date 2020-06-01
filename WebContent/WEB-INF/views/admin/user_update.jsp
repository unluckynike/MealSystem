<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<title>修改用户</title>
<style type="text/css">
body {
	background: linear-gradient(60deg, rgba(255, 165, 150, 0.01) 5%,
		rgba(208, 255, 0, 0.151)) 0% 0%/cover,
		url("https://cdn.jsdelivr.net/gh/unluckynike/blogimg/images/wineglass-553467_1920.jpg"),
		url("https://cdn.jsdelivr.net/gh/unluckynike/blogimg/images/wineglass-553467_1920.jpg")
		0px 0px;
	background-attachment: fixed;
	margin: 0;
	color: #34495e;
}
</style>
</head>
<body>

	<%@ include file="../include/top.jsp"%>

	<div class="container">
		<div class="row">
			<div class="col-sm"></div>
			<div class="col-sm">

				<div class="card" style="width: 30rem;">
					<div class="card-body">
						<h5 class="card-title">修改用户</h5>
						<h6 class="card-subtitle mb-2 text-muted">输入下列信息用以修改点餐系统使用者&nbsp;【${username}】&nbsp;的信息</h6>
						<c:forEach items="${updateuser}" var="user" varStatus="vs">
							<form
								action="${pageContext.request.contextPath}/UserListUpdateDo.do"
								method="post">
								<div class="input-group input-group-lg"
									style="margin-top: 20px;">
									<div class="input-group-prepend">
										<span class="input-group-text" id="inputGroup-sizing-lg">用户名</span>
									</div>
									<input type="text" name="username" class="form-control"
										aria-label="Sizing example input"
										aria-describedby="inputGroup-sizing-lg"
										value="${user.usernameString}">
								</div>

								<div class="input-group input-group-lg"
									style="margin-top: 20px;">
									<div class="input-group-prepend">
										<span class="input-group-text" id="inputGroup-sizing-lg">密码</span>
									</div>
									<input type="text" name="password" class="form-control"
										aria-label="Sizing example input"
										aria-describedby="inputGroup-sizing-lg"
										value="${user.passwordString}">
								</div>

								<div class="input-group mb-4" style="margin-top: 20px;">
									<div class="input-group-prepend">
										<label class="input-group-text" for="inputGroupSelect01">登录身份</label>
									</div>
									<select class="custom-select" name="ident">
										<option value="0">普通用户</option>
										<option value="1">管理员</option>
									</select>
								</div>

								<div class="input-group input-group-lg"
									style="margin-top: 20px;">
									<div class="input-group-prepend">
										<span class="input-group-text" id="inputGroup-sizing-lg">电话号码</span>
									</div>
									<input type="text" name="telephone" class="form-control"
										aria-label="Sizing example input"
										aria-describedby="inputGroup-sizing-lg"
										value="${user.telephoneString}">
								</div>

								<div class="input-group input-group-lg"
									style="margin-top: 20px;">
									<div class="input-group-prepend">
										<span class="input-group-text" id="inputGroup-sizing-lg">地址</span>
									</div>
									<input type="text" name="address" class="form-control"
										aria-label="Sizing example input"
										aria-describedby="inputGroup-sizing-lg"
										value="${user.addressString}">
								</div>

								<div style="margin-top: 20px;">
									<input type=hidden name=id value="${user.id}"> <input
										type="submit" class="btn btn-success" value="确认修改"
										style="margin-right: 20px;"> <input type="reset"
										class="btn btn-primary" value="重置">
								</div>
							</form>
						</c:forEach>

					</div>
				</div>

			</div>

		</div>
	</div>


	<%@ include file="../include/footer.jsp"%>

</body>
</html>