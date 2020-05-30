<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<title>管理员首页</title>
</head>
<body>

	<%@ include file="../include/top.jsp"%>

	<ul class="nav nav-pills nav-justified">
		<li class="nav-item"><a class="nav-link active" href="UserList.do">用户管理</a>
		</li>
		<li class="nav-item"><a class="nav-link " href="#">身份：管理员</a></li>
		<li class="nav-item"><a class="nav-link active" href="FoodList.do">菜品管理</a>
		</li>
		<li class="nav-item"><a class="nav-link disabled" href="#"
			tabindex="-1" aria-disabled="true">退出</a></li>
	</ul>

	<%@ include file="../include/welcome.jsp"%>
	<%@ include file="../include/footer.jsp"%>

</body>
</html>