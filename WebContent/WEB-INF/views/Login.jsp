<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<meta name="description" content="">
<meta name="author" content="">
<meta name="csrf-token"
	content="fwthi2kFGosUpy0roUsNrGHt9BFbH5Sg4lWFt72p">

<!-- 网站icon，来自于Google开源图标 -->

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<title>登录</title>
<style type="text/css">
html, body {
	height: 100%;
}

body {
	display: -ms-flexbox;
	display: -webkit-box;
	display: flex;
	-ms-flex-align: center;
	-ms-flex-pack: center;
	-webkit-box-align: center;
	align-items: center;
	-webkit-box-pack: center;
	justify-content: center;
	padding-top: 40px;
	padding-bottom: 40px;
	background-color: #f5f5f5;
}

.form-signin {
	width: 100%;
	max-width: 330px;
	padding: 15px;
	margin: 0 auto;
}

.form-signin .checkbox {
	font-weight: 400;
}

.form-signin .form-control {
	position: relative;
	box-sizing: border-box;
	height: auto;
	padding: 10px;
	font-size: 16px;
}

.form-signin .form-control:focus {
	z-index: 2;
}

.form-signin input[type="email"] {
	margin-bottom: -1px;
	border-bottom-right-radius: 0;
	border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
	margin-bottom: 10px;
	border-top-left-radius: 0;
	border-top-right-radius: 0;
}
</style>
</head>
<body class="text-center" >

	<div class="card" style="min-width: 500px;">
		<div class="card-body">
			<form class="form-signin" method="POST" action="${pageContext.request.contextPath}/UserLogin.do">

				<h1 class="h3 mb-3 font-weight-normal">登录</h1>

				<input type="hidden" name="_token"
					value="fwthi2kFGosUpy0roUsNrGHt9BFbH5Sg4lWFt72p">

				<div class="text-left form-group bmd-form-group">
					<label for="username" class="bmd-label-floating">用户名</label> <input
						id="email" type="text" class="form-control" name="username" value=""
						required="" autofocus="">
				</div>

				<div class="text-left form-group bmd-form-group">
					<label for="password" class="bmd-label-floating">密码</label> <input
						id="password" type="password" class="form-control" name="password"
						required="">
				</div>

				<div class="form-group  bmd-form-group is-filled">
					<div class="checkbox mb-3">
						<label> <input type="checkbox" name="remember"><span
							class="checkbox-decorator"><span class="check"></span></span>
							下次自动登录
						</label>
					</div>
				</div>

				<button type="submit"
					class="btn btn-lg btn-primary btn-block btn-raised">登录</button>
				<a class="btn btn-link" href="${pageContext.request.contextPath}/Register.do" > 注册账号 </a> <a
					class="btn btn-link" href="#"> 找回密码? </a> <a class="btn btn-link"
					href="HomePages.do">返回首页 </a>

			</form>
		</div>
	</div>
			<%@ include file="include/footer.jsp"%>

	<script color="0,0,0" opacity="0.8" count="200"
		src="https://cdn.bootcss.com/canvas-nest.js/1.0.1/canvas-nest.js"
		type="text/javascript" charset="utf-8"></script>
	<script src="../../static/jquery.min.js"></script>
	<script src="../../static/popper.js"></script>
	<script src="../../static/bootstrap-material-design.js"></script>

</body>
</html>