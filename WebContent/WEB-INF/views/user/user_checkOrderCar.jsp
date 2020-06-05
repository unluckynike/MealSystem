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
<title>查看购物车</title>
<style>
body {
	background: linear-gradient(60deg, rgba(255, 165, 150, 0.01) 5%,
		rgba(208, 255, 0, 0.151)) 0% 0%/cover,
		url("https://cdn.jsdelivr.net/gh/unluckynike/blogimg/images/cutlery-2438718_1920.jpg"),
		url("https://cdn.jsdelivr.net/gh/unluckynike/blogimg/images/cutlery-2438718_1920.jpg")
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
				<div class="mybtn14_3" style="float: left; margin-left: 10px;">
					<a href="${pageContext.request.contextPath}/UserIndex.do"
						class="btn btn-success" style="">回到首页</a>
				</div>
				<div class="mybtn14_3" style="float: left; margin-left: 10px;">
					<a href="${pageContext.request.contextPath}/.do"
						class="btn btn-success" style="">确认下单</a>
				</div>
					<div class="mybtn14_3" style="float: left; margin-left: 10px;">
					<a href="${pageContext.request.contextPath}/.do"
						class="btn btn-success" style="">瞅瞅错误页面</a>
				</div>
			</div>
			<div class="alert alert-danger" role="alert">
				亲爱的用户【${userName}】这是您的购物车</div>
		</div>
	</div>

	<div class="container-md">

		<table class="table table-bordered">
			<thead class="thead-light">
				<tr>
					<th scope="col">菜名</th>
					<th scope="col">特色</th>
					<th scope="col">食材</th>
					<th scope="col">价格</th>
					<th scope="col">种类</th>
					<th scope="col">图片</th>
					<th scope="col">销量</th>
					<th scope="col">评价</th>
				</tr>
			</thead>
			<c:forEach items="${foodlist}" var="food" varStatus="vs">
				<tbody>
					<tr>
						<td scope="row">${food.foodnameString }</td>
						<td>${food.featureString }</td>
						<td>${food.materialString }</td>
						<td>${food.price }&nbsp;元</td>
						<td>${food.type }</td>
						<td><img
							src="${pageContext.request.contextPath}/${food.pictureString }"
							style="display: block; padding: 1px; background: white; border: 1px solid black;"></td>
						<td>${food.hits }</td>
						<td>${food.comment }</td>

					</tr>
				</tbody>
			</c:forEach>
		</table>
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