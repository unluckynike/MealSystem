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
<title>用户信息</title>
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
						<h6 class="card-subtitle mb-2 text-muted">输入下列信息用以修改&nbsp;【${username}】&nbsp;的基本资料</h6>
						<c:forEach items="${updateuser}" var="user" varStatus="vs">
							<form
								action="${pageContext.request.contextPath}/UserUpdateInfor.do"
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
	<script color="0,0,0" opacity="0.8" count="100"
		src="https://cdn.bootcss.com/canvas-nest.js/1.0.1/canvas-nest.js"
		type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript" pointColor="255,64,64" color="1,90,230"
		opacity='1' zIndex="-1" count="100"
		src="https://cdn.bootcdn.net/ajax/libs/canvas-nest.js/2.0.4/canvas-nest.js"></script>
	<script type="text/javascript" pointColor="255,64,64" color="255,64,64"
		opacity='1' zIndex="-1" count="100"
		src="https://cdn.bootcdn.net/ajax/libs/canvas-nest.js/2.0.4/canvas-nest.js"></script>
</body>
</html>