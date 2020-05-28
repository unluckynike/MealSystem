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
<title>注册</title>
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
<body>

<div class="card" style="min-width: 500px;">
		<div class="card-body">
			<form class="form-signin" method="POST" action="${pageContext.request.contextPath}/UserRegister.do">

				<h1 class="h3 mb-3 font-weight-normal">注册</h1>

				<input type="hidden" name="_token"
					value="fwthi2kFGosUpy0roUsNrGHt9BFbH5Sg4lWFt72p">

				<div class="text-left form-group bmd-form-group">
					<label for="username" class="bmd-label-floating">用户名</label> <input
						id="username" type="text" class="form-control" name="username" value=""
						required="" autofocus="">
				</div>

				<div class="text-left form-group bmd-form-group">
					<label for="password" class="bmd-label-floating">密码</label> <input
						id="password" type="password" class="form-control" name="password"
						required="">
				</div>
				
				<div class="text-left form-group bmd-form-group">
					<label for="password" class="bmd-label-floating">确认密码</label> <input
						id="password" type="password" class="form-control" name="password"
						required="">
				</div>
				
				<div class="text-left form-group bmd-form-group">
					<label for="telephone" class="bmd-label-floating">电话号码</label> <input
						id="telephone" type="text" class="form-control" name="telephone"
						required="">
				</div>
				
				<div class="text-left form-group bmd-form-group">
					<label for="address" class="bmd-label-floating">住址</label> <input
						id="address" type="text" class="form-control" name="address"
						required="">
				</div>
				

				<button type="submit"
					class="btn btn-lg btn-primary btn-block btn-raised">确认注册</button>
					<button type="reset"
					class="btn btn-lg btn-primary btn-block btn-raised">重置</button>
				<a class="btn btn-link" href="${pageContext.request.contextPath}/Login.do" > 去登录 </a> <a
					href="#"> 返回首页 </a>

			</form>
		</div>
	</div>

			<%@ include file="include/footer.jsp"%>



	<script src="../../static/jquery.min.js"></script>
	<script src="../../static/popper.js"></script>
	<script src="../../static/bootstrap-material-design.js"></script>

</body>
</html>