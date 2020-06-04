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
<title>用首页</title>
</head>
<body>

	<%@ include file="../include/top.jsp"%>
	<ul class="nav nav-pills nav-justified">
		<li class="nav-item"><a class="nav-link active"
			href="UserOrder.do">去点餐</a></li>
		<li class="nav-item"><a class="nav-link " href="#">用户:&nbsp;${username}</a></li>
		<li class="nav-item"><a class="nav-link active" href="UserCheckOrder.do">查看购物车</a></li>
		<li class="nav-item"><a class="nav-link " href="UserInfor.do">个人资料</a></li>
		<li class="nav-item"><a class="nav-link active" href="Exit.do">退出</a></li>
	</ul>

	<%@ include file="../include/footer.jsp"%>

</body>
</html>